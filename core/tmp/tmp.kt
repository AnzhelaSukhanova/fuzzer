class M {
  operator fun Long.component1() = component2() + 1
  operator fun Long.component2() = this + 2

  fun doTest(l : ArrayList<Long>): String {
      var s = ""
      for ((a, b) in l) {
        s += "$a:$b;"
      }
      return s
  }
}

fun box(): String {
  val l = ArrayList<Long>()
  l.add(0)
  l.add(1)
  l.add(2)
  val s = M().doTest(l)
  return if (s == "1:2;2:3;3:4;") "OK" else "fail: $s"
}