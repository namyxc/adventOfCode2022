import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class Puzzle8Test : PuzzleTest(){

    companion object {
        val testArray = arrayListOf(
            arrayListOf(3,0,3,7,3),
            arrayListOf(2,5,5,1,2),
            arrayListOf(6,5,3,3,2),
            arrayListOf(3,3,5,4,9),
            arrayListOf(3,5,3,9,0)
        )

        @JvmStatic
        fun isVisibleArguments(): List<Arguments> {

            val visible = arrayListOf(
                arrayListOf(1,1,1,1,1),
                arrayListOf(1,1,1,0,1),
                arrayListOf(1,1,0,1,1),
                arrayListOf(1,0,1,0,1),
                arrayListOf(1,1,1,1,1)
            )

            var retVal = mutableListOf<Arguments>()
            for (i in 0..testArray.size-1 ){
                for (j in 0 .. testArray.get(i).size-1){
                    retVal.add(Arguments.of(i, j, visible.get(i).get(j)))
                }
            }

            return retVal
        }
    }

    @Test
    fun `scenic score`(){
        val row = 1
        val col = 2
        val scenicScore = Puzzle8.scenicScore(testArray, row, col)
        val expectedResult = 4
        Assertions.assertEquals(expectedResult, scenicScore) {
            "$scenicScore should equal $expectedResult"
        }
    }

    @Test
    fun `best scenic score`(){
        val bestScenicScore = Puzzle8.bestScenicScore(testArray)
        val expectedResult = 8
        Assertions.assertEquals(expectedResult, bestScenicScore) {
            "$bestScenicScore should equal $expectedResult"
        }
    }

    @Test
    fun `count visible trees`() {
        val points = Puzzle8.countTreeIfVisibleFromOutside(testArray)
        val expectedResult = 21
        Assertions.assertEquals(expectedResult, points) {
            "$points should equal $expectedResult"
        }
    }

    @ParameterizedTest(name = "{0}, {1} is visible")
    @MethodSource("isVisibleArguments")
    fun `is visible`(i: Int, j: Int, visible: Int){
        Assertions.assertEquals(visible, Puzzle8.visible(testArray, i, j))
    }

    @Test
    fun `input to arraylist`(){
        val input = "30373\n" +
                "25512\n" +
                "65332\n" +
                "33549\n" +
                "35390\n"

        val inputAsArraylist = Puzzle8.readInput(input)
        val expectedResult = testArray
        Assertions.assertEquals(expectedResult.size, inputAsArraylist.size)
        expectedResult.forEachIndexed { index, chars ->
            Assertions.assertArrayEquals(expectedResult[index].toArray(), inputAsArraylist[index].toTypedArray())
        }
    }
}