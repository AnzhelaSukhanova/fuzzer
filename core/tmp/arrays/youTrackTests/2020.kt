// Original bug: KT-23850

package test

class In<in I>

fun <S> select(x: S, y: S): S = x

fun <T> foo(a: Array<In<T>>, b: Array<In<String>>) =
        select(a, b)[0].ofType(true)


inline fun <reified K> In<K>.ofType(y: Any?) =
        y is K

fun main(args: Array<String>) {
    val a1 = arrayOf(In<Int>())
    val a2 = arrayOf(In<String>())
    println(foo(a1, a2))            // true
}
