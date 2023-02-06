package com.stepanov.bbf.bugfinder.mutator

import com.stepanov.bbf.bugfinder.mutator.transformations.*
import com.stepanov.bbf.bugfinder.mutator.vertxMessages.MutationResult
import com.stepanov.bbf.bugfinder.mutator.vertxMessages.MutationStrategy
import com.stepanov.bbf.bugfinder.vertx.information.VertxAddresses
import io.vertx.core.AbstractVerticle
import org.apache.log4j.Logger
import java.lang.Thread.sleep
import kotlin.RuntimeException
import kotlin.random.Random

class Mutator: AbstractVerticle() {

    override fun start() {
        establishConsumers()
    }

    private fun establishConsumers() {
        vertx.eventBus().consumer<MutationStrategy>(VertxAddresses.mutate) { newStrategy ->
            val strategy = newStrategy.body()
            log.debug("Got mutation strategy#${strategy!!.number}")
            sleep(1000_000)
            startMutate(strategy)
            sendMutatedProject(strategy)
        }
//            .exceptionHandler { throwable ->
//            log.debug("""Caught an exception in mutator#$instanceNumber
//                | While mutating strategy#${strategy?.number}
//                | Exception: ${throwable.stackTraceToString()}
//            """.trimMargin())
//        }
    }

    private fun executeMutation(t: Transformation) {
        if (Random.nextInt(0, 100) < t.probPercentage) {
            //Update ctx
            t.updateCtx()
            t.ctx ?: TODO("Figure out why ctx can be null")
            log.debug("Cur transformation ${t::class.simpleName}")
            t.execTransformations()
            // TODO: send new file text
            t.file.changePsiFile(t.file.text)
        }
    }

    private fun sendMutatedProject(strategy: MutationStrategy) {
        log.debug("Sending back project, mutated by mutation strategy #${strategy.number}")
        vertx.eventBus().send(VertxAddresses.mutatedProject,
            MutationResult(strategy.project, strategy.number)
        )
    }

    private fun startMutate(strategy: MutationStrategy) {
        log.debug("Starting mutating for strategy #${strategy.number}")
        strategy.transformations.forEach {
            executeMutation(it)
        }
    }

    private val log = Logger.getLogger("mutatorLogger")
}
