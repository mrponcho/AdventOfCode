package day1

import org.junit.jupiter.api.Test
import java.io.File

internal class SonarSweepTest {
    private val input = listOf(
        199,
        200,
        208,
        210,
        200,
        207,
        240,
        269,
        260,
        263,
    )

    private val testData =
        File("src/test/resources/day1/sonarSweep.txt").useLines { it.toList().map { entry -> entry.toInt() } }


    @Test
    fun testMeasurement() {
        assert(getDepthMeasurementsIncreases(input) == 7)
    }

    @Test
    fun getMeasurement() {
        println(getDepthMeasurementsIncreases(testData))
    }

    @Test
    fun testPreciseMeasurement() {
        assert(getPreciseMeasurement(input) == 5)
    }

    @Test
    fun getPreciseMeasurement() {
        println(getPreciseMeasurement(testData))
    }
}
