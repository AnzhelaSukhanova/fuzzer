@file:JvmName("ResultsComparer")

package com.stepanov.bbf

import com.stepanov.bbf.messages.FileData
import com.stepanov.bbf.messages.KotlincInvokeResult
import com.stepanov.bbf.messages.KotlincInvokeStatus
import com.stepanov.bbf.messages.ProjectMessage
import org.apache.log4j.Logger
import org.apache.log4j.PropertyConfigurator
import java.io.File

val jvmCompiler = JVMCompiler()
const val previousLanguageVersion = "1.8"
const val currentLanguageVersion = "1.9"
const val crashPrefix = "Combined output:"

fun commentStackTrace() {
    TODO()
}

fun getMessages(result: KotlincInvokeResult, expectedResult: KotlincInvokeResult): Pair<String, String> {

    fun getMessage(status: KotlincInvokeStatus): String {
        val lines = status.combinedOutput.lines().take(15)
        return lines.joinToString("\n")
    }

    return Pair(getMessage(expectedResult.results[0]), getMessage(result.results[0]))
}

fun getMessages(file: File, result: KotlincInvokeResult, standaloneResult: KotlincInvokeResult): Triple<String, String, String> {

    fun getMessage(status: KotlincInvokeStatus): String {
        val lines = status.combinedOutput.substringAfter("exception: ").lines()
        return lines.joinToString(separator = "\n//", prefix = "//Combined output:\n//")
    }

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
        return resultTrace.lines().take(15).joinToString("\n")
    }

    val oldStackTrace = format(file.readText())
    val newStackTrace = format(result.results[0].combinedOutput)
    val newStandaloneStackTrace = format(getMessage(standaloneResult.results[0]))
    return Triple(oldStackTrace, newStackTrace, newStandaloneStackTrace)
}

fun main() {
    fun printResult(list: MutableList<String>, title: String) {
        list.sortWith(compareBy(String.CASE_INSENSITIVE_ORDER) { it })
        log.info("$title: [${list.joinToString(", ")}]")
    }

    PropertyConfigurator.configure(
        System.getProperty("user.home") +
            "/fuzzer/JVMCompiler/src/main/resources/comparerLog4j.properties")

    val absoluteResultsDir = "${System.getProperty("user.home")}/fuzzer/core/tmp/results/JVM-2024-4-12_2024-4-15"
    log.info("Comparison with $previousLanguageVersion")
    val bothPassed = mutableListOf<String>()
    val regressions = mutableListOf<String>()
    val other = mutableListOf<String>()

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
        val result = jvmCompiler.executeCompilationCheck(projectToCompile, previousLanguageVersion)
        val expectedResult = jvmCompiler.executeCompilationCheck(projectToCompile, currentLanguageVersion)
        val messages = getMessages(result, expectedResult)

        if (!result.hasCompilerCrash) {
            if (expectedResult.hasCompilerCrash)
                regressions.add(file.name)
            else
                bothPassed.add(file.name)
        }
        else other.add(file.name)
    }

    printResult(regressions, "Regressions")
    printResult(bothPassed, "Both passed")
    printResult(other, "Other")
}

private val log: Logger = Logger.getLogger("comparerLogger")
