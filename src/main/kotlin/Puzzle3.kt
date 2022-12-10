object Puzzle3 {
    @JvmStatic
    fun main(args: Array<String>) {
        val input = readInput(Puzzle3::class.java.getResource("puzzle3.txt").readText())
        val result1 = sumOfPriorities(input)
        println(result1)
        val result2 = sumOfPrioritiesByThree(input)
        println(result2)
    }

    fun readInput(input: String) = input.split("\n").filter { it.isNotEmpty() }
    fun splitHalf(input: String): Array<String> {
        val halfSize = input.length/2
        return arrayOf(
            input.substring(0, halfSize),
            input.substring(halfSize)
        )
    }

    fun getPriority(input: String): Int {
        val halves = splitHalf(input)
        val firstItems = halves.get(0).toSet()
        val secondItems = halves.get(1).toSet()
        val char = firstItems.intersect(secondItems).first()
        return getPriority(char)
    }

    private fun getPriority(char: Char) = if (char > 'Z') char.code - 'a'.code + 1 else char.code - 'A'.code + 27

    fun sumOfPriorities(items: List<String>) = items.map { getPriority(it) }.sum()
    fun getPriority(inputs: List<String>): Int {
        var allLetters = ('a'..'z').toMutableSet()
            allLetters.addAll(('A'..'Z').toSet())
        return getPriority(inputs.map { it.toSet() }.fold(allLetters, {all, it -> it.toSet().intersect(all).toMutableSet()} ).first())
    }

    fun sumOfPrioritiesByThree(testArray: List<String>): Int {
        return testArray.chunked(3).map { getPriority(it) }.sum()
    }


}