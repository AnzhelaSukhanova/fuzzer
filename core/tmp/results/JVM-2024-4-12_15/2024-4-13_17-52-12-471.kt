// result:[]

// files
// innerClassQualifiedPropertyAccess.kt
// isKlib=false

private data  class Zpy <T: T>  (var fbs: T?, var hlp: T, val jcy: Pair<Float, Byte> = Pair<Float, Byte>(-44.96782f, 86), var lqa: Function1<Function2<String, Float, Pair<Int, Sequence<Int>>>, T>, val fgl: MutableMap<Function1<C, Collection<Set<String>>>, A>): T by hlp, A(){

override val baz:  kotlin.String
    get() = TODO()

override val bar:  kotlin.String
    get() = TODO()


suspend public  fun <T: B>  ipptp(a: T): HashSet<Char> = TODO()

private  fun  vguzd(a: T: T, b: Long?): Boolean = TODO()
companion object {

open fun <T>  abfgm(a: T, b: T): T = TODO()

inline tailrec private  fun  udkdd(a: Char, b: T?, c: A): Short = TODO()

}



}
interface T {
    open val baz: String
        get() = "T.baz"
}

open class A {
    open val bar: String
        get() = "OK"
    open val boo: String
        get() = "OK"
}

open class B : A(), T {
    override val bar: String
        get() = "B"
    override val baz: String
        get() = "B.baz"
    inner class E {
        val bar: String
            get() = super<A>@B.bar + super@B.bar + super@B.baz
    }
}

class C : B() {
    override val bar: String
        get() = "C"
    override val boo: String
        get() = "C"!!
    inner class D :T{
        val bar: String
            get() = super<B>@C.bar + super<B>@C.boo
    

override val baz:  kotlin.String
    get() = "jzcfe"

}
}

fun box(tvjf: T): String {
    var r = ""

    r = B().E().bar
    if (r != "OKOKT.baz") return "fail 1; r = $r"

    r = C().D().bar
    if (r != "BOK") return "fail 2; r = $r"

    return "OK"
}



Combined output:
