object Sieve {
    fun primesUpTo(upperBound: Int): List<Int> {
        val intList = (2..upperBound).toList()
        val markedIntSet = mutableSetOf<Int>()
        intList.forEach {p ->
            if (markedIntSet.contains(p)) return@forEach
            var i = 0
            while(2 * p + i * p <= upperBound) {
                markedIntSet.add(2 * p + i * p)
                i++
            }
        }
        return intList - markedIntSet
    }
}
