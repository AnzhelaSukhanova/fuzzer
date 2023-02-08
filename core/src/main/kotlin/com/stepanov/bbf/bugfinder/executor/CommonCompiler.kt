package com.stepanov.bbf.bugfinder.executor
import com.intellij.psi.PsiErrorElement
import com.stepanov.bbf.bugfinder.executor.project.LANGUAGE
import com.stepanov.bbf.bugfinder.executor.project.Project
import com.stepanov.bbf.bugfinder.mutator.transformations.Factory
import com.stepanov.bbf.bugfinder.util.MarkerLogger
import com.stepanov.bbf.bugfinder.vertx.codecs.CompilationResultCodec
import com.stepanov.bbf.bugfinder.vertx.codecs.ProjectCodec
import com.stepanov.bbf.bugfinder.vertx.information.VertxAddresses
import com.stepanov.bbf.bugfinder.vertx.serverMessages.ProjectMessage
import com.stepanov.bbf.reduktor.executor.CompilationResult
import com.stepanov.bbf.reduktor.executor.KotlincInvokeStatus
import com.stepanov.bbf.reduktor.parser.PSICreator
import com.stepanov.bbf.reduktor.util.MsgCollector
import com.stepanov.bbf.reduktor.util.getAllPSIChildrenOfType
import io.vertx.core.AbstractVerticle
import java.io.File
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeoutException



abstract class CommonCompiler(
    private val compileAddress: String
): AbstractVerticle() {

    override fun start() {
        establishConsumers()
        registerCodecs()
        log.debug("Compiler deployed")
    }

    abstract fun tryToCompile(project: ProjectMessage): KotlincInvokeStatus

    private fun registerCodecs() {
        vertx.eventBus().registerDefaultCodec(Project::class.java, ProjectCodec())
        vertx.eventBus().registerDefaultCodec(CompilationResult::class.java, CompilationResultCodec())
    }

    private fun establishConsumers() {
        val eb = vertx.eventBus()
        eb.consumer<ProjectMessage>(compileAddress) { msg ->
            log.debug("Got a project to compile")
            val project = msg.body()
            createLocalTmpProject(project)
            val compileResult = tryToCompile(project)
            deleteLocalTmpProject(project)
            log.debug("Sending back compile result")
            eb.send(
                VertxAddresses.compileResult,
                CompilationResult(
                    this::class.java.simpleName,
                    compileResult,
                    msg.body()
                )
            )
        }.exceptionHandler { throwable ->
            log.debug("""Caught an exception in compiler
                | Exception: ${throwable.stackTraceToString()}
            """.trimMargin())
        }
    }

    private fun createLocalTmpProject(project: ProjectMessage) {
        project.files.forEach { (name, text) ->
            File(name.substringBeforeLast("/")).mkdirs()
            File(name).writeText(text)
        }
        File(project.outputDir).mkdir()
    }

    private fun deleteLocalTmpProject(project: ProjectMessage) {
        project.files.forEach { (name, _) ->
            if (File(name).exists())
                File(name).deleteRecursively()
        }
        File(project.outputDir).deleteRecursively()
    }

    protected fun getAllPathsInLine(project: ProjectMessage): String {
        return project.files.map { it.first }.joinToString(" ")
    }

    protected fun executeCompiler(
        project: ProjectMessage,
        task: Runnable
    ): KotlincInvokeStatus {
        val threadPool = Executors.newCachedThreadPool()
        val futureExitCode = threadPool.submit(task)
        var hasTimeout = false
        var compilerWorkingTime: Long = -1
        try {
            val startTime = System.currentTimeMillis()
            futureExitCode.get(10L, TimeUnit.SECONDS)
            compilerWorkingTime = System.currentTimeMillis() - startTime
        } catch (ex: TimeoutException) {
            hasTimeout = true
            futureExitCode.cancel(true)
        } finally {
            deleteLocalTmpProject(project)
        }
        val status = KotlincInvokeStatus(
            MsgCollector.crashMessages.joinToString("\n") +
                    MsgCollector.compileErrorMessages.joinToString("\n"),
            !MsgCollector.hasCompileError,
            MsgCollector.hasException,
            hasTimeout,
            compilerWorkingTime,
            MsgCollector.locations.toMutableList()
        )
        return status
    }

    protected val log = MarkerLogger("compilerLogger", compileAddress)
}
