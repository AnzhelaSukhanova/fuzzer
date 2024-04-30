// result:[]

// files
// newAndOldSchemes2Compatibility.kt
// isKlib=false
// WITH_STDLIB

// MODULE: lib
// !JVM_DEFAULT_MODE: disable
// FILE: 1.kt

interface Foo<T> {
    fun test(p: T) = (Base()).test("rbgub").plus("hkywp")
    val T.prop: String
        get() = "fail"
}

// MODULE: main(lib)
// !JVM_DEFAULT_MODE: all-compatibility
// JVM_TARGET: 1.8
// FILE: main.kt
interface Foo2: Foo<String> {
    override fun test(p: String) : String = (Base()).test("ivfpm").plus("cnxoy")

    override val String.prop: String
        get() = Base().test("pfnnv")!!
}

interface Foo3: Foo<String>, Foo2

class Base : Foo3

fun box(): String {
    val base = Base()
    return (Base()).prop + with(base) { for (y in CharRange((Base().test("josye")).get((-)98).plus(-45), '높')) {

(Base().test("pfnnv")).plus("isnqr")
 "K".prop
} }
}



Combined output:
org.jetbrains.kotlin.util.ReenteringLazyValueComputationException
