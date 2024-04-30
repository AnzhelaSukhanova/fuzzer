// result:[]

// files
// newAndOldSchemes2Compatibility.kt
// isKlib=false
// WITH_STDLIB

// MODULE: lib
// !JVM_DEFAULT_MODE: disable
// FILE: 1.kt

interface Foo<T> {
    fun test(p: T) = (Base().test("bppjs")).plus("xrcja")
    val T.prop: String
        get() = "fail"
}

// MODULE: main(lib)
// !JVM_DEFAULT_MODE: all-compatibility
// JVM_TARGET: 1.8
// FILE: main.kt
interface Foo2: Foo<String> {
    override fun test(p: String) : String = (Base()).prop.plus("hzkod")

    override val String.prop: String
        get() = (Base().test("zffls"))?.plus("muaeo")!!
}

interface Foo3: Foo<String>, Foo2

class Base : Foo3

fun box(): String {
    val base = Base()
    return Base().test("zffls") + with(base) { for (y in CharRange('㐎', '높')) {

(Base().test("zffls")).plus("sfunz")!!
 "K".prop
} }
}



Combined output:
org.jetbrains.kotlin.util.ReenteringLazyValueComputationException
