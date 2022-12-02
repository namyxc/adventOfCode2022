object Puzzle2 {
    val points =  mapOf<String, Int>(
        "AX" to 1 + 3, // Rock     - Rock
        "AY" to 2 + 6, // Rock     - Paper
        "AZ" to 3 + 0, // Rock     - Scissors

        "BX" to 1 + 0, // Paper    - Rock
        "BY" to 2 + 3, // Paper    - Paper
        "BZ" to 3 + 6, // Paper    - Scissors

        "CX" to 1 + 6, // Scissors - Rock
        "CY" to 2 + 0, // Scissors - Paper
        "CZ" to 3 + 3, // Scissors - Scissors
    )

    val suggested =  mapOf<String, String>(
        "AX" to "Z", // Rock     - Lose
        "AY" to "X", // Rock     - Draw
        "AZ" to "Y", // Rock     - Win

        "BX" to "X", // Paper    - Lose
        "BY" to "Y", // Paper    - Draw
        "BZ" to "Z", // Paper    - Win

        "CX" to "Y", // Scissors - Lose
        "CY" to "Z", // Scissors - Draw
        "CZ" to "X", // Scissors - Win
    )

    @JvmStatic
    fun main(args: Array<String>) {
        val input = readInput(Puzzle2::class.java.getResource("puzzle2.txt").readText())
        val result1 = sumPoints(input)
        println(result1)
        val result2 = sumPoints2(input)
        println(result2)
    }

    fun readInput(input: String) = input.split("\n").filter { it.isNotEmpty() }.map { it.split(" ") }
    fun sumPoints(testArray: List<List<String>>) = testArray.map { it.joinToString("")}.map { points.get(it)!! }.sum()
    fun sumPoints2(testArray: List<List<String>>) = testArray.map { it.get(0) + suggested.get(it.joinToString("")) }.map { points.get(it)!!  }.sum()
}