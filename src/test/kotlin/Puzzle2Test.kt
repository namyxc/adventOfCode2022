import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class Puzzle2Test: PuzzleTest() {
    companion object {
        val testArray = arrayListOf(
            arrayListOf("A", "Y"),
            arrayListOf("B", "X"),
            arrayListOf("C", "Z")
        )
    }

    @Test
    fun `sum points with suggested item`() {
        val points = Puzzle2.sumPoints(testArray)
        val expectedResult = 15
        Assertions.assertEquals(expectedResult, points) {
            "$points should equal $expectedResult"
        }
    }

    @Test
    fun `sum points with suggested outcome`() {
        val points = Puzzle2.sumPoints2(testArray)
        val expectedResult = 12
        Assertions.assertEquals(expectedResult, points) {
            "$points should equal $expectedResult"
        }
    }

    @Test
    fun `input to arraylist`(){
        val input = "A Y\n" +
                "B X\n" +
                "C Z\n"

        val inputAsArraylist = Puzzle2.readInput(input)
        val expectedResult = testArray
        Assertions.assertEquals(expectedResult.size, inputAsArraylist.size)
        expectedResult.forEachIndexed { index, chars ->
            Assertions.assertArrayEquals(expectedResult[index].toArray(), inputAsArraylist[index].toTypedArray())
        }
    }
}
