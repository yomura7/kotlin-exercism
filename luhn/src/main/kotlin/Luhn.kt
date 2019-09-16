class Luhn {
    companion object {
        fun isValid(input: String): Boolean {
            val trimmedInput = input.replace(" ", "")
            if (trimmedInput.length <= 1) return false
            trimmedInput.forEach {
                if (it !in '0'..'9') return false
            }

            val checkSum = trimmedInput.reversed().
                    mapIndexed { index, char ->
                var newValue = char.toString().toInt()
                if (index % 2 == 1) {
                    newValue *= 2
                }
                if (newValue > 9) {
                    newValue -= 9
                }
                newValue
            }.sumBy { it }
            return checkSum % 10 == 0
        }
    }
}