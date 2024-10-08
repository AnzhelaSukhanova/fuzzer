// Original bug: KT-22705

class WInvoke {
    operator fun invoke(body: () -> Unit) { }
}

class Second {
    val testInvoke = WInvoke()
}

fun boo(s: Second, body: () -> Unit) { }

fun foo(s: Second) {
    boo(s) {
        s.testInvoke {
            "Hello"
        }
    }
}
