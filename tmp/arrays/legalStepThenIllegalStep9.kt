// Auto-generated by GenerateSteppedRangesCodegenTestData. Do not edit!
// DONT_TARGET_EXACT_BACKEND: WASM
// KJS_WITH_FULL_RUNTIME
// WITH_RUNTIME
import kotlin.test.*

fun box(): String {
    assertFailsWith<IllegalArgumentException> {
        for (i in 7u downTo 1u step 2 step 0) {
        }
    }

    assertFailsWith<IllegalArgumentException> {
        for (i in 7uL downTo 1uL step 2L step 0L) {
        }
    }

    return "OK"
}