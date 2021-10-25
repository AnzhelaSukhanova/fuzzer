// Original bug: KT-10547

import java.util.Optional

fun testOptional1() {
    val str: String? = "123"
    val opt = Optional.ofNullable<String>(str)
    val str2: String = opt.get()
}
