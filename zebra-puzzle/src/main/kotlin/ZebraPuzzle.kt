class ZebraPuzzle {
    lateinit var houses: List<House>
    init {
        applyStatement1()
        log()
        applyStatement9()
        log()
        applyStatement10()
        log()
        applyStatement15()
        log()
        applyStatement6()
        log()
        applyStatement4()
        log()
        applyStatement2()
        log()
        applyStatement8()
        log()
        applyStatement12()
        log()
        applyStatement5and13()
        log()
    }
    class House(
        var index: Int = 0,
        var color: String = "***",
        var nationality: String = "***",
        var drink: String = "***",
        var cirarrete: String = "***",
        var pet: String = "***"
    ) {
        override fun toString(): String {
            return "$color, $nationality, $drink, $cirarrete, $pet"
        }
    }
    private fun applyStatement1() {
        // There are five houses.
        houses = (0..4).map {  House(index=it) }
    }
    private fun applyStatement2() {
        // The Englishman lives in the red house.
        val index = houses.find { it.color == "***" &&  it.nationality == "***"}?.index ?: -1
        houses[index].color = "red"
        houses[index].nationality = "Englishman"
        // Elimination method
        houses.find { it.color == "***" }?.color = "yellow"
    }
    private fun applyStatement4() {
        // Coffee is drunk in the green house.
        houses.find { it.color == "green" }?.drink = "coffee"
    }
    private fun applyStatement5and13() {
        // (5) The Ukrainian drinks tea.
        // (13) The Lucky Strike smoker drinks orange juice.
        val index = 0
        houses[index].drink = "water"
    }
    private fun applyStatement6() {
        // The green house is immediately to the right of the ivory house.
        // NOTE: Incomplete code
        val index = 3
        houses[index].color = "green"
        houses[index - 1].color = "ivory"
    }
    private fun applyStatement8() {
        // Kools are smoked in the yellow house.
        houses.find { it.color == "yellow" }?.cirarrete = "Kools"
    }
    private fun applyStatement9() {
        // Milk is drunk in the middle house.
        houses[houses.size / 2].drink = "milk"
    }
    private fun applyStatement10() {
        // The Norwegian lives in the first house.
        houses[0].nationality = "Norwegian"
    }
    private fun applyStatement12() {
        // Kools are smoked in the house next to the house where the horse is kept.
        val index = houses.find { it.cirarrete == "Kools" }?.index ?: -1
        houses[index + 1].pet = "horse"
    }
    private fun applyStatement15() {
        // The Norwegian lives next to the blue house.
        val index = houses.find { it.nationality == "Norwegian" }?.index ?: -1
        houses[index + 1].color = "blue"
    }
    private fun log() {
        println("color,nationality,drink,cirarrete,pet")
        houses.forEachIndexed{index, house ->
           println("${index+1} -> " + house)
        }
        println("===========")
    }


    fun drinksWater(): String {
        TODO("Implement this function to complete the task")
    }

    fun ownsZebra(): String {
        TODO("Implement this function to complete the task")
    }

}
