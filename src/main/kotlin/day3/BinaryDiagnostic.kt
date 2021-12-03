package day3

// https://adventofcode.com/2021/day/3
private fun String.flipBits() = toList().map { if (it == '0') '1' else '0' }.joinToString("")

private fun getColumn(matrix: List<String>, col: Int) = List(matrix.size) { matrix[it][col] }

private fun getGamma(input: List<String>): String =
    input[0].indices.map { i -> input.map { it[i] }.groupBy { it }.maxByOrNull { it.value.size }?.key }.joinToString("")

fun getSubmarinePowerConsumption(input: List<String>): Int =
    getGamma(input).let { gamma -> gamma.toInt(2) * gamma.flipBits().toInt(2) }

fun calcRating(input: List<String>, index: Int = 0, compare: (map: Map<Char, Int>) -> Char): Int {
    if (input.size == 1) return Integer.parseInt(input[0], 2)
    val char = compare(getColumn(input, index).groupingBy { it }.eachCount())
    val result = input.filter { it[index] == char }
    return calcRating(result,index + 1, compare)
}

fun getLifeSupportRating(input: List<String>): Int =
    calcRating(input) { if (it['1']!! >= it['0']!!) '1' else '0' } * calcRating(input) { if (it['0']!! <= it['1']!!) '0' else '1' }
