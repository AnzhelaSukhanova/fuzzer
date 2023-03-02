package com.stepanov.bbf.bugfinder.mutator

import com.stepanov.bbf.bugfinder.mutator.transformations.*
import com.stepanov.bbf.bugfinder.mutator.vertxMessages.MutationResult
import com.stepanov.bbf.bugfinder.mutator.vertxMessages.MutationStrategy
import com.stepanov.bbf.information.VertxAddresses
import io.vertx.core.AbstractVerticle
import org.apache.log4j.Logger
import org.jetbrains.kotlin.backend.common.push
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeoutException
import kotlin.random.Random

class Mutator: AbstractVerticle() {

    override fun start() {
        establishConsumers()
    }

    private fun establishConsumers() {
        vertx.eventBus().consumer<MutationStrategy>(VertxAddresses.mutate) { msg ->
            try {
                val strategy = msg.body()
                log.debug("Got mutation strategy#${strategy!!.number}")
                val usefulTransformations = startMutate(strategy)
                log.debug("""Completed mutation for strategy#${strategy.number}: 
                    successfully mutated ${usefulTransformations.size} times
                """.trimIndent())
                sendMutationResult(MutationResult(strategy.project, strategy.number,
                    usefulTransformations, true))
            } catch(e: Throwable) {
                log.debug("Caught exception while mutating: ${e.stackTraceToString()}")
                msg.fail(1, e.message)
            }
        }
    }

    private fun executeMutation(t: Transformation) {
        if (Random.nextInt(0, 100) < t.probPercentage) {
            //Update ctx
            t.file.updateCtx()
            log.debug("Cur transformation ${t::class.simpleName}")
            t.execTransformations()
        }
    }

    private fun startMutate(strategy: MutationStrategy): List<String> {
        log.debug("Starting mutating for strategy #${strategy.number}")
        val threadPool = Executors.newCachedThreadPool()
        val usefulTransformationsList: MutableList<String> = mutableListOf()
        strategy.transformations.forEach { transformation ->
            val simpleName = transformation.javaClass.simpleName
            println("STARTING ${simpleName}")

            if (Random.nextInt(0, 100) < 30) {
                sendMutationResult(MutationResult(strategy.project, strategy.number,
                    usefulTransformationsList.toMutableList()))
            }

            val initialText = transformation.file.text
            val futureExitCode = threadPool.submit {
                executeMutation(transformation)
            }
            try {
                futureExitCode.get(TIMEOUT, TimeUnit.SECONDS)
                if (transformation.file.text != initialText) {
                    usefulTransformationsList.push(transformation.toString())
                    log.debug("$transformation succesfully mutated")
                }
            } catch (e: TimeoutException) {
                futureExitCode.cancel(true)
                log.debug("Timeout of $TIMEOUT seconds in ${simpleName}")
            } catch (e: Throwable) {
                log.debug("Caught exception in ${simpleName}: ${e.stackTraceToString()}")
            }
            println("FINISHING ${simpleName}")
        }
        return usefulTransformationsList
    }

    private fun sendMutationResult(mutationResult: MutationResult) {
        log.debug("Sending back project, mutated by mutation strategy #${mutationResult.strategyNumber}")
        vertx.eventBus().send(VertxAddresses.mutationResult, mutationResult)
    }

    private val log = Logger.getLogger("mutatorLogger")

    private val TIMEOUT = 30L
}
