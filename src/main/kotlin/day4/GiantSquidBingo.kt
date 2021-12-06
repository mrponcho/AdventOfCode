package day4

data class Field (
    val x: Int,
    val y: Int,
    val value: Int,
    var marked: Boolean = false,
)

fun List<Field>.byValues() = this.groupBy { it.value }.mapValues { it.value.first() }

fun List<Field>.setMarked(value: Int) { this.byValues()[value]?.marked = true }

fun List<Field>.getScore() = this.filter { !it.marked }.sumOf { it.value }

fun List<Field>.getColumn(column: Int) = this.filter { it.x == column }

fun List<Field>.getRow(row: Int) = this.filter { it.y == row }

fun List<Field>.getSize() = this.maxByOrNull { it.x }?.x

fun List<Field>.isColumnMarked(column: Int) = this.getColumn(column).all { it.marked }

fun List<Field>.isRowMarked(row: Int) = this.getRow(row).all { it.marked }

fun List<Field>.hasWon(): Boolean {
    for (i in 0..this.getSize()!!) {
        if(this.isColumnMarked(i).or(this.isRowMarked(i))) {
            return true
        }
    }
    return false
}

fun transformInputToFields(input: List<List<List<Int>>>): List<List<Field>> {
    return input.map { board ->
        board.flatMapIndexed{ x, row ->
            row.mapIndexed { y, value -> Field(x, y, value) }
        }
    }
}

fun play(boards: List<List<Field>>, values: List<Int>): Int {
    for (value in values) {
        for (board in boards) {
            board.setMarked(value)
            if(board.hasWon()) {
                return board.getScore() * value
            }
        }
    }
    return 0
}

fun playLoserWins(boards: List<List<Field>>, values: List<Int>): Int {
    val winner = mutableListOf<Int>()
    for (value in values) {
        boards.forEachIndexed { index, board ->
            board.setMarked(value)
            if(board.hasWon()) { winner.add(index) }
            if(winner.distinct().size == boards.size) {
                return boards[winner.last()].getScore() * value
            }
        }
    }
    return 0
}
