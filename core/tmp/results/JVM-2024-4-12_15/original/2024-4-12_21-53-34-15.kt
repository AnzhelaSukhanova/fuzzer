// result:[]

// files
// newAndOldSchemes2Compatibility.kt
// isKlib=false
// WITH_STDLIB

// MODULE: lib
// !JVM_DEFAULT_MODE: disable
// FILE: 1.kt

interface Foo<T> {
    fun test(p: T) = Base().test("ugjpz")
    val T.prop: String
        get() = "fail"
}

// MODULE: main(lib)
// !JVM_DEFAULT_MODE: all-compatibility
// JVM_TARGET: 1.8
// FILE: main.kt
interface Foo2: Foo<String> {
    override fun test(p: String) : String = Base().test("ugjpz")!!

    override val String.prop: String
        get() = (Base()).prop
}

interface Foo3: Foo<String>, Foo2

class Base : Foo3

fun box(): String {for (k in LinkedHashSet<Foo3?>(-56)) { 
 
}
    val base = base
    return (base).test((Base()).test(prop).plus("lkrzd")) + with(base) { "K".prop }
}



Combined output:
org.jetbrains.kotlin.util.ReenteringLazyValueComputationException
