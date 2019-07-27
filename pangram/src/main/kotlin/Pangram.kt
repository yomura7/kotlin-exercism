package Pangram

fun isPangram(sentence: String): Boolean {
    for (letter in 'a'..'z') {
        if (!sentence.contains(letter, true)) {
            return false
        }
    }
    return true
}
