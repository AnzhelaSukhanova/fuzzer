// Original bug: KT-5182

open class A 

class B: A() {
    fun foo() = 1
}

fun foo(a: A) = when {
    a !is B -> 2
    true -> a.foo() //'foo' is unresolved, smart cast doesn't work
    else -> a.foo()
}
