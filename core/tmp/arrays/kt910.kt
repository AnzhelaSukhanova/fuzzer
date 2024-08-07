// KJS_WITH_FULL_RUNTIME

// IGNORE_BACKEND: WASM
// WASM_MUTE_REASON: STDLIB_COLLECTIONS

fun foo() : Int =
    try {
        2
    }
    finally {
        "s"
    }

fun bar(set : MutableSet<Int>) : Set<Int> =
    try {
        set
    }
    finally {
        set.add(42)
    }

fun box() : String {
    if (foo() != 2) return "fail 1"
    val s = bar(HashSet<Int>())
    return if (s.contains(42)) "OK" else "fail 2"
}
