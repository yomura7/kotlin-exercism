class Deque<Int> {
    var value: Int = 0
    var previous: Deque<Int>? = null
    var next: Deque<Int>? = null

    fun push(pushedValue: Int) {
        this.previous = this
        this.value = pushedValue
    }
    fun pop(): Int {
        val poppedValue = value
        this.value = this.previous.value
        this.previous = this.previous.previous
        this.next = null
        return poppedValue
    }

    fun shift(): Int {

    }
    fun unshift(num: Int) {

    }
}