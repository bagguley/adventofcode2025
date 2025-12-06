package day5

import kotlin.math.max
import kotlin.math.min

fun main() {
    println("Test data: ${Part2.calc(testData)}")
    println("Real data: ${Part2.calc(data)}")
}

object Part2 {
    fun calc(input: List<String>): Long {
        val ranges = input.first().split("\n")
            .map { it.split("-").let { LongRange(it.first().toLong(), it[1].toLong()) } }

        val sortedRanges = ranges.sortedBy { it.first }

        val merged = mergeRanges(sortedRanges.first(), sortedRanges.drop(1), listOf())

        return merged.sumOf { (it.last - it.first) + 1L }
    }

    fun mergeRanges(head: LongRange, sortedRanges: List<LongRange>, result: List<LongRange>): List<LongRange> {
        if (sortedRanges.isEmpty()) return result + listOf(head)

        val next = sortedRanges.first()

        if (head.overlaps(next)) {
            val mergedHead = mergeRanges(head, next)
            return mergeRanges(mergedHead, sortedRanges.drop(1), result)
        } else {
            return mergeRanges(next, sortedRanges.drop(1), result + listOf(head))
        }
    }

    fun LongRange.overlaps(other: LongRange): Boolean {
        return (other.first <= this.last + 1 && other.first >= this.first) ||
                (other.last + 1 >= this.first && other.last <= this.last)
    }

    fun mergeRanges(first: LongRange, second: LongRange): LongRange {
        return LongRange(min(first.first, second.first), max(first.last, second.last))
    }
}