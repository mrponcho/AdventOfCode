package day3

import org.junit.jupiter.api.Test
import java.io.File


internal class BinaryDiagnosticTest {
    private val input = arrayListOf(
        "00100",
        "11110",
        "10110",
        "10111",
        "10101",
        "01111",
        "00111",
        "11100",
        "10000",
        "11001",
        "00010",
        "01010",
    )

    private val testData =
        File("src/test/resources/day3/binaryDiagnostics.txt").useLines { it.toList() }

    @Test
    fun testPowerConsumption() {
        assert(getSubmarinePowerConsumption(input) == 198)
    }

    @Test
    fun getPowerConsumptionOutput() {
        println(getSubmarinePowerConsumption(testData))
    }

    @Test
    fun testLifeSupportRating() {
        assert(getLifeSupportRating(input) == 230)
    }

    @Test
    fun getLifeSupportRating() {
        println(getLifeSupportRating(testData))
    }
}
