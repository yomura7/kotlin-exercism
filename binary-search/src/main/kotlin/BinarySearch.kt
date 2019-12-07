object BinarySearch {
    fun search(list: List<Int>, item: Int): Int {
        require(list.isNotEmpty()) {
            throw NoSuchElementException()
        }
        val middle = list.size / 2
        return when {
            list[middle] == item -> middle
            list[middle] > item -> search(list.subList(0, middle), item)
            list[middle] < item -> search(list.subList(middle + 1, list.size), item) + (middle + 1)
            else -> throw NoSuchElementException()
        }
    }
}
