object Puzzle4 {

    @JvmStatic
    fun main(args: Array<String>) {
        val input = readInput(Puzzle4::class.java.getResource("puzzle4.txt").readText())
        val result1 = countContains(input)
        println(result1)
        val result2 = countOverlaps(input)
        println(result2)
    }

    fun readInput(input: String) = input.split("\n").filter { it.isNotEmpty() }.map { it.split(",", "-").map { it.toInt() } }
    fun countContains(input: List<List<Int>>) = input.map { isContains(it) }.count { it }

    private fun isContains(sections: List<Int>)=  (sections[0] <= sections[2] && sections[1] >= sections[3]) ||
        (sections[0] >= sections[2] && sections[1] <= sections[3])

    fun countOverlaps(input: List<List<Int>>) = input.map { isOverlaps(it) }.count { it }

    private fun isOverlaps(sections: List<Int>) = ! (sections[1] < sections[2] || sections[0] > sections[3])
}