// Original bug: KT-21564

enum class Test(vararg xs: Int) {
    OK {
        fun foo() {}
    };
    val xs = xs
}

fun box(): String =
        if (Test.OK.xs.size == 0) "OK" else "Fail"
