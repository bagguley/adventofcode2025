package day5

fun main() {
    println("Test data: ${Part1.calc(testData)}")
    println("Real data: ${Part1.calc(data)}")
}

object Part1 {
    fun calc(input: List<String>): Int {
        val ranges = input.first().split("\n")
            .map { it.split("-").let { LongRange(it.first().toLong(), it[1].toLong()) } }

        val ids = input[1].split("\n")
            .map { it.toLong() }

        return ids.count { id -> ranges.any { r -> r.contains(id) } }
    }
}