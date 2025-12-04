package day3


fun main() {
    println("Test data: ${Part2.calc(testData)}")
    println("Real data: ${Part2.calc(data)}")
}

object Part2 {
    fun calc(input: List<String>): Long = input.sumOf { maxOf("", it) }

    fun maxOf(head: String, tail: String): Long {
        val remaining = 12 - head.length
        return if (tail.length < remaining) 0 else {
            val next = highest(tail.dropLast(remaining - 1))
            val newHead = head + next.second.digitToChar()
            if (newHead.length == 12) newHead.toLong() else {
                maxOf(newHead, tail.drop(next.first + 1))
            }
        }
    }

    fun highest(input: String): Pair<Int, Int> =
        input.foldIndexed(-1 to -1) { idx, acc, chr ->
            if (chr.digitToInt() > acc.second) idx to chr.digitToInt() else acc
        }
}