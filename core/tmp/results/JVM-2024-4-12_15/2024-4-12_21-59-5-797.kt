// result:[]

// files
// newAndOldSchemes2Compatibility.kt
// isKlib=false
// WITH_STDLIB

// MODULE: lib
// !JVM_DEFAULT_MODE: disable
// FILE: 1.kt

interface Foo<T> {
    fun test(p: T) = (Base()).test(Base().test("kabnp"))
    val T.prop: String
        get() = "mywpd"
}

// MODULE: main(lib)
// !JVM_DEFAULT_MODE: all-compatibility
// JVM_TARGET: 1.8
// FILE: main.kt
interface Foo2: Foo<String> {
    override fun test(p: String) : String = p!!

    override val String.prop: String
        get() = Base().test("kabnp")
}

interface Foo3: Foo<String>, Foo2

class Base : Foo3

fun box(): String {
    val base = base
    return 
val h = true
try
{(Base())}
catch(e: Exception){}
finally{}
.test(Base().test("kabnp"))
}



Combined output:
org.jetbrains.kotlin.util.ReenteringLazyValueComputationException
