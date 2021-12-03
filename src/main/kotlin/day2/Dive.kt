package day2

fun Pair<Int, Int>.multiply(): Int { return first * second }

fun getDepth(input: List<Pair<String, Int>>) = input.map {
    when(it.first) {
        "forward" -> Pair(it.second, 0)
        "down" -> Pair(0, it.second)
        "up" -> Pair(0, it.second * -1)
        else -> Pair(0, 0)
    }
}.reduce { prev, curr -> Pair(prev.first + curr.first, prev.second + curr.second) }.multiply()

data class Dive(
    val x: Int = 0,
    val y: Int = 0,
    val aim: Int = 0,
)

fun Dive.multiply(): Int =  x * y

fun getPreciseDepth(input: List<Pair<String, Int>>) = input.map {
    when(it.first) {
        "forward" -> Dive(it.second, 0, 0)
        "down" -> Dive(0, 0, it.second)
        "up" -> Dive(0, 0, it.second * -1)
        else -> Dive(0, 0, 0)
    }
}.reduce { prev, curr -> Dive(prev.x + curr.x, prev.y + ( prev.aim * curr.x ), prev.aim + curr.aim ) }.multiply()
