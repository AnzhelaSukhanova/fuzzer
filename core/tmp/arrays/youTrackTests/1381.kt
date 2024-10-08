// Original bug: KT-43989

var l = ""

enum class Foo {
    FOO,
    BAR;

    init {
        l += "Foo.$name;"
    }

    companion object {
        init {
            l += "Foo.CO;"
        }

        val boo = 22
    }
}

enum class Foo2 {
    FOO,
    BAR;

    init {
        l += "Foo2.$name;"
    }

    companion object {
        init {
            l += "Foo2.CO;"
        }

        val boo = 22
    }
}

fun box(): String {
    try {
        Foo.valueOf("NO")
    } catch (e: Throwable) {
        l += "caught;"
    }

    if (l != "Foo.FOO;Foo.BAR;Foo.CO;caught;") return "l = $l"

    l = ""
    Foo2.valueOf("BAR")
    if (l != "Foo2.FOO;Foo2.BAR;Foo2.CO;") return "l = $l"

    return "OK"
}
