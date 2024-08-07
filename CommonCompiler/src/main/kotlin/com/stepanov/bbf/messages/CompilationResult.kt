package com.stepanov.bbf.messages

import com.stepanov.bbf.information.CompilationArgs
import com.stepanov.bbf.information.MutationStat
import kotlinx.serialization.Serializable

@Serializable
class KotlincInvokeStatus(
    val combinedOutput: String,
    val isCompileSuccess: Boolean,
    val hasException: Boolean,
    val hasTimeout: Boolean,
    val arguments: CompilationArgs,
) {
    fun hasCompilerCrash(): Boolean = hasException //|| hasTimeout

    fun hasCompilationError(): Boolean = !isCompileSuccess

    companion object {
//        val statusWithoutErrors = KotlincInvokeStatus("", true, false, false, listOf())
    }

}

@Serializable
class KotlincInvokeResult(
    val projectMessage: ProjectMessage,
    val results: List<KotlincInvokeStatus>,
    val version: String = "1.9"
) {
    val isCompileSuccess = results.all { it.isCompileSuccess }
    val hasCompilerCrash = results.any { it.hasCompilerCrash() }
}

@Serializable
class CompilationResult(
    val compiler: String,
    val results: List<KotlincInvokeResult>,
    val mutationStat: MutationStat,
)