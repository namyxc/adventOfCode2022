

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class Puzzle1Test: PuzzleTest() {

    companion object {
        val testArray = arrayListOf(
            arrayListOf(1000, 2000, 3000),
            arrayListOf(4000),
            arrayListOf(5000, 6000),
            arrayListOf(7000, 8000, 9000),
            arrayListOf(10000)
        )
    }

    @Test
    fun `find max calories`() {
        val maxCalories = Puzzle1.findMaxCalories(testArray)
        val expectedResult = 24000
        assertEquals(expectedResult, maxCalories) {
            "$maxCalories should equal $expectedResult"
        }
    }
    @Test
    fun `find max 3 calories`() {
        val maxCalories = Puzzle1.findMax3Calories(testArray)
        val expectedResult = 45000
        assertEquals(expectedResult, maxCalories) {
            "$maxCalories should equal $expectedResult"
        }
    }

    @Test
    fun `input to arraylist`(){
        val input = "1000\n" +
                "2000\n" +
                "3000\n" +
                "\n" +
                "4000\n" +
                "\n" +
                "5000\n" +
                "6000\n" +
                "\n" +
                "7000\n" +
                "8000\n" +
                "9000\n" +
                "\n" +
                "10000"

        val inputAsArraylist = Puzzle1.readInput(input)
        val expectedResult = testArray
        assertEquals(expectedResult, inputAsArraylist) {
            "$inputAsArraylist should equal $expectedResult"
        }
    }

}