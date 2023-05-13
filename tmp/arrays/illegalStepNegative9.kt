// Auto-generated by GenerateSteppedRangesCodegenTestData. Do not edit!
// DONT_TARGET_EXACT_BACKEND: WASM
// KJS_WITH_FULL_RUNTIME
// WITH_RUNTIME
// KT-34166: Translation of loop over literal completely removes the validation of step
// DONT_TARGET_EXACT_BACKEND: JS
import kotlin.test.*

fun box(): String {
    assertFailsWith<IllegalArgumentException> {
        for (i in 1u until 8u step -1) {
        }
    }

    assertFailsWith<IllegalArgumentException> {
        for (i in 1uL until 8uL step -1L) {
        }
    }

    return "OK"
}