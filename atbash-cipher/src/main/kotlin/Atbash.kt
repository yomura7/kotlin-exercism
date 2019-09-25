class Atbash {
    companion object {
        val plain = ('a'..'z').map { it }
        val cipherMap: Map<Char, Char>
            get() = plain.map { it to plain[plain.size - 1 - plain.indexOf(it)] }.toMap()

        fun encode(input: String) = input.toLowerCase()
            .filter { it in 'a'..'z' || it in 'A'..'Z' || it in '0'..'9' }
            .map { if (it in '0'..'9') it else cipherMap[it] }
            .mapIndexed { index, c -> if ((index + 1) % 5 == 0) "$c " else c }
            .joinToString(separator = "")
            .dropLastWhile { it == ' ' }

        fun decode(input: String) = input.toLowerCase()
            .filter { it in 'a'..'z' || it in 'A'..'Z' || it in '0'..'9' }
            .map { if (it in '0'..'9') it else cipherMap[it] }
            .joinToString(separator = "")
    }
}