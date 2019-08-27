class Anagram(private val input: String) {
    fun match(candidates: List<String>): Set<String> {
        val matchedSet = mutableSetOf<String>()
        for (candidate in candidates) {
            if (candidate.length != input.length) continue
            val inputList = input.decapitalize().toList().sorted()
            val candidateList = candidate.toLowerCase().toList().sorted()
            if (inputList == candidateList) matchedSet.add(candidate)
        }
        return matchedSet
    }
}