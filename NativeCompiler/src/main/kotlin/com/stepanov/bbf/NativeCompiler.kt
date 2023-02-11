package com.stepanov.bbf

import com.stepanov.bbf.information.VertxAddresses
import com.stepanov.bbf.messages.KotlincInvokeStatus
import com.stepanov.bbf.messages.ProjectMessage
import org.jetbrains.kotlin.cli.bc.K2Native
import org.jetbrains.kotlin.cli.common.arguments.K2NativeCompilerArguments
import org.jetbrains.kotlin.config.Services

class NativeCompiler: CommonCompiler(VertxAddresses.NativeCompiler) {

    private val compiler = K2Native()

    override fun start() {
        log.debug("Started Native Compiler")
        super.start()
    }

    override fun tryToCompile(project: ProjectMessage): KotlincInvokeStatus {
        val arguments = createArguments(project)
        val hasTimeout = !executeCompiler {
            val services = Services.EMPTY
            compiler.exec(MsgCollector, services, arguments)
        }
        val status = KotlincInvokeStatus(
            MsgCollector.crashMessages.joinToString("\n") +
                    MsgCollector.compileErrorMessages.joinToString("\n"),
            !MsgCollector.hasCompileError,
            MsgCollector.hasException,
            hasTimeout
        )
        return status
    }

    private fun createArguments(project: ProjectMessage): K2NativeCompilerArguments {
        val compilerArgumentsList = mutableListOf(
            "-kotlin-home", System.getenv("kotlin-home")
                ?: error("kotlin-home not specified in environment variables (should be in build.gradle)"),
            "-p", "library",
            "-o", project.outputDir + "result"
        )
        project.files.forEach { compilerArgumentsList.add(it.first) }
        val arguments = K2NativeCompilerArguments()
        K2Native().parseArguments(compilerArgumentsList.toTypedArray() , arguments)
        return arguments
    }


}