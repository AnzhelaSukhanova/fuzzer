// Original bug: KT-34069

class TestContinueInSwitchInForeach {
    private var a = 0
    private var b = 0
    private var c = 0

    fun foo(cc: CharArray) {
        loop@ for (ccc in cc) {
            if (ccc == ';') {
                continue
            }
            when (ccc) {
                ' ' -> continue@loop
                'a' -> a++
                'b' -> b++
                'c' -> c++
            }
        }
        println("a = $a; b = $b; c = $c")
    }

    fun bar(cc: CharArray) {
        loop@ for (i in 0..9) {
            when (cc[i]) {
                ';' -> continue@loop
                ' ' -> continue@loop
                'a' -> a++
                'b' -> b++
                'c' -> c++
            }
        }
        println("a = $a; b = $b; c = $c")
    }
}

