// TARGET_BACKEND: JVM
// FULL_JDK
// WITH_RUNTIME
// WITH_COROUTINES
// CHECK_TAIL_CALL_OPTIMIZATION
import helpers.*
import kotlin.coroutines.*
import kotlin.coroutines.intrinsics.*

private var x = 100

private inline fun inlineFun(
    potentiallySuspendLambda: () -> Unit
) {
    if (x == 99) return
    potentiallySuspendLambda()
}

suspend fun myFunWithTailCall() = inlineFun(
    potentiallySuspendLambda = { suspendFun() }
)

suspend fun suspendFun(): Unit = suspendCoroutineUninterceptedOrReturn { x ->
    TailCallOptimizationChecker.saveStackTrace(x)
    COROUTINE_SUSPENDED
}

fun builder(c: suspend () -> Unit) {
    c.startCoroutine(EmptyContinuation)
}

fun box(): String {
    builder {
        myFunWithTailCall()
    }
    TailCallOptimizationChecker.checkNoStateMachineIn("myFunWithTailCall")
    return "OK"
}
