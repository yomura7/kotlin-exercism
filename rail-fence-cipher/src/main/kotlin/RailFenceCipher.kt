class RailFenceCipher(private val rows: Int) {

    // TODO: Implement proper constructor

    fun getEncryptedData(input: String): String {
        var rails = (1..rows).map {
            (0 until input.length).map { '.' }.toMutableList()
        }
        val period = 2 * rows - 2
        input.forEachIndexed { index, c ->
            var row = (index % period).let {
                if ( it < rows) it else period - it
            }
            rails[row][index] = c
        }
        rails.forEach { println(it) }
        return rails.flatMap { it }.filter { it != '.' }.joinToString(separator = "")
    }

    fun getDecryptedData(input: String): String {
//        TODO("Implement this function to complete the task")
        return "hoge"
    }
}
