package day3

fun main() {
    println("Test data: ${Part1.calc(testData)}")
    println("Real data: ${Part1.calc(data)}")
}

object Part1 {
    fun calc(input: List<String>): Int = input.sumOf { maxPair(it) }

    fun maxPair(input: String): Int {
        val first = highest(input.dropLast(1))
        val second = highest(input.drop(first.first + 1))
        return "${first.second}${second.second}".toInt()
    }

    fun highest(input: String): Pair<Int, Int> {
        return input.foldIndexed(-1 to -1) { idx, acc, chr ->
            if (chr.digitToInt() > acc.second) idx to chr.digitToInt() else acc
        }
    }
}