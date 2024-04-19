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

fun commentStackTrace() {
    TODO()
}

fun sameMessage(file: File, result: KotlincInvokeResult): Boolean {

    fun format(fileText: String): String {
        val trace = if (fileText.contains("Exception while analyzing expression")) {
            val tracePart1 = fileText.substringAfterLast("causeThrowable").substringBefore("//----")
            val tracePart2 = "//\tat" + fileText.substringAfterLast("//----").substringAfter("//\tat")
            tracePart1 + tracePart2
        } else
            fileText.substringAfterLast("Combined output:")
        val idRegex = Regex("@([0-9]|[a-z])*")
        return trace.replace(idRegex, "")
    }

    File("/home/Anzhela.Sukhanova/1.txt").writeText(result.results[0].combinedOutput)
    val fileText = file.readText()

    val oldStackTrace = format(file.readText())
    val newStackTrace =  format(result.results[0].combinedOutput)
    return oldStackTrace == newStackTrace
}

fun main() {
    PropertyConfigurator.configure(
        System.getProperty("user.home") +
            "fuzzer/JVMCompiler/src/main/resources/comparerLog4j.properties")

    val absoluteResultsDir = "${System.getProperty("user.home")}fuzzer/core/${CompilerArgs.resultsDir}/"
    log.info("Comparison with ${System.getenv("kotlin_jvm_version")}\n")

    File(absoluteResultsDir).walkTopDown().filter { it.isFile }.forEach { file ->
        val absoluteFileName = file.absolutePath
        val projectToCompile = ProjectMessage(
            listOf(FileData(file.name, file.readText())),
            absoluteResultsDir)
        val result = jvmCompiler.executeCompilationCheck(projectToCompile)

        if (!sameMessage(file, result)) {
            log.info("Another problem: $absoluteFileName")
            log.info(result.results[0].combinedOutput.lines().take(10).joinToString("\n"))
        }
        else if (!result.hasCompilerCrash)
            log.info("No crashes: $absoluteFileName")
    }
}

private val log: Logger = Logger.getLogger("comparerLogger")
