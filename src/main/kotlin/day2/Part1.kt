package day2

fun main() {
    println("Test data: ${Part1.calc(testData)}")
    println("Real data: ${Part1.calc(data)}")
}

object Part1 {
    fun calc(input: List<List<String>>): Long = input.sumOf { countInvalid(it[0].toLong(), it[1].toLong()) }

    fun countInvalid(start: Long, end: Long): Long = (start..end).filter { isInvalid(it.toString()) }.sum()

    fun isInvalid(str: String): Boolean = if (!str.splitsInHalf()) false else str.chunked(str.halfLength()).toSet().size == 1

    fun String.halfLength() = this.length.div(2)

    private fun String.splitsInHalf() = this.length.mod(2) == 0
}