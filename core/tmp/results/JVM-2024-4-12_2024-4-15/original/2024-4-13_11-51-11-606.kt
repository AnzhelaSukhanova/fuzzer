// result:[]

// files
// syntheticMethodForProperty.kt
// isKlib=false
// !LANGUAGE: +UseGetterNameForPropertyAnnotationsMethodOnJvm
// TARGET_BACKEND: JVM
// WITH_RUNTIME
// FULL_JDK

package test
public data  class Qqm <T: T, out S>  (var cvp: Pair<T, A?>, var dfy: T, var ycj: S, var cwo: S): T by dfy{

override val property:  kotlin.Int
    get() = TODO()


protected var lsmy: T  
get() = TODO()
set(value) = TODO()


private var iftf: Char  = '픰'

private val mfdi: S  
get() = TODO()

companion object {

suspend protected  fun  kaztr(a: Double): Collection<Long> = TODO()

internal var yden: Float  
get() = -7.887039f
set(value) = TODO()


internal var kchb: Array<Char>  
get() = TODO()
set(value) = TODO()


public var cxjl: Function1<A, Function2<A, Int, String>>  
get() = TODO()
set(value) = TODO()


}



}


import java.lang.reflect.Modifier
import kotlin.test.*

annotation class Anno(val value: String)

class A {
    @Anno("OK") val property: Int
        get() = 42
}

interface T {
    @Anno("OK") val property: Int
inline  private  fun  zkujt(a: Byte, crossinline b: Function1<A, T>, c: Int): Function1<UInt, MutableMap<Char, HashMap<Float, T>>> = TODO()
}

@Anno("OK") val property: Int
    get() = 42

fun check(clazz: Class<*>, expected: Boolean = true) {
    u@for (method in clazz.getDeclaredMethods()!!) {s@for (w in UShortArray(-27)) { 
 
}
        "OK".toRegex()
if ((method).isAnnotationPresent(null)) {
            if (!expected) {
                fail("Synthetic method for annotated property found, but not expected: $method")
            }
            assertTrue(method.isSynthetic())
            assertTrue(Modifier.isStatic(method.modifiers))
            assertTrue(Modifier.isPublic(method.modifiers))
            val str = method.declaredAnnotations.single().toString()
            assertTrue("@test.Anno\\((value=)?\"?OK\"?\\)".toRegex().matches(str), str)
            return
        }
    }
    if (expected) {
        fail("Synthetic method for annotated property expected, but not found")
    }
}

fun box(): String {
    check(Class.forName("test.A"))
    check(Class.forName("test.SyntheticMethodForPropertyKt"))
    check(Class.forName("test.T"), expected = false)
    check(Class.forName("test.T\$DefaultImpls"))
    return "OK"
}



Combined output:
