// WITH_STDLIB
// WORKS_WHEN_VALUE_CLASS
// LANGUAGE: +ValueClasses, +GenericInlineClassParameter

// TARGET_BACKEND: JVM
// IGNORE_BACKEND: JVM_IR
// Depends on KT-57973
// JVM_TARGET: 1.8

interface Path {
    fun dispatch(maxDepth: Int = 42)
    fun Int.extension(maxDepth: Int = 42)
}

OPTIONAL_JVM_INLINE_ANNOTATION
value class RealPath<T: Int>(val x: T, val y: T) : Path {
    override fun dispatch(maxDepth: Int) = Unit

    fun childrenDispatch(recursively: Boolean): Unit =
        if (recursively) dispatch() else dispatch()

    override fun Int.extension(maxDepth: Int) = Unit

    fun Int.childrenExtension(recursively: Boolean): Unit =
        if (recursively) extension() else extension()
}

fun box(): String {
    RealPath(1, 2)
    return "OK"
}
