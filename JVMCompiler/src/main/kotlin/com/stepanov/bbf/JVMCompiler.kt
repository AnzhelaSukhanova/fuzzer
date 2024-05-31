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
import java.io.File

open class JVMCompiler: CommonCompiler(VertxAddresses.JVMCompiler) {

//    private val compiler = K2JVMCompiler() // TODO: make it in CommonCompiler, can't figure suitable type

    override fun start() {
        log.debug("Started JVMCompiler")
        super.start()
    }

    override fun executeCompilationCheck(project: ProjectMessage, previousVersion: Boolean): KotlincInvokeResult {
        val args = prepareArgs(project, project.dir, previousVersion)
        val hasTimeout = !executeCompiler {
            MsgCollector.clear()
            val services = Services.EMPTY
            val compiler = K2JVMCompiler()
            compiler.exec(MsgCollector, services, args)
        }
        val crashComment = MsgCollector.crashMessages.map { it.replace("\n", "\n//") }
        val errorComment = MsgCollector.compileErrorMessages.map { it.replace("\n", "\n//") }
        val status = KotlincInvokeStatus(
            "//" + crashComment.joinToString("\n") +
                    errorComment.joinToString("\n"),
            !MsgCollector.hasCompileError,
            MsgCollector.hasException,
            hasTimeout,
            CompilationArgs()
        )
        return KotlincInvokeResult(project, listOf(status), previousVersion)
    }

    override fun checkCompiling(project: ProjectMessage): KotlincInvokeResult =
        executeCompilationCheck(project)

    // TODO: add some additional arguments maybe
    private fun prepareArgs(project: ProjectMessage, destination: String, previousVersion: Boolean = false): K2JVMCompilerArguments {
        CompilerArgs.previousVersion = previousVersion
        val projectArgs = K2JVMCompilerArguments()
        val compilerArgs = "${getAllPathsInLine(project)} -d $destination".split(" ")
        projectArgs.apply { K2JVMCompiler().parseArguments(compilerArgs.toTypedArray(), this) }
        projectArgs.classpath =
            "${CompilerArgs.jvmStdLibPaths().joinToString(
                separator = ":"
            )}:${System.getProperty("java.class.path")}"
                .split(":")
                .filter { it.isNotEmpty() }
                .toSet().toList()
                .joinToString(":")
        projectArgs.jvmTarget = "1.8"
        projectArgs.optIn = arrayOf("kotlin.ExperimentalStdlibApi", "kotlin.contracts.ExperimentalContracts")
        return projectArgs
    }

}