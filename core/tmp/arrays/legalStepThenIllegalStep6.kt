// Auto-generated by GenerateSteppedRangesCodegenTestData. Do not edit!
// DONT_TARGET_EXACT_BACKEND: WASM
// KJS_WITH_FULL_RUNTIME
// WITH_RUNTIME
import kotlin.test.*

fun box(): String {
    assertFailsWith<IllegalArgumentException> {
        val uintProgression = 1u until 8u
        for (i in uintProgression step 2 step 0) {
        }
    }

    assertFailsWith<IllegalArgumentException> {
        val ulongProgression = 1uL until 8uL
        for (i in ulongProgression step 2L step 0L) {
        }
    }

    return "OK"
}