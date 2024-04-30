// result:[]

// files
// newAndOldSchemes2Compatibility.kt
// isKlib=false
// WITH_STDLIB

// MODULE: lib
// !JVM_DEFAULT_MODE: disable
// FILE: 1.kt

interface Foo<T> {
    fun test(p: T) = (Base()).test(Base().test("asotu"))
    val T.prop: String
        get() = "fail"
}

// MODULE: main(lib)
// !JVM_DEFAULT_MODE: all-compatibility
// JVM_TARGET: 1.8
// FILE: main.kt
interface Foo2: Foo<String> {
    override fun test(p: String) : String = (Base()).prop

    override val String.prop: String
        get() = (Base().test("twihs")).stripTrailing()?.plus("uekdn")!!!!
}

interface Foo3: Foo<String>, Foo2

class Base : Foo3

fun box(): String {for (f in HashSet<Foo3>()) { 
 
}
    val base = Base()
    return (Base().test("moxph")).plus("ecnis")
}



Combined output:
org.jetbrains.kotlin.util.ReenteringLazyValueComputationException
