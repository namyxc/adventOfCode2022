import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Puzzle4Test {
    companion object {
        val testArray = arrayListOf(
            arrayListOf(2, 4, 6, 8),
            arrayListOf(2, 3, 4, 5),
            arrayListOf(5, 7, 7, 9),
            arrayListOf(2, 8, 3, 7),
            arrayListOf(6, 6, 4, 6),
            arrayListOf(2, 6, 4, 8),
        )
    }

    @Test
    fun `count cotains`(){
        val bestScenicScore = Puzzle4.countContains(testArray)
        val expectedResult = 2
        Assertions.assertEquals(expectedResult, bestScenicScore) {
            "$bestScenicScore should equal $expectedResult"
        }
    }

    @Test
    fun `count overlaps`(){
        val bestScenicScore = Puzzle4.countOverlaps(testArray)
        val expectedResult = 4
        Assertions.assertEquals(expectedResult, bestScenicScore) {
            "$bestScenicScore should equal $expectedResult"
        }
    }

    @Test
    fun `input to arraylist`(){
        val input = "2-4,6-8\n" +
                "2-3,4-5\n" +
                "5-7,7-9\n" +
                "2-8,3-7\n" +
                "6-6,4-6\n" +
                "2-6,4-8"

        val inputAsArraylist = Puzzle4.readInput(input)
        val expectedResult = testArray
        Assertions.assertEquals(expectedResult.size, inputAsArraylist.size)
        expectedResult.forEachIndexed { index, chars ->
            Assertions.assertArrayEquals(expectedResult[index].toArray(), inputAsArraylist[index].toTypedArray())
        }
    }
}