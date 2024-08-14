package com.stepanov.bbf

import com.stepanov.bbf.information.CompilationArgs
import com.stepanov.bbf.information.CompilerArgs
import com.stepanov.bbf.information.VertxAddresses
import com.stepanov.bbf.messages.KotlincInvokeResult
import com.stepanov.bbf.messages.KotlincInvokeStatus
import com.stepanov.bbf.messages.ProjectMessage
import org.jetbrains.kotlin.cli.common.arguments.K2JVMCompilerArguments
import org.jetbrains.kotlin.cli.jvm.K2JVMCompiler
import org.jetbrains.kotlin.config.Services
import java.io.BufferedReader
import java.io.File
import java.io.InputStreamReader
import java.util.*

open class JVMCompiler: CommonCompiler(VertxAddresses.JVMCompiler) {

//    private val compiler = K2JVMCompiler() // TODO: make it in CommonCompiler, can't figure suitable type

    override fun start() {
        log.debug("Started JVMCompiler")
        super.start()
    }

    override fun executeCompilationCheck(project: ProjectMessage, version: String): KotlincInvokeResult {
        val statuses = mutableListOf<KotlincInvokeStatus>()
        val directory = "${System.getProperty("user.home")}/fuzzer/"
        val destination = "$directory/JVMCompiler/${project.dir}/"
        val args = prepareArgs(project, destination, version)
        var combinedOutput = ""
        var exitCode = 0
        project.files.forEach {
            // Something is freezing in this block: maybe the problem is in not reading the output stream
            val hasTimeout = !executeCompiler {
                val process = ProcessBuilder(
                    directory + "commandLineCompiler.sh",
                    version,
                    "-d $destination",
                    "-classpath ${args.classpath}",
                    directory + "core/" + project.dir + "/" + it.name).start()
                val reader = BufferedReader(InputStreamReader(process.errorStream))
                combinedOutput = reader.readText()
                exitCode = process.waitFor()
            }
            //
            val status = KotlincInvokeStatus(
                combinedOutput,
                exitCode == 0,
                exitCode == 2,
                hasTimeout,
                CompilationArgs()
            )
            statuses.add(status)
        }
        return KotlincInvokeResult(project, statuses, version)
    }

    override fun executeCompilationCheck(project: ProjectMessage): KotlincInvokeResult {
        val args = prepareArgs(project, "${System.getProperty("user.home")}/fuzzer/JVMCompiler/${project.dir}")
        val hasTimeout = !executeCompiler {
            MsgCollector.clear()
            val services = Services.EMPTY
            val compiler = K2JVMCompiler()
            compiler.exec(MsgCollector, services, args)
        }
        val crashComment = MsgCollector.crashMessages.map { it.replace("\n", "\n//") }
        val errorComment = MsgCollector.compileErrorMessages.map { it.replace("\n", "\n//") }
        val combinedOutput = "//" + crashComment.joinToString("\n") + errorComment.joinToString("\n")
        val status = KotlincInvokeStatus(
            combinedOutput,
            !MsgCollector.hasException,
            MsgCollector.hasException,
            hasTimeout,
            CompilationArgs()
        )
        return KotlincInvokeResult(project, listOf(status))
    }

    override fun checkCompiling(project: ProjectMessage): KotlincInvokeResult =
        executeCompilationCheck(project) // check for seeds and test infrastructure

    // TODO: add some additional arguments maybe
    private fun prepareArgs(project: ProjectMessage, destination: String, version: String? = null): K2JVMCompilerArguments {
        val projectArgs = K2JVMCompilerArguments()
        val compilerArgs = "${System.getProperty("user.home")}/fuzzer/JVMCompiler/${getAllPathsInLine(project)} -d $destination".split(" ")
        projectArgs.apply { K2JVMCompiler().parseArguments(compilerArgs.toTypedArray(), this) }
        projectArgs.classpath =
            "${CompilerArgs.jvmStdLibPaths(version).joinToString(
                separator = ":"
            )}:${System.getProperty("java.class.path")}"
                .split(":")
                .filter { it.isNotEmpty() }
                .toSet().toList()
                .joinToString(":")

        projectArgs.jvmTarget = "1.8"
        projectArgs.optIn = arrayOf("kotlin.ExperimentalStdlibApi", "kotlin.contracts.ExperimentalContracts")

        projectArgs.noReflect = true
        projectArgs.noStdlib = true
        projectArgs.useFirLT = false
        return projectArgs
    }

    private fun getArgList(destination: String): List<String> = listOf(
        "-d", destination,
        "-jvm-target", "1.8",
        "-opt-in", "kotlin.ExperimentalStdlibApi",
        "-opt-in", "kotlin.contracts.ExperimentalContracts",
        "-no-reflect",
        "-no-stdlib"
    )
}
