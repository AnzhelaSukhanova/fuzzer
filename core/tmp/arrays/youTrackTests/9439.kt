// Original bug: KT-13583

open class X(private val n: String) {

    fun foo(): String {
        return object : X("inner") {
            fun print(): String {
                return n;
            }
        }.print()
    }
}


fun box() : String {
  return X("OK").foo()
}
