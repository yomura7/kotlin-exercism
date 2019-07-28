import java.lang.IllegalArgumentException

class Triangle(val side1: Number, val side2: Number, val side3: Number) {
    val isEquilateral =
        when {
            !(isSatisfiedEquality()) -> throw IllegalArgumentException()
            side1 == side2 && side1 == side3 -> true
            else -> false
        }
    val isIsosceles =
        when {
            !(isSatisfiedEquality()) -> throw IllegalArgumentException()
            side1 == side2 || side2 == side3 || side3 == side1 -> true
            else -> false
        }
    val isScalene =
            when {
                !(isSatisfiedEquality()) -> throw IllegalArgumentException()
                side1 != side2 && side2 != side3 && side3 != side1 -> true
                else -> false
            }
    private fun isSatisfiedEquality(): Boolean {
        if (side1 == 0 && side2 == 0 && side3 == 0) return false
        return when {
            side1.toFloat() + side2.toFloat() < side3.toFloat() -> false
            side2.toFloat() + side3.toFloat() < side1.toFloat() -> false
            side3.toFloat() + side1.toFloat() < side2.toFloat() -> false
            else -> true
        }
    }
}
