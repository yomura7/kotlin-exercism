data class MatrixCoordinate(val row: Int, val col: Int)

class Matrix(private val rows: List<List<Int>>) {
    val saddlePoints: Set<MatrixCoordinate>
        get() = calcSaddlePoints()

    private fun calcSaddlePoints(): Set<MatrixCoordinate> {
        val set = mutableSetOf<MatrixCoordinate>()
        rows.forEachIndexed loopY@ { y, row ->
            val maxInRows = row.max() ?: return@loopY
            row.forEachIndexed { x, value ->
                val minInCols = (0 until rows.size).map { rows[it][x] }.min() ?: return@loopY
                if (value in maxInRows..minInCols) {
                    set.add(MatrixCoordinate(y + 1, x + 1))
                }
            }
        }
        return set
    }
}