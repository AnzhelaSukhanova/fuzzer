// INVOCATOR_FAIL
// result:[-p, library, -o, lib.klib, projectTmp/oldKlib.kt]
// result:[-p, library, -l, lib.klib, -o, main.klib, projectTmp/main.kt]

// files
// main.kt
// isKlib=false
fun main() {


val jjpuh: Dadsh = Dadsh()
val ihnam: Cptme = Cptme()
val octuj: Lspwr = Lspwr()
val sgidr: String = box()
val vdkdb: Byte = qduww()
val bdnur: UInt = MaxUI
val gglvq: ULong = MaxUL
val efftc: Cptme = ihnam.edrb
}
// oldKlib.kt
// isKlib=true
// DONT_TARGET_EXACT_BACKEND: WASM
// KJS_WITH_FULL_RUNTIME
// Auto-generated by org.jetbrains.kotlin.generators.tests.GenerateRangesCodegenTestData. DO NOT EDIT!
// WITH_RUNTIME


val MaxUI = UInt.MAX_VALUE
val MaxUL = ULong.MAX_VALUE

fun box(): String {
    val list1  = ArrayList<UInt>()
    for (i in MaxUI..MaxUI) {
        list1.add(i)
        if (list1.size > 23) break
    }
    if (list1 != listOf<UInt>(MaxUI)) {
        return "Wrong elements for MaxUI..MaxUI: $list1"
    }

    val list2 = ArrayList<ULong>()
    for (i in MaxUL..MaxUL) {
        list2.add(i)
        if (list2.size > 23) break
    }
    if (list2 != listOf<ULong>(MaxUL)) {
        return "Wrong elements for MaxUL..MaxUL: $list2"
    }

    return "OK"
}
fun  qduww(): Byte { TODO() }
open class Dadsh{
interface Dkxrv
}
class Cptme{
protected val edrb: Cptme  = TODO()
}
class Lspwr
// newKlib.kt
// isKlib=true
// DONT_TARGET_EXACT_BACKEND: WASM
// KJS_WITH_FULL_RUNTIME
// Auto-generated by org.jetbrains.kotlin.generators.tests.GenerateRangesCodegenTestData. DO NOT EDIT!
// WITH_RUNTIME


val MaxUI = UInt.MAX_VALUE
val MaxUL = ULong.MAX_VALUE

fun box(): String {
    val list1  = ArrayList<UInt>()
    for (i in MaxUI..MaxUI) {
        list1.add(i)
        if (list1.size > 23) break
    }
    if (list1 != listOf<UInt>(MaxUI)) {
        return "Wrong elements for MaxUI..MaxUI: $list1"
    }

    val list2 = ArrayList<ULong>()
    for (i in MaxUL..MaxUL) {
        list2.add(i)
        if (list2.size > 23) break
    }
    if (list2 != listOf<ULong>(MaxUL)) {
        return "Wrong elements for MaxUL..MaxUL: $list2"
    }

    return "OK"
}
fun  qduww(): Byte { TODO() }
open class Dadsh{
interface Dkxrv
}
class Cptme{
protected val edrb: Cptme  = TODO()
}
class Lspwr{
protected val miuv: MutableMap<Float, Lspwr>  
get() = TODO()
}


Combined output:
====================
Cannot access 'edrb': it is protected in 'Cptme'