import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class Puzzle3Test {

    companion object {
        val testArray = listOf(
            "vJrwpWtwJgWrhcsFMMfFFhFp",
            "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL",
            "PmmdzqPrVvPwwTWBwg",
            "wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn",
            "ttgJtRGJQctTZtZT",
            "CrZsJsPPZsGzwwsLwLmpwMDw"
        )

        @JvmStatic
        fun halvesArguments(): List<Arguments> {
            var retVal = mutableListOf<Arguments>()
            retVal.add(Arguments.of("vJrwpWtwJgWrhcsFMMfFFhFp", "vJrwpWtwJgWr", "hcsFMMfFFhFp"))
            retVal.add(Arguments.of("jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL", "jqHRNqRjqzjGDLGL", "rsFMfFZSrLrFZsSL"))
            return  retVal
        }

        @JvmStatic
        fun priorityArguments(): List<Arguments> {
            var retVal = mutableListOf<Arguments>()
            retVal.add(Arguments.of(testArray[0], 16))
            retVal.add(Arguments.of(testArray[1], 38))
            retVal.add(Arguments.of(testArray[2], 42))
            retVal.add(Arguments.of(testArray[3], 22))
            retVal.add(Arguments.of(testArray[4], 20))
            retVal.add(Arguments.of(testArray[5], 19))
            return  retVal
        }

        @JvmStatic
        fun priorityArgumentsByThree(): List<Arguments> {
            var retVal = mutableListOf<Arguments>()
            retVal.add(Arguments.of(listOf(testArray[0], testArray[1], testArray[2]), 18))
            retVal.add(Arguments.of(listOf(testArray[3], testArray[4], testArray[5]), 52))
            return retVal
        }
    }

    @ParameterizedTest(name = "{0} = {1} + {2}")
    @MethodSource("halvesArguments")
    fun `split string to 2 halves`(input: String, firstHalf: String, secondHalf: String){
        Assertions.assertArrayEquals(arrayOf(firstHalf, secondHalf), Puzzle3.splitHalf(input))
    }

    @ParameterizedTest(name = "Priotity of {0} = {1}")
    @MethodSource("priorityArguments")
    fun `getPriority`(input: String, expectedPriority: Int ){
        Assertions.assertEquals(expectedPriority, Puzzle3.getPriority(input))
    }

    @Test
    fun `get sum of priorities`(){
        val sumOfPriorities = Puzzle3.sumOfPriorities(testArray)
        val expectedResult = 157
        Assertions.assertEquals(expectedResult, sumOfPriorities) {
            "$sumOfPriorities should equal $expectedResult"
        }
    }

    @ParameterizedTest(name = "Priotity of {0} = {1}")
    @MethodSource("priorityArgumentsByThree")
    fun `get prioritie by three group`(inputs: List<String>, expectedPriority: Int){
        Assertions.assertEquals(expectedPriority, Puzzle3.getPriority(inputs))
    }

    @Test
    fun `get sum of priorities by three`(){
        val sumOfPriorities = Puzzle3.sumOfPrioritiesByThree(testArray)
        val expectedResult = 70
        Assertions.assertEquals(expectedResult, sumOfPriorities) {
            "$sumOfPriorities should equal $expectedResult"
        }
    }

    @Test
    fun `input to arraylist`(){
        val input = "vJrwpWtwJgWrhcsFMMfFFhFp\n" +
                "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL\n" +
                "PmmdzqPrVvPwwTWBwg\n" +
                "wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn\n" +
                "ttgJtRGJQctTZtZT\n" +
                "CrZsJsPPZsGzwwsLwLmpwMDw"

        val inputAsArraylist = Puzzle3.readInput(input)
        val expectedResult = testArray
        Assertions.assertArrayEquals(expectedResult.toTypedArray(), inputAsArraylist.toTypedArray())
    }
}