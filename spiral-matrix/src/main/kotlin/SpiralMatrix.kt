object SpiralMatrix {

    fun ofSize(size: Int): Array<IntArray> {
        // create empty matrix
        val matrix = (1..size).map { IntArray(size) }.toTypedArray()
        var upFlag = false
        var current = Pair(0,0)

        for (count in (1..(size * size))) {
            matrix[current.first][current.second] = count
            println("==========")
            matrix.forEach {
                println(it.toList())
            }
            println("==========")

            if (upFlag && matrix.isEmpty(current.first - 1, current.second)) {
                println("↑")
                current = Pair(current.first - 1, current.second)
                continue
            }

            upFlag = false
            if (matrix.isEmpty(current.first, current.second + 1)) {
                println("→")
                current = Pair(current.first, current.second + 1)
            } else if (matrix.isEmpty(current.first + 1, current.second)) {
                println("↓")
                current = Pair(current.first + 1, current.second)
            } else if (matrix.isEmpty(current.first, current.second - 1)) {
                println("←")
                current = Pair(current.first, current.second - 1)
            } else if (matrix.isEmpty(current.first - 1, current.second)) {
                println("↑")
                current = Pair(current.first - 1, current.second)
                upFlag = true
            } else {
                matrix[current.first][current.second] = count
            }
        }
        return matrix
    }

    private fun Array<IntArray>.isEmpty(first: Int, second: Int) =
        when {
            first < 0 || this.size <= first  -> false
            second < 0 || this.size <= second  -> false
            this[first][second] != 0 -> false
            else -> true
        }
}
