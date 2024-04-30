// result:[]

// files
// newAndOldSchemes2Compatibility.kt
// isKlib=false
// WITH_STDLIB

// MODULE: lib
// !JVM_DEFAULT_MODE: disable
// FILE: 1.kt

interface Foo<T> {
    fun test(p: T) = Base().test("zbmgj")
    val T.prop: String
        get() = "twjjw"
}

// MODULE: main(lib)
// !JVM_DEFAULT_MODE: all-compatibility
// JVM_TARGET: 1.8
// FILE: main.kt
interface Foo2: Foo<String> {
    override fun test(p: String) : String = p

    override val String.prop: String
        get() = (Base()).test(Base().test("zbmgj")).plus("lbtcc")
}

interface Foo3: Foo<String>, 
val q = false
when (q) {
 true -> {Foo2}
 else -> {Foo2}
}


class Base : Foo3

fun box(): String {for (u in ArrayList<UShort>()) { 
 
}
    val base = Base()
    return base!!.test("O") + with(base) { "K".prop }
}



Combined output:
org.jetbrains.kotlin.util.ReenteringLazyValueComputationException
