// Original bug: KT-29148

// FILE: 1.kt

// WITH_RUNTIME
public inline fun <T> T.myalso(block: (T) -> Unit): T {
    block(this)
    return this
}

public inline fun <T, R : Any> Iterable<T>.mymapNotNull(transform: (T) -> R?): List<R> {
    return mapNotNullTo(ArrayList<R>(), transform)
}

// FILE: 2.kt
// NO_CHECK_LAMBDA_INLINING
var result = -1;

fun box(): String {
    fff()
    return if (result == 1) "OK" else "fail $result"
}

fun fff(): Int {
    val y = 0
    return 0.myalso {
        fun increase(x: Int): Int = x + y

        val values = listOf(1).mymapNotNull { something(::increase, it) }
        result = values[0]!!
    }
}

fun something(increase: (Int) -> Int, x: Int): Int? {
    return increase(x)
}
