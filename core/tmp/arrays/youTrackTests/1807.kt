// Original bug: KT-11253

private inline fun <T> Iterable<T>.sumByLong(selector: (T) -> Long): Long {
  var sum = 0L
  for (element in this) {
    sum += selector(element)
  }
  return sum
}