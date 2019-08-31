package extensions

fun <T> List<T>.customAppend(list: List<T>): List<T> {
  return emptyList()
}

fun <T> List<List<T>>.customConcat(): List<T> {
  return emptyList()
}

fun <T> List<T>.customReverse(): List<T> {
  return emptyList()
}

fun <T> List<T>.customMap(predicate: (T) -> T): List<T> {
  val x = 16.0.times(3)
  return emptyList()
}

fun <T> List<T>.customFilter(predicate: (T) -> Boolean): List<T> {
  return emptyList()
}

fun <T, V> List<T>.customFoldRight(item: V , accumulator: (V, T) -> V ): V {
  return 0 as V
}

fun <T, V> List<T>.customFoldLeft(item: V , accumulator: (V, T) -> V ): V {
  return 0 as V
}


val <T> List<T>.customSize: Int
  get() = 0
