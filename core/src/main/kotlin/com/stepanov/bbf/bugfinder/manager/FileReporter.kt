package com.stepanov.bbf.bugfinder.manager

import com.stepanov.bbf.information.CompilerArgs
import java.io.File
import java.util.*

object FileReporter : Reporter {

    private fun currentTime(): String {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH) + 1
        val day = c.get(Calendar.DAY_OF_MONTH)
        val hour = c.get(Calendar.HOUR_OF_DAY)
        val minute = c.get(Calendar.MINUTE)
        val second = c.get(Calendar.SECOND)
        val ms = c.get(Calendar.MILLISECOND)
        return "$year-$month-${day}_$hour-$minute-$second-$ms"
    }

    fun getMessage(bug: Bug): String {
        val info = StringBuilder()
        bug.result.results.forEach {
            info.appendLine("// ${it.arguments}")
        }
        val messages = bug.result.results.joinToString(
            prefix = "//Combined output:\n",
            separator = "//====================\n") { it.combinedOutput }
        return "$info\n${bug.project.moveAllCodeInOneFile()}\n\n$messages"
    }

    override fun dump(bug: Bug): String {
        val resDir = CompilerArgs.resultsDir
        val name = currentTime()
        val newPath = "$resDir/$name.kt"
        File(newPath.substringBeforeLast('/')).mkdirs()

        val message = getMessage(bug)

        File(newPath).writeText(message)
        return newPath
    }
}