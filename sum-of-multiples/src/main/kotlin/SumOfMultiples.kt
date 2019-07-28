package SumOfMultiples

fun Int.isMultiples(numbers: Set<Int>): Boolean {
    numbers.forEach {
        if (this % it == 0) return true
    }
    return false
}

fun sum(numbers: Set<Int>, limit: Int): Int {
    var count = 0
    var sum = 0
    while (count < limit) {
        sum += when (count.isMultiples(numbers)) {
            true -> count
            else -> 0
        }
        count++
    }
    return sum
}
