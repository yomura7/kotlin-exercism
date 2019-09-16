class Series(private val str: String) {
    init {
        str.forEach {
            if (it !in '0'..'9') throw IllegalArgumentException("The characters in input must be between 0 and 9.")
        }
    }
    fun getLargestProduct(order: Int): Int {
        require(str.length >= order) {"Order must be less than or equal to input length." }
        require(order >= 0) { "Order must be a natural number." }

        val productList = str.mapIndexed { index, char ->
            var seriesProdcut = 1
            for (i in 0 until order) {
                seriesProdcut *= str.getAsInt(index + i)
            }
            seriesProdcut
        }
        return productList.maxBy {it} ?: 1
    }
}

fun String.getAsInt(index: Int) = when (getOrNull(index)) {
    null -> 0
    else -> getOrNull(index).toString().toInt()
}

