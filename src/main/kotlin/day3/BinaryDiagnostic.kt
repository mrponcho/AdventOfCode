package day3

// https://adventofcode.com/2021/day/3
private fun String.flipBits() = toList().map { if (it == '0') '1' else '0' }.joinToString("")

private fun getColumn(matrix: List<String>, col: Int) = List(matrix.size) { matrix[it][col] }

private fun getGamma(input: List<String>): String =
    input[0].indices.map { i -> input.map { it[i] }.groupBy { it }.maxByOrNull { it.value.size }?.key }.joinToString("")

fun calcGammaEpsilon (input: List<String>): Pair<Int, Int> =
    Pair(Integer.parseInt(getGamma(input), 2), Integer.parseInt(getGamma(input).flipBits(), 2))

fun getSubmarinePowerConsumption(input: List<String>): Int =
    calcGammaEpsilon(input).toList().reduce { acc, i -> acc * i  }

fun calcRating(input: List<String>, index: Int = 0, compare: (map: Map<Char, Int>) -> Char): Int {
    if (input.size == 1) return Integer.parseInt(input[0], 2)
    val char = compare(getColumn(input, index).groupingBy { it }.eachCount())
    val result = input.filter { it[index] == char }
    return calcRating(result,index + 1, compare)
}

fun getLifeSupportRating(input: List<String>): Int =
    calcRating(input) { if (it['1']!! >= it['0']!!) '1' else '0' } * calcRating(input) { if (it['0']!! <= it['1']!!) '0' else '1' }

