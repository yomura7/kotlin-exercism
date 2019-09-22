class ChangeCalculator(val coins: List<Int>) {
    var count = 1000000
    val sortedCoins: List<Int>
        get() = coins.sortedDescending()

    fun computeMostEfficientChange(input: Int): List<Int> {
        require(input >= 0) { "Negative totals are not allowed." }

        val states = mutableListOf("0")
        val changeList3 = recursionCheck(input, states).drop(1)
        println("pattern3: ${changeList3}")
        val result = changeList3.filter { it.isNotEmpty() }.maxBy { -it.length }
        println("result: $result")
        if (result is String) return result.parseChange().drop(1).sorted()
        return mutableListOf()
    }

    fun recursionCheck(goal: Int, states: MutableList<String>): MutableSet<String> {
        // copy
        val resultState = states.map { it }.toMutableSet()
        if (this.count < 0) return resultState
        this.count--
        // stateの数だけ実行
        // add はそれ以下またはそれ以上行う可能性あり
        states.forEach { state ->
            // coin候補の数だけ分岐する
            val sum = state.parseChange().sum()
//            println("sum: $sum")
            for (coin in sortedCoins) {
                // ぴったりなら
                if (sum + coin == goal) {
                    resultState.add("$state/$coin")
//                } else if (sum + coin > goal) { // 超えていたら何もしない
                } else if (sum + coin < goal) { // 追加してもいけたら
                    // コインを追加して再帰
                    val tempList = mutableListOf<String>("$state/$coin")
                    recursionCheck(goal, tempList).forEach {
                        if (it.parseChange().sum() == goal) resultState.add(it)
                    }
                }
            }
        }
        return resultState
    }

    fun String.parseChange(): List<Int> = if (this.isNotEmpty()) this.split("/").map { it.toInt() } else listOf()
}
