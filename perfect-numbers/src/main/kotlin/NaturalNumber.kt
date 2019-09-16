
enum class Classification {
    DEFICIENT, PERFECT, ABUNDANT
}

fun classify(naturalNumber: Int): Classification {
    if (naturalNumber <= 0) throw RuntimeException("Input must be a natural number")
    var count = 0
    for (n in 1 until naturalNumber) {
        if ( naturalNumber % n == 0) {
            count += n
        }
    }
    return when {
        count > naturalNumber -> Classification.ABUNDANT
        count == naturalNumber -> Classification.PERFECT
        count < naturalNumber -> Classification.DEFICIENT
        else -> throw RuntimeException("Unknown case")
    }
}
