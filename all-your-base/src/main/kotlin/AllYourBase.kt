import kotlin.math.pow

class BaseConverter(private val base: Int, private val digits: IntArray) {
    init {
        require(base > 1) {"Bases must be at least 2."}
        require(digits.isNotEmpty()) {"You must supply at least one digit."}
        require(digits.all { it >= 0 }) {"Digits may not be negative."}
        require(if (digits.size >= 2) digits.first() != 0 else true) {"Digits may not contain leading zeros."}
        require(if (digits.size >= 2) digits.any { it > 0 } else true) {"Digits may not contain leading zeros."}
        require(digits.all { it <= base - 1 }) {"All digits must be strictly less than the base."}
    }

    fun convertToBase(newBase: Int): IntArray {
        require(newBase > 1) {"Bases must be at least 2."}

        val decimalValue = digits.reversed().reduceIndexed { index, acc, digit ->
            acc + (digit * base.toDouble().pow(index).toInt())
        }

        var result = mutableListOf<Int>()
        var remaining = decimalValue
        while(remaining > 0) {
            result.add(remaining.rem(newBase))
            remaining /= newBase
        }
        if (result.size == 0) result.add(0)
        return result.reversed().toIntArray()
    }

}
