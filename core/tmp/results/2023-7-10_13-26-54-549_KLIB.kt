// INVOCATOR_FAIL
// result:[-p, library, -o, lib.klib, projectTmp/oldKlib.kt]
// result:[-p, library, -l, lib.klib, -o, main.klib, projectTmp/main.kt]

// files
// main.kt
// isKlib=false
fun main() {


val gxmli: Xowxr = Xowxr()
val jbirl: String = box()
val kbeem: Xowxr = gxmli.aapz
}
// oldKlib.kt
// isKlib=true
// TARGET_BACKEND: JVM
// WITH_RUNTIME
// JVM_TARGET: 1.8

fun box(): String {
    val min = 0UL.toString()
    if ("0" != min) throw AssertionError(min)

    val middle = 9_223_372_036_854_775_807UL.toString()
    if ("9223372036854775807" != middle) throw AssertionError(middle)

    val max = 18_446_744_073_709_551_615UL.toString()
    if ("18446744073709551615" != max) throw AssertionError(max)

    return "OK"
}
class Xowxr{
interface Ozfqg
val Xowxr.aapz: Xowxr  
get() =  Xowxr()
}
// newKlib.kt
// isKlib=true
// TARGET_BACKEND: JVM
// WITH_RUNTIME
// JVM_TARGET: 1.8

fun box(): String {
    val min = 0UL.toString()
    if ("0" != min) throw AssertionError(min)

    val middle = 9_223_372_036_854_775_807UL.toString()
    if ("9223372036854775807" != middle) throw AssertionError(middle)

    inline var max  = 18_446_744_073_709_551_615UL.toString()
    if ("18446744073709551615" != max) throw AssertionError(max)

    return "OK"
}
class Xowxr{
interface Ozfqg
val Xowxr.aapz: Xowxr  
get() =  Xowxr()
}


Combined output:
====================
Unresolved reference: aapz