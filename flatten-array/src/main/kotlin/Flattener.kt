class Flattener {
    companion object {
        fun flatten(list: List<Any?>): List<Int> {
            val result = mutableListOf<Int>()
            list.forEach {
                val diffList = extract(result, it).drop(result.size)
                diffList.forEach { diff -> result.add(diff) }
            }
            return result
        }

        fun extract(current: List<Int>, input: Any?): List<Int> {
            var result = current.map { it }.toMutableList()
            if (input is Int) {
                result.add(input)
            } else if (input is List<*>) {
                input.dropWhile {
                    result = extract(result, it).toMutableList()
                    input.size != 0
                }
            }
            return result
        }
    }

}