package day2

fun main() {
    println("Test data: ${Part2.calc(testData)}")
    println("Real data: ${Part2.calc(data)}")
}

object Part2 {
    fun calc(input: List<List<String>>): Long = input.sumOf { countInvalid(it[0].toLong(), it[1].toLong()) }

    fun countInvalid(start: Long, end: Long): Long = (start..end).filter { isInvalid(it) }.sum()

    fun isInvalid(number: Long): Boolean = (number.halfLength() downTo 1).any { isInvalid(number.toString(), it) }

    fun isInvalid(str: String, length: Int): Boolean = if (str.splitsInto(length)) str.isInvalidForSplit(length) else false

    private fun Long.halfLength() = this.toString().length.div(2)

    private fun String.splitsInto(length: Int) = this.length.mod(length) == 0

    private fun String.isInvalidForSplit(split: Int) = this.chunked(split).toSet().size == 1
}