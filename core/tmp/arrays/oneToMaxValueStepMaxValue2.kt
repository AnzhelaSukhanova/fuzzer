// Auto-generated by GenerateSteppedRangesCodegenTestData. Do not edit!
// DONT_TARGET_EXACT_BACKEND: WASM
// KJS_WITH_FULL_RUNTIME
// WITH_RUNTIME
import kotlin.test.*

fun box(): String {
    val uintList = mutableListOf<UInt>()
    val uintProgression = 1u..UInt.MAX_VALUE
    for (i in uintProgression step Int.MAX_VALUE) {
        uintList += i
    }
    assertEquals(listOf(1u, 2147483648u, UInt.MAX_VALUE), uintList)

    val ulongList = mutableListOf<ULong>()
    val ulongProgression = 1uL..ULong.MAX_VALUE
    for (i in ulongProgression step Long.MAX_VALUE) {
        ulongList += i
    }
    assertEquals(listOf(1uL, 9223372036854775808uL, ULong.MAX_VALUE), ulongList)

    return "OK"
}