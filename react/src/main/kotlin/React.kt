class Reactor<T>() {
    // Your compute cell's addCallback method must return an object
    // that implements the Subscription interface.
    interface Subscription {
        fun cancel()
    }
    inner class Subscriber<T>(val cell: Cell<T>) : Subscription {
        override fun cancel() {
            cell.removeCallback(this)
        }
    }

    open inner class Cell<T> (input: T) {
        var value = input
            set(newInput) {
                println("update input $field -> $newInput")
                if (field != newInput) {
                    field = newInput
                    notifyObservers(newInput)
                }
            }
        val callbackMap: MutableMap<Subscriber<T>, (T) -> (Unit)> = mutableMapOf()

        open fun compute() = value

        private fun notifyObservers(newInput: T) {
            callbackMap.filterKeys { it.cell == this }.forEach { sub, transform ->
                transform(newInput)
            }
        }

        fun addCallback(callback: (T) -> (Unit)) : Subscription {
            val cell = this
            val sub = Subscriber(cell)
            callbackMap[sub] = callback
            return sub
        }

        fun removeCallback(sub: Subscriber<T>) {
            callbackMap.remove(sub)
        }
    }

    inner class InputCell<Int>(i: Int) : Cell<Int>(i)

    inner class ComputeCell<T>(
            vararg val inputs: Cell<T>,
            val transform: (List<T>) -> T) : Cell<T>(transform(inputs.map{ it.compute() })
    ) {
        init {
            inputs.forEach {
                it.addCallback {
                    value = compute()
                }
            }
        }
        override fun compute() = transform(inputs.map{ it.compute() })
    }
}
