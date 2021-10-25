// Original bug: KT-39775

// FLOW: IN
// WITH_RUNTIME

@JvmOverloads
fun foo(n: Int, s: String = "???") {

}

fun test() {
    foo(1)
    foo(1, "2")
    foo(1, s = "2")
    foo(n = 1, s = "2")
    foo(s = "2", n = 1)
}
