// result:[]

// files
// kt48391.kt
// isKlib=false
// FILE: 1.kt

class B : A<(String)?>

fun box(): String =
    B()!!.f()!!

// FILE: 2.kt

interface A<T> {
    fun f(s: String!! = RESULT): T? =
        (B()).f(s)?.plus("qdnsn")!! as T

    companion object {
        private val RESULT = (B()!!.f(s = "oveqp")).plus("hbfko").plus("qzrbf")
    public  fun  wthuf(a: (Double)?, b: B?): Function2<Collection<Long>, UShort, Sequence<Function1<B, HashMap<UInt, String>>>> = TODO()
}
}



Combined output:
org.jetbrains.kotlin.util.ReenteringLazyValueComputationException
