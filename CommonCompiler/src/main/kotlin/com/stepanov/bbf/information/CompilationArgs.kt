package com.stepanov.bbf.information

import com.stepanov.bbf.util.getSimpleFileNameWithoutExt
import kotlinx.serialization.Serializable
import java.util.Random

@Serializable
data class CompilationArgs(
    private var outputName: String = "",
    var klib: CompilationArgs? = null,
    private val files: MutableList<String> = mutableListOf(),
    private var isXPartialLinkage: Boolean = false,
    private var artifactType: String = "program",
    private var isK2: Boolean = false,
) {

    override fun toString(): String = """
    //    Compilation arguments
    //    outputName=$outputName
    //    isLinkedWithKlib=${klib != null}
    //    klib=$klib
    //    -Xpartial-linkage=$isXPartialLinkage
    //    -p=$artifactType
    """.trimIndent()

    fun build(): List<String> {
        val result = mutableListOf<String>()

        when(artifactType) {
            "library" -> result.addAll(listOf("-p", "library"))
            else -> {}
        }
        if (klib != null) {
            result.addAll(listOf("-l", klib!!.outputName))
        }
        if (isXPartialLinkage)
            result.add("-Xpartial-linkage")
        if (isK2)
            error("Kotlin/Native doesn't support K2")
        if (outputName.isNotBlank())
            result.addAll(listOf("-o", outputName))
        result.addAll(files)
        return result
    }

    fun addPartialLinkage(): CompilationArgs = also {
        isXPartialLinkage = true
    }


    fun addKlib(addedKlib: CompilationArgs) = also {
        klib = addedKlib
    }

    fun makeKlib() = also {
        artifactType = "library"
    }

    fun addFile(file: String) = also {
        files.add(file)
    }

    fun addFiles(files: List<String>) = also {
        files.forEach { addFile(it) }
    }

    private fun createOutputName() {
        outputName = files.first().getSimpleFileNameWithoutExt() +
                Random().nextInt() +
                when(artifactType) {
                    "program" -> ".kexe"
                    "library" -> ".klib"
                    else -> error("unkown artifact type $artifactType")
                }
    }

}