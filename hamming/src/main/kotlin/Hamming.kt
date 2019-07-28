package Hamming

import java.lang.IllegalArgumentException

fun compute(dna1: String, dna2: String): Number {
    var errorCount = 0
    if (dna1.length != dna2.length) {
        throw IllegalArgumentException("left and right strands must be of equal length.")
    }
    for ((index, dna) in dna1.withIndex()) {
        if (dna1[index] != dna2[index]) {
            errorCount += 1
        }
    }
    return errorCount
}