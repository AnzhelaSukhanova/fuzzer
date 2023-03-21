package com.stepanov.bbf.messages

import kotlinx.serialization.Serializable

@Serializable
class KotlincInvokeStatus(
    val combinedOutput: String,
    val isCompileSuccess: Boolean,
    val hasException: Boolean,
    val hasTimeout: Boolean,
) {
    fun hasCompilerCrash(): Boolean = hasTimeout || hasException

    fun hasCompilationError(): Boolean = !isCompileSuccess

    companion object {
        val statusWithoutErrors = KotlincInvokeStatus("", true, false, false)
    }

}

@Serializable
class CompilationResult(
    val compiler: String,
    val invokeStatus: KotlincInvokeStatus,
    val request: CompilationRequest
)