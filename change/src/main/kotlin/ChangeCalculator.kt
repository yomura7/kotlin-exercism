class ChangeCalculator(val coins: List<Int>) {
    var count = 1000000
    val sortedCoins: List<Int>
        get() = coins.sortedDescending()

    fun computeMostEfficientChange(input: Int): List<Int> {
        require(input >= 0) { "Negative totals are not allowed." }
        require(isRepresentable(input) ) { "The total $input cannot be represented in the given currency." }

        val initialStates = mutableListOf("0")
        val changeList = getChangeList(input, initialStates).drop(1)
//        println("all pattern: $changeList")
        val result = changeList.filter { it.isNotEmpty() }.maxBy { -it.length }
//        println("result: $result")
        return if (result is String) result.parseChange().drop(1).sorted() else mutableListOf()
    }
    private fun isRepresentable(input: Int): Boolean {
        var isDivisible = false
        coins.reduce { acc, i ->
            if (input % acc == 0) isDivisible = true
            acc + i
        }
        if (input % coins.sum() == 0) isDivisible = true
        return isDivisible
    }
    private fun getChangeList(goal: Int, states: MutableList<String>): MutableSet<String> {
        // copy states
        val resultStates = states.map { it }.toMutableSet()
        // check count of calculation
        if (this.count < 0) return resultStates
        this.count--

        // run each state (state length is not count of addition)
        states.forEach { state ->
            val sum = state.parseChange().sum()
            // branch by the number of coins
            for (coin in sortedCoins) {
                if (sum + coin == goal) {
                    // add candidate of change list
                    resultStates.add("$state/$coin")
                } else if (sum + coin < goal) { // can afford to add
                    // run recursive
                    val tempList = mutableListOf("$state/$coin")
                    getChangeList(goal, tempList).forEach {
                        if (it.parseChange().sum() == goal) resultStates.add(it)
                    }
                }
            }
        }
        return resultStates
    }
}
fun String.parseChange(): List<Int> = if (this.isNotEmpty()) this.split("/").map { it.toInt() } else listOf()
