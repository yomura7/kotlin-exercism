class ChangeCalculator(val coinList: List<Int>) {
    fun computeMostEfficientChange(input: Int): List<Int> {
        require(input >= 0) { "Negative totals are not allowed." }

        println("input: $input")
        val filteredCoinList = coinList.toMutableList().filter {
            it <= input
        }.reversed()
        println("filteredCoinList: $filteredCoinList")

        val changes = mutableListOf<Int>()
        var isContinue = true
        while (isContinue) {
            filteredCoinList.forEach { value ->
                println("value: $value, sum: ${changes.sum()}")

                // 差分のコインががちょうどあるかチェック
                val diff = input - changes.sum()
                if (diff <= 0) {
                    println("NG case")
                    isContinue = false
                } else {
                    val diffElem = filteredCoinList.find { it == diff }
                    if (diffElem is Int) {
                        println("OK case")
                        changes.add(diffElem)
                        isContinue = false
                    } else {
                        // 大きいコインから順に追加できるかチェック
                        println("diff: $diff, value: $value")
                        while (changes.sum() + value <= input) {
                            if (isSub(diff, value, filteredCoinList)) {
                                changes.add(value)
                            }
                        }
                    }
                }
                println("changes: $changes")
            }
        }
        println("final changes: $changes")
        return changes.sortedBy { it }
    }
    fun isSub(target: Int, value: Int, coinList: List<Int>) =
        coinList.any { num ->
            println("$target - $value % $num")
            // TODO: target - value が持つコインセットの要素数が最小のものを選ぶ
            // ex) o -> 23 - 20 = 3 = 1 + 1 + 1
            // ex) x -> 23 - 15 = 8 = 4 + 4
            // target - value がコインセットで割り切れる場合は true
            (target - value) % num == 0
        }

}