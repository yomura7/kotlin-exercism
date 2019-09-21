class CollatzCalculator {
    companion object {
        fun computeStepCount(input: Int): Int {
            require(input > 0) {"Only natural numbers are allowed"}
            var count = 0
            var current = input
            while(current > 1) {
                current = when {
                    current % 2 == 0 -> current / 2
                    else -> 3 * current + 1
                }
                count++
            }
            return count
        }
    }
}