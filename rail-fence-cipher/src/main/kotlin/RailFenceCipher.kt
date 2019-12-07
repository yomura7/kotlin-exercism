class RailFenceCipher(private val rows: Int) {

    // TODO: Implement proper constructor
    private val period = 2 * rows - 2

    private fun createRails(input: String, fillChar: Char? = null): List<MutableList<Char>> {
        val rails = (1..rows).map {
            (0 until input.length).map { '.' }.toMutableList()
        }
        input.forEachIndexed { index, char ->
            var row = (index % period).let {
                if ( it < rows) it else period - it
            }
            rails[row][index] = fillChar ?: char
        }
        rails.forEach { println(it) }
        return rails
    }

    fun getEncryptedData(input: String)= createRails(input).flatten().filter { it != '.' }.joinToString(separator = "")

    fun getDecryptedData(input: String): String {
        var rails = createRails(input, '?')
        input.forEach outer@ { c ->
            rails.forEach inner@ {rail ->
                val i = rail.indexOfFirst { it == '?' }
                if (i >= 0) {
                    rail[i] = c
                    return@outer
                }
            }
        }
        rails.forEach { println(it) }
        return input.mapIndexed { index, _ ->
            rails.find { rail -> rail[index] != '.' }?.get(index)
        }.joinToString(separator = "")
    }
}
