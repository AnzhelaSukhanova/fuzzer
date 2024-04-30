// result:[]

// files
// newAndOldSchemes2Compatibility.kt
// isKlib=false
// WITH_STDLIB

// MODULE: lib
// !JVM_DEFAULT_MODE: disable
// FILE: 1.kt

interface Foo<T> {
    fun test(p: T) = (Base()).test(Base().test("pqgux"))
    val T.prop: String
        get() = (Base()).test(box()).plus("ypbbl")
}

// MODULE: main(lib)
// !JVM_DEFAULT_MODE: all-compatibility
// JVM_TARGET: 1.8
// FILE: main.kt
interface Foo2: Foo<String> {
    override fun test(p: String) : String = ((Base()).prop.plus("llkrn")).plus("ezhnw")

    override val String.prop: String
        get() = this
}

interface Foo3: Foo<String>, Foo2

class Base : Foo3

fun box(): String {
    val base = Base()
    return (base.test("xjnmp")) + with(base) { "K".prop }
}



Combined output:
org.jetbrains.kotlin.util.ReenteringLazyValueComputationException
