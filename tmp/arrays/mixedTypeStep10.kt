// Auto-generated by GenerateSteppedRangesCodegenTestData. Do not edit!
// DONT_TARGET_EXACT_BACKEND: WASM
// KJS_WITH_FULL_RUNTIME
// WITH_RUNTIME
import kotlin.test.*

fun box(): String {
    val uintList = mutableListOf<UInt>()
    for (i in 7.toUByte() downTo 1.toUByte() step 2) {
        uintList += i
    }
    assertEquals(listOf(7u, 5u, 3u, 1u), uintList)

    return "OK"
}