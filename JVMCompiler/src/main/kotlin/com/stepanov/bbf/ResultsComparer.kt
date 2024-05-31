@file:JvmName("ResultsComparer")

package com.stepanov.bbf

import com.stepanov.bbf.information.CompilerArgs
import com.stepanov.bbf.messages.FileData
import com.stepanov.bbf.messages.KotlincInvokeResult
import com.stepanov.bbf.messages.ProjectMessage
import org.apache.log4j.Logger
import org.apache.log4j.PropertyConfigurator
import java.io.File

val jvmCompiler = JVMCompiler()
val crashPrefix = "Combined output:"

fun commentStackTrace() {
    TODO()
}

fun getMessages(file: File, result: KotlincInvokeResult): Pair<String, String> {

    fun format(fileText: String): String {
        val trace = if (fileText.contains("Exception while analyzing expression")) {
            val tracePart1 = fileText.substringAfterLast("causeThrowable\n").substringBefore("//----")
            val tracePart2 = "//\tat" + fileText.substringAfterLast("//----").substringAfter("//\tat")
            tracePart1 + tracePart2
        } else
            fileText.substringAfterLast("$crashPrefix\n")
        val idRegex = Regex("@([0-9]|[a-z])*")
        val fileRegex = Regex("\n//File being compiled: .*\n")
        val resultTrace = trace.replace(idRegex, "").replace(fileRegex, "\n")
        return resultTrace.lines().take(20).joinToString("\n")
    }

    val oldStackTrace = format(file.readText())
    val newStackTrace = format(result.results[0].combinedOutput)
    return Pair(oldStackTrace, newStackTrace)
}

fun main() {
    PropertyConfigurator.configure(
        System.getProperty("user.home") +
            "fuzzer/JVMCompiler/src/main/resources/comparerLog4j.properties")

    val absoluteResultsDir = "${System.getProperty("user.home")}fuzzer/core/tmp/results/curBugs"
    log.info("Comparison with ${System.getenv("kotlin_previous_version")}")
    File(absoluteResultsDir).walkTopDown().filter { it.isFile }.forEach { file ->
        val absoluteFileName = file.absolutePath
        var fileText = file.readText()
        if (!fileText.contains("//$crashPrefix")) {
            val crashText = "//$crashPrefix" + fileText.substringAfterLast("Combined output:").lines().joinToString("\n//")
            fileText = fileText.substringBefore("Combined output:") + crashText
            file.writeText(fileText)
        }
        val projectToCompile = ProjectMessage(
            listOf(FileData(file.name, fileText)),
            absoluteResultsDir)
        val result = jvmCompiler.executeCompilationCheck(projectToCompile, previousVersion = true)

        val messages = getMessages(file, result)
        if (!result.hasCompilerCrash)
            log.info("No crashes: $absoluteFileName")
        else if (messages.first != messages.second) {
            log.info("Another problem: $absoluteFileName")
            log.info(messages.first)
            log.info(messages.second)
        }
    }
    log.info("The end")
}

private val log: Logger = Logger.getLogger("comparerLogger")
