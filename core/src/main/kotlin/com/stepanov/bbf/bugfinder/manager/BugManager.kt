package com.stepanov.bbf.bugfinder.manager

import com.stepanov.bbf.bugfinder.util.StatisticCollector
import com.stepanov.bbf.information.CompilerArgs
import com.stepanov.bbf.information.VertxAddresses
import com.stepanov.bbf.messages.CompilationResult
import com.stepanov.bbf.messages.ProjectMessage
import io.vertx.core.AbstractVerticle
import org.apache.log4j.Logger
import java.io.File

enum class BugType {
    BACKEND,
    FRONTEND,
    DIFFBEHAVIOR,
    UNKNOWN,
    DIFFCOMPILE,
    DIFFABI,
    PERFORMANCE
}


internal fun bugType(result: CompilationResult): BugType =
    if (result.invokeStatus.combinedOutput.contains("Exception while analyzing expression"))
        BugType.FRONTEND
    else
        BugType.BACKEND

data class Bug(val results: List<CompilationResult>) {
    val project = results.first().project
}


class BugManager: AbstractVerticle() {

    private val bugs = mutableListOf<Bug>()

    override fun start() {
        establishConsumers()
        log.debug("Bug manager deployed")
    }

    private fun saveBug(bug: Bug) {

        try {
            log.debug("SAVING BUG")
            if (ReportProperties.getPropAsBoolean("SAVE_STATS") == true) saveStats()
            //Report bugs
            if (ReportProperties.getPropAsBoolean("FILE_REPORTER") == true) {

                FileReporter.dump(bug)
            }
        } catch (e: Exception) {
            log.debug("Exception ${e.localizedMessage} ${e.stackTraceToString()}\n")
            System.exit(1)
        }
    }

    private fun saveStats() {
        val f = File("bugsPerMinute.txt")
        val curText = StringBuilder(f.readText())
        val bugs = curText.split("\n").first().split(": ").last().toInt()
        val newText = curText.replaceFirst(Regex("\\d+\n"), "${bugs + 1}\n")
        f.writeText(newText)
    }

    private fun establishConsumers() {
        vertx.eventBus().consumer<List<CompilationResult>>(VertxAddresses.bugManager) { msg ->
            processCompilationResults(msg.body())
        }
    }

    private fun processCompilationResults(results: List<CompilationResult>) {
        if (isUnusualResult(results)) {
            log.debug("Found some interesting result")
        }
        saveBug(Bug(results))
    }

    private fun isUnusualResult(results: List<CompilationResult>): Boolean {
        if (results.distinctBy { it.invokeStatus.hasCompilerCrash() }.size > 1)
            return true
        if (results.distinctBy { it.invokeStatus.combinedOutput.substringBefore("\n") }.size > 1)
            return true
        return false
    }

    private val log = Logger.getLogger("bugManagerLogger")
}

