// result:[]

// files
// newAndOldSchemes2Compatibility.kt
// isKlib=false
// WITH_STDLIB

// MODULE: lib
// !JVM_DEFAULT_MODE: disable
// FILE: 1.kt

interface Foo<T> {
    fun test(p: T) = Base().test("iklmn")
    val T.prop: String
        get() = "gysdm"
}

// MODULE: main(lib)
// !JVM_DEFAULT_MODE: all-compatibility
// JVM_TARGET: 1.8
// FILE: main.kt
interface Foo2: Foo<String> {
    override fun test(p: String) : String = p!!

    override val String.prop: String
        get() = (Base()).test(box()).plus("lxrtt")
}

interface Foo3: Foo<String>, Foo2

class Base : Foo3

fun box(): String {
    val base = Base()
    return (Base()).prop + with(Base()) { t@for (j in (box()).length.rangeTo(70)) {

(box()).plus("nzivf")
 "yforx".prop
} }
}



Combined output:
org.jetbrains.kotlin.util.ReenteringLazyValueComputationException
