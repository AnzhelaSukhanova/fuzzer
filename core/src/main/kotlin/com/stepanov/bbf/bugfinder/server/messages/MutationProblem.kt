package com.stepanov.bbf.bugfinder.server.messages

import com.stepanov.bbf.bugfinder.mutator.transformations.Constants
import com.stepanov.bbf.bugfinder.mutator.transformations.Transformation
import com.stepanov.bbf.information.VertxAddresses
import com.stepanov.bbf.messages.FileData
import com.stepanov.bbf.messages.ProjectMessage
import com.stepanov.bbf.util.WeightedList
import com.stepanov.bbf.util.getSimpleNameFile
import kotlinx.serialization.*
import kotlinx.serialization.json.Json
import java.io.File
import kotlin.reflect.KClass
import kotlin.reflect.full.primaryConstructor


@Serializable
data class MutationProblem(
    val compilers: List<String>,
    val allowedTransformations: AllowedTransformations,
    val mutationTarget: MutationTarget,
    val mutationCount: Int = 0,
    val repeatInf: Boolean = false,
    val mutateInOrder: Boolean = false,
) {
    var completedMutations = 0

    fun isFinished(): Boolean {
        if (repeatInf)
            return false
        return completedMutations >= mutationCount
    }

    fun isNotFinished() = !isFinished()

    fun getNextTransformationAndIncreaseCounter(): Transformation =
        if (mutateInOrder) {
            listOfTransformations.at(completedMutations % listOfTransformations.size())
        } else {
            listOfTransformations.getRandom()
        }?.callConstructor().also { completedMutations++ } ?: error("Shouldn't be null")

    fun getProjectMessage() = mutationTarget.createProjectMessage()

//    fun getProjectMessage() = ProjectMessage(
//        listOf(
//            FileData("myKlib.kt", """
//                fun box() {
//                    val x = 5
//                }
//            """.trimIndent(), isKlib = true),
//            FileData("myFile.kt", """
//                fun main() {
//                    box()
//                }
//            """.trimIndent())
//        )
//    )

    private val listOfTransformations: WeightedList<TransformationClass>
        get() {
            if (allowedTransformations is All)
                return Constants.allTransformations
            if (allowedTransformations is TransformationsList)
                return WeightedList(allowedTransformations.transformationsList, 100.0)
            error("wtf")
        }

    fun validate() {
        if (compilers.isEmpty()) {
            throw IllegalArgumentException("No target compilers defined")
        }
        compilers.forEach { address ->
            when (address) {
                VertxAddresses.JVMCompiler, VertxAddresses.NativeCompiler -> {}
                else -> throw IllegalArgumentException("Unknown compiler target: $address")
            }
        }
        if (mutationCount < 0) {
            throw IllegalArgumentException("mutationCount should be positive or 0, but it equals $mutationCount")
        }
        if (listOfTransformations.isEmpty()) {
            throw IllegalArgumentException("List of allowed transformations is empty")
        }
    }

}

@Serializable
sealed class AllowedTransformations

@Serializable
@SerialName("All")
object All: AllowedTransformations()

@Serializable
@SerialName("Some")
data class TransformationsList(val transformationsList: List<TransformationClass>): AllowedTransformations()

@Serializable(with = TransformationClassSerializer::class)
data class TransformationClass(val clazz: KClass<out Transformation>) {
    fun callConstructor(): Transformation {
        return clazz.primaryConstructor!!.call()
    }
}

@Serializable
sealed class MutationTarget {
    abstract fun createProjectMessage(): ProjectMessage
}

@Serializable
sealed class SingleSourceTarget: MutationTarget() {

    override fun createProjectMessage(): ProjectMessage {
        if (this is RandomFileTarget)
            this.updateRandomFile()
        else if (this is RegressionTarget)
            this.updateFile()
        writeFile()
        return ProjectMessage(listOf(FileData(simpleFileName(), getSourceCode())))
    }

    fun simpleFileName(): String = getLocalName().getSimpleNameFile()

    abstract fun getSourceCode(): String

    abstract fun getLocalName(): String

    fun writeFile() {
        val fileName = getLocalName()
        File(fileName.substringBeforeLast("/")).mkdir()
            File(fileName).writeText(getSourceCode())
    }
}

@Serializable
@SerialName("regressions")
class RegressionTarget: SingleSourceTarget() {
    private var tmpFileName = weightedRandomTmpFileName()

    private val code
        get() = File("tmp/arrays/$tmpFileName").readText()
    private val name
        get() = "projectTmp/$tmpFileName"

    override fun getLocalName(): String = name

    override fun getSourceCode(): String = code


    private fun weightedRandomTmpFileName() = WeightedProjects.fileToWeight.getRandom()


    fun updateFile() {
        tmpFileName = weightedRandomTmpFileName()
    }
}

@Serializable
@SerialName("random")
class RandomFileTarget: SingleSourceTarget() {
    private var tmpFileName = randomTmpFileName()

    private val code
        get() = File("tmp/arrays/$tmpFileName").readText()
    private val name
        get() = "projectTmp/$tmpFileName"

    override fun getLocalName(): String = name

    override fun getSourceCode(): String = code

    private fun randomTmpFileName() =
        getAllKtFiles("tmp/arrays/")?.random()!!.name

    fun updateRandomFile() {
        tmpFileName = randomTmpFileName()
    }
}

@Serializable
@SerialName("code")
class SourceFileTarget(val code: String): SingleSourceTarget() {
    override fun getLocalName(): String = "projectTmp/tmp.kt"

    override fun getSourceCode(): String = code
}

@Serializable
@SerialName("name")
class NameFileTarget(val name: String): SingleSourceTarget() {
    private val copiedFileName =
        "projectTmp/${name.getSimpleNameFile()}"
    private val code = File(name).readText()

    override fun getLocalName(): String = copiedFileName

    override fun getSourceCode(): String = code

}

@Serializable
@SerialName("project")
data class ProjectTarget(
//    val projectRoot: String,
    val files: List<NameFileTarget>,
    val args: String = ""
): MutationTarget() {

    override fun createProjectMessage(): ProjectMessage {
        writeProject()
        return ProjectMessage(files.map { FileData(it.getLocalName(), it.getSourceCode())})
    }

    fun writeProject() {
        files.forEach { it.writeFile() }
    }
}

object WeightedProjects {
    var fileToWeight = WeightedList<String>(emptyList()).apply {
        val prioritizedFilenames = getAllKtFiles("tmp/arrays/changedAfter1.8.0")!!.map { "changedAfter1.8.0/${it.name}" }
        val filenames = (getAllKtFiles("tmp/arrays/")!!.map { it.name } + prioritizedFilenames)
        for (filename in filenames.shuffled()) {
            if (filename.contains("changedAfter1.8.0"))
                this.add(filename, 10.0)
            else
                this.add(filename, 1.0)
        }
    }

    fun reduceWeight(filename: String): Double {
        return fileToWeight.multiply(filename, 0.5)
    }
}

fun parseMutationProblem(data: String): MutationProblem =
    Json.decodeFromString<MutationProblem>(data).also { it.validate() }

fun getAllKtFiles(pathname: String): List<File>? =
    File(pathname).listFiles()?.filter { it.path.endsWith(".kt") }
