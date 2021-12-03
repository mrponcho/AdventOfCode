package day1

fun getDepthMeasurementsIncreases(input: List<Int>) = input.windowed(2) {(a, b) -> if (a < b) 1 else 0 }.sum()

fun getPreciseMeasurement(input: List<Int>) = getDepthMeasurementsIncreases(input.windowed(3, 1) { (a,b,c) -> a + b + c })
