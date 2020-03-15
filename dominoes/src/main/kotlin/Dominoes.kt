class ChainNotFoundException(msg: String) : RuntimeException(msg)

data class Domino(val left: Int, val right: Int) {
    fun reversed() = Domino(right, left)
}

object Dominoes {
    fun formChain(): List<Domino> {
        return listOf()
    }
    fun formChain(inputDomino: Domino) {
        throw ChainNotFoundException("Singleton can't be chained.")
    }
    fun formChain(vararg inputDomino: Domino) {
        throw ChainNotFoundException("Input can't be chained.")
    }
    fun formChain(inputDominoes: List<Domino>): List<Domino> {
        generateChain(inputDominoes.toMutableList(), true).let {
            if (it.size == inputDominoes.size) { return it }
        }
        generateChain(inputDominoes.toMutableList(), false).let {
            if (it.size == inputDominoes.size) { return it }
        }
        return inputDominoes
    }
    private fun generateChain(inputDominoes: MutableList<Domino>, forward: Boolean): List<Domino> {
        val outputDominoes = mutableListOf<Domino>()
        val markedIndex = mutableListOf<Int>()

        outputDominoes.add(inputDominoes.first())
        if( forward) {
            markedIndex.add(0)
        } else {
            inputDominoes.reverse()
            markedIndex.add(inputDominoes.size-1)
        }

        for (i in 1..inputDominoes.size) {
            inputDominoes.forEachIndexed { index, input ->
                if (markedIndex.contains(index)) {
                    return@forEachIndexed
                }
                val last = outputDominoes.last()
                if (last.right == input.left) {
                    outputDominoes.add(input)
                    markedIndex.add(index)
                } else if (last.right == input.right) {
                    outputDominoes.add(input.reversed())
                    markedIndex.add(index)
                }
            }
        }
        return outputDominoes
    }
}
