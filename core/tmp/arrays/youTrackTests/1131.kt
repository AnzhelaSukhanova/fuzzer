// Original bug: KT-42889

// TARGET_BACKEND: JVM
// WITH_RUNTIME
// FULL_JDK
import java.io.Reader
import java.io.StringReader

private const val BACKSLASH = '\\'

private fun Reader.nextChar(): Char? =
    read().takeUnless { it == -1 }?.toChar()

fun Reader.consumeRestOfQuotedSequence(sb: StringBuilder, quote: Char) {
    var ch = nextChar()
    while (ch != null && ch != quote) {
        if (ch == BACKSLASH) nextChar()?.let { sb.append(it) } else sb.append(ch)
        ch = nextChar()
    }
}

fun box(): String {
    val r = StringReader("\\O\\K\'")
    val sb = StringBuilder()
    r.consumeRestOfQuotedSequence(sb, '\'')
    return sb.toString()
}
