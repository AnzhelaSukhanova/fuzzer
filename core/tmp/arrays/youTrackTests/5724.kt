// Original bug: KT-31497

typealias Lambda = (
    Int, Int, Int, Int, Int, Int, Int, Int,
    Int, Int, Int, Int, Int, Int, Int, Int,
    Int, Int, Int, Int, Int, Int, Int
) -> Unit // 23 arguments

class A : Lambda {
    override fun invoke(
        p1: Int, p2: Int, p3: Int, p4: Int,
        p5: Int, p6: Int, p7: Int, p8: Int,
        p9: Int, p10: Int, p11: Int, p12: Int,
        p13: Int, p14: Int, p15: Int, p16: Int,
        p17: Int, p18: Int, p19: Int, p20: Int,
        p21: Int, p22: Int, p23: Int
    ) {
    }
}

fun main() {
    val a = A()
    println(a is Lambda)
}
