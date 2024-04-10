package com.stepanov.bbf.bugfinder.reducer

import com.stepanov.bbf.information.CompilerArgs
import java.io.File

object ResultsFilter {
    fun filter() {
        File(CompilerArgs.resultsDir).listFiles()!!.filter { it.isFile }.forEach { file ->
            if (file.readText().contains("Exception while analyzing expression") and !file.name.contains("FRONTEND"))
                file.renameTo(File("${CompilerArgs.resultsDir}/${file.nameWithoutExtension}_FRONTEND.kt"))
        }
        File(CompilerArgs.resultsDir).walkTopDown().forEach { file ->
            if (file.exists() && file.isFile) {
                if (file.readLines().size > 1000) {
                    file.delete()
                    return@forEach
                }

//                if (file.name.contains("_ORIGINAL")) {
//                    file.delete()
//                    return@forEach
//                }

                if (file.readText().contains("java.lang.OutOfMemoryError: Cannot reserve")) {
                    file.delete()
                    return@forEach
                }

                val stackTrace = extractStackTrace(file)
                if (stackTrace.count { it == '\n' } > 5) { // in empty stack trace not really interested right now
                    File(CompilerArgs.resultsDir).walkTopDown().filter { it.isFile }.forEach { other ->
                        if (other.name != file.name) {
                            val st2 = extractStackTrace(other)
                            if (stackTrace == st2) {
                                println("${other.name} -> ${file.name}")
                                other.delete()
                            }
                        }
                    }
                }
            }
        }
    }

    private fun extractStackTrace(file: File): String {
        val fileText = file.readText()
        var result = if (file.name.contains("FRONTEND")) {
            val tracePart1 = fileText.substringAfterLast("causeThrowable").substringBefore("----")
            val tracePart2 = "\tat" + fileText.substringAfterLast("----").substringAfter("\tat")
            tracePart1 + tracePart2
        }
        else
            fileText.substringAfterLast("Combined output:")
        val idRegex = Regex("@([0-9]|[a-z])*")
        result = result.replace(idRegex, "")
        return result
    }

    private fun deleteSourceFile(code: String) = code.substringBefore("com.stepanov.bbf")
}
