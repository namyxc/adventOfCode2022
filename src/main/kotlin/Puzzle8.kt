object Puzzle8 {

    @JvmStatic
    fun main(args: Array<String>) {
        val input = readInput(Puzzle8::class.java.getResource("puzzle8.txt").readText())
        val result1 = countTreeIfVisibleFromOutside(input)
        println(result1)
        val result2 = bestScenicScore(input)
        println(result2)
    }

    fun readInput(input: String) = input.split("\n").filter { it.isNotEmpty() }.map { it.split("").filter { it.isNotEmpty() }.map { it.toInt() } }
    fun countTreeIfVisibleFromOutside(input: List<List<Int>>) = input.mapIndexed { i, row -> row.mapIndexed { j, item -> visible(input, i , j) }.sum() }.sum()


    fun visible(input: List<List<Int>>, i: Int, j: Int): Int {
        val rows = input.size
        val cols = input[0].size
        if (i == 0 || i == cols-1 || j == 0 || j == rows-1) return 1
        val size = input[i][j]
        val row = input[i]
        if (row.take(j).max() < size) return 1
        if (row.takeLast(cols-j - 1).max() < size) return 1
        val column = getColumn(input,j)
        if (column.take(i).max() < size) return 1
        if (column.takeLast(rows - i - 1).max() < size) return 1
        return 0
    }

    private fun getColumn(input: List<List<Int>>, index: Int) = input.map {it.get(index)}
    fun scenicScore(input: List<List<Int>>, rowIdx: Int, colIdx: Int): Int {
        val rows = input.size
        val cols = input.get(0).size
        if (colIdx == 0 || colIdx == cols-1 || rowIdx == 0 || rowIdx == rows-1) return 0

        val size = input[rowIdx][colIdx]
        val row = input[rowIdx]
        val column = getColumn(input,colIdx)

        val upScore = calculateScore(rowIdx, column, size, -1)
        val downScore = calculateScore(rowIdx, column, size, 1)
        val leftScore = calculateScore(colIdx, row, size, -1)
        val rightScore = calculateScore(colIdx, row, size, 1)

        return upScore * downScore* rightScore * leftScore
    }

    private fun calculateScore(rowIdx: Int, column: List<Int>, size: Int, direction: Int): Int {
        var score = 0
        var index = rowIdx
        do {
            score += 1
            index += direction
        } while (
            ((direction == -1 && index > 0) || (direction == 1 && index < column.size - 1))
            && column[index] < size)
        return score
    }

    fun bestScenicScore(input: List<List<Int>>)=  input.mapIndexed { i, row -> row.mapIndexed { j, item -> scenicScore(input, i , j) }.max() }.max()

}