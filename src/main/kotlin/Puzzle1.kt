object Puzzle1 {

    @JvmStatic
    fun main(args: Array<String>) {
        val input = readInput(Puzzle1::class.java.getResource("puzzle1.txt").readText())
        val result1 = findMaxCalories(input)
        println(result1)
        val result2 = findMax3Calories(input)
        println(result2)
    }

    fun findMaxCalories(entries: List<List<Int>>) = entries.map { it.sum() }.max()
    fun findMax3Calories(entries: List<List<Int>>) = entries.map { it.sum() }.sortedDescending().take(3).sum()
    fun readInput(input: String) = input.split("\n\n").map { it -> it.split('\n').filter { it.isNotEmpty() }.map { it.toInt() } }
}