package com.stepanov.bbf.bugfinder.mutator

import com.intellij.openapi.util.Disposer
import com.stepanov.bbf.bugfinder.mutator.transformations.*
import com.stepanov.bbf.bugfinder.mutator.vertxMessages.MutationResult
import com.stepanov.bbf.bugfinder.mutator.vertxMessages.MutationStrategy
import com.stepanov.bbf.information.VertxAddresses
import com.stepanov.bbf.reduktor.parser.PSICreator
import io.vertx.core.AbstractVerticle
import org.apache.log4j.Logger
import java.io.File
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeoutException
import kotlin.random.Random
import kotlin.system.measureTimeMillis

class Mutator: AbstractVerticle() {

    override fun start() {
        establishConsumers()
    }

    private fun establishConsumers() {
        vertx.eventBus().consumer<MutationStrategy>(VertxAddresses.mutate) { msg ->
            try {
                val strategy = msg.body()
                log.debug("Got mutation strategy#${strategy!!.number}")
                startMutate(strategy)
                log.debug("Sending back project, mutated by mutation strategy #${strategy.number}")

//                strategy.project.files.map { it.psiFile.project }.distinct().forEach {
//                    Disposer.dispose(it)
//                }
            } catch(e: Throwable) {
                log.debug("Caught exception while mutating: ${e.stackTraceToString()}")
                msg.fail(1, e.message)
            }
        }
    }

    private fun executeMutation(t: Transformation) {
        if (Random.nextInt(0, 100) < t.probPercentage) {
            //Update ctx
            t.updateCtx()
            t.ctx ?: return
            log.debug("Cur transformation ${t::class.simpleName}")
            t.execTransformations()
            t.file.changePsiFile(t.file.text)
        }
    }

    private fun startMutate(strategy: MutationStrategy) {
        log.debug("Starting mutating for strategy #${strategy.number}")
        val initial = strategy.transformations.first().file.copy()
        val initialText = initial.text
        val threadPool = Executors.newCachedThreadPool()
        strategy.transformations.forEach { transformation ->

            var finished = 0
            var changed = 0
            var failedWithException = 0
            var timeouts = 0
            val exceptionsBuilder = StringBuilder()
            val time = measureTimeMillis {
                repeat(MagicConst) {
                    val futureExitCode = threadPool.submit {
                        executeMutation(transformation)
                    }
                    try {
//                        executeMutation(transformation)
                        futureExitCode.get(timeoutSeconds, TimeUnit.SECONDS)
                        finished++
                        if (transformation.file.text != initialText) {
                            changed++
                        }
                    } catch (e: TimeoutException) {
                        timeouts++
                        futureExitCode.cancel(true)
                    } catch (e: Throwable) {
                        failedWithException++
                        exceptionsBuilder.append(e.message + "\n\n")
                    } finally {
                        transformation.file = initial
                    }
                }
            }
            val avgTime = time / MagicConst / 1000
            val result = """
                transformation=${transformation.javaClass.simpleName}
                file=${transformation.project.realFileName}
                finished=$finished
                changed=$changed
                failed with exception=$failedWithException
                timeout of ${timeoutSeconds} seconds=$timeouts
                average time=$avgTime seconds
                
                exceptions:
                
                $exceptionsBuilder
            """.trimIndent()
            val fileName = transformation.javaClass.simpleName + "___" + transformation.project.realFileName + ".txt"
            File("stats/$fileName").writeText(result)
        }
    }

    private val timeoutSeconds = 30L
    private val MagicConst = 20

    private val log = Logger.getLogger("mutatorLogger")
}
