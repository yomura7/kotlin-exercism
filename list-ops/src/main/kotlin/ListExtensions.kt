package extensions

fun <T> List<T>.customAppend(that: List<T>): List<T> {
    val list = this.toMutableList()
    that.forEach{ list.add(it) }
    return list
}

fun <T> List<List<T>>.customConcat(): List<T> {
    val list = mutableListOf<T>()
    this.forEach{ subList ->
        subList.forEach {
            list.add(it)
        }
    }
    return list
}

fun <T> List<T>.customFilter(predicate: (T) -> Boolean): List<T> {
    val list = mutableListOf<T>()
    this.forEach {
        if (predicate(it)) list.add(it)
    }
    return list
}

val <T> List<T>.customSize: Int
    get() {
        var size = 0
        this.forEach { size++ }
        return size
    }

fun <T> List<T>.customMap(predicate: (T) -> T): List<T> {
    val list = mutableListOf<T>()
    this.forEach {
        list.add(predicate(it))
    }
    return list
}

fun <T, V> List<T>.customFoldLeft(item: V , accumulator: (V, T) -> V ): V {
    var list = item
    this.forEach {
        list = accumulator(list, it)
    }
    return list
}

fun <T, V> List<T>.customFoldRight(item: V , accumulator: (T, V) -> V ): V {
    var list = item
    this.customReverse().forEach {
        list = accumulator(it, list)
    }
    return list
}

fun <T> List<T>.customReverse(): List<T> {
    var list = mutableListOf<T>()
    this.dropLastWhile {
        list.add(it)
    }
    return list
}


