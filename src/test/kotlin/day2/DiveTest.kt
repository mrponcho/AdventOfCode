package day2

import org.junit.jupiter.api.Test
import java.io.File

internal class DiveTest {
    private val input = listOf(
        Pair("forward", 5),
        Pair("down", 5),
        Pair("forward", 8),
        Pair("up", 3),
        Pair("down", 8),
        Pair("forward", 2),
    )

    private val testData =
        File("src/test/resources/day2/dive.txt").useLines {
            it.toList().map { entry -> entry.split(" ").let { (a,b) -> Pair(a, b.toInt()) } }
        }

    @Test
    fun testDive() {
        assert(getDepth(input) == 150)
    }

    @Test
    fun getDive() {
        println(getDepth(testData))
    }

    @Test
    fun testPreciseDive() {
        assert(getPreciseDepth(input) == 900)
    }

    @Test
    fun getPreciseDive() {
        println(getPreciseDepth(testData))
    }
}
