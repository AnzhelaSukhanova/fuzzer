// Original bug: KT-24428

fun toString(grade: String): String {
    when (grade) {
        "A" -> return "Excellent"
        "B" -> return "Good"
        "C" -> return "Mediocre"
        "D" -> return "Fair"
        else -> return "Failure"
    }
}
