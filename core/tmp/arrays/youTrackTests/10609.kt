// Original bug: KT-3492

open class A {
    open val foo: String = "OK"
}

open class B : A() {
}

class C : B() {
    inner class D {
        val foo: String = super<B>@C.foo
    }
}

fun box() = C().D().foo
