// Original bug: KT-10232

interface A<T>
interface B<T> : A<T>

fun <T> foo(b: A<T>) {}

fun <T> test(a: A<T>) {
    if (a is Any?) {
        // Error:(9, 9) Kotlin: Type inference failed: fun <T> foo(b: A<T>): kotlin.Unit
        // cannot be applied to (A<T>)
        foo(a)
    }
    
    foo(a) // ok
}
