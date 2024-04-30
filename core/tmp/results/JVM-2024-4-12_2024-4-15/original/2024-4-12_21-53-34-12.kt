// result:[]

// files
// newAndOldSchemes2Compatibility.kt
// isKlib=false
// WITH_STDLIB

// MODULE: lib
// !JVM_DEFAULT_MODE: disable
// FILE: 1.kt

interface Foo<T> {
    fun test(p: T) = (Base().test("dwbrh")).stripTrailing()?.plus("fzlnv")!!!!
    val T.prop: String
        get() = (Base().test("zreit")).stripLeading()?.plus("sbvne")!!
}

// MODULE: main(lib)
// !JVM_DEFAULT_MODE: all-compatibility
// JVM_TARGET: 1.8
// FILE: main.kt
interface Foo2: Foo<String> {
    override fun test(p: String) : String = ((Base().test("zreit")).plus("gscig")).plus((Base()).test(Base().test("dwbrh")))

    override val String.prop: String
        get() = Base().test("ylpij")
}

interface Foo3: Foo<String>, Foo2

class Base : Foo3

fun box(): String {
    val base = Base()
    return (Base()).test(Base().test("zreit")).plus("jviey")
}



Combined output:
org.jetbrains.kotlin.util.ReenteringLazyValueComputationException
