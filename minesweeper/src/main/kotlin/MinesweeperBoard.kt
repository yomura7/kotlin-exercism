class MinesweeperBoard (var inputBoard: List<String>) {
    private val outputBoard: MutableList<String> = inputBoard.toMutableList()
    private val height: Int
        get() {
            return inputBoard.size
        }
    private val width: Int
        get() {
            if (inputBoard.isEmpty()) {
                return 0
            } else {
                return inputBoard[0].length
            }
        }

    fun withNumbers(): List<String> {
        for ((y, line) in outputBoard.withIndex()) {
            for ((x, square) in line.withIndex()) {
                if (square == '*') {
                    countUpNumber(x-1, y-1)
                    countUpNumber(x-1, y)
                    countUpNumber(x-1, y+1)
                    countUpNumber(x, y-1)
                    countUpNumber(x, y)
                    countUpNumber(x, y+1)
                    countUpNumber(x+1, y-1)
                    countUpNumber(x+1, y)
                    countUpNumber(x+1, y+1)
                }
            }
        }
        return outputBoard
    }

    private fun countUpNumber(x: Int, y: Int) {
        if (x !in 0 until width || y !in 0 until height ) return
        val oldValue = outputBoard[y][x]
        val newValue = when (oldValue) {
            ' ' -> '1'
            in '1'..'8' -> (oldValue.toInt() + 1).toChar()
            else -> oldValue
        }
        outputBoard[y] = "${outputBoard[y].slice(0 until x)}" +
                "$newValue${outputBoard[y].slice(x+1 until width)}"
    }
}