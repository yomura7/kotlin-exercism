object Prime {
    fun nth(target: Int): Int {
        if (target < 1) throw IllegalArgumentException("There is no zeroth prime.")
        val primeList = arrayListOf(2)
        var nthCount = 1
        while (nthCount < target) {
            val prime = nextPrime(primeList)
            primeList.add(prime)
            nthCount++
        }
        return primeList.last()
    }

    fun nextPrime(primeList: List<Int>): Int {
        var num = primeList.last()
        while (true) {
            num++
            for (prime in primeList) {
                if (num % prime == 0) break
                if (prime == primeList.last()) return num
            }
        }

    }
}