package day4

import util.toGameMap

fun main() {
    println("Test data: ${Part1.calc(testData)}")
    println("Real data: ${Part1.calc(data)}")
}

object Part1 {
    fun calc(input: List<String>): Int {
        val gameMap = input.toGameMap()

        return gameMap
            .filter { _, c -> c == '@' }
            .count { p ->
                gameMap.neighbours(p.first, '.').count { it == '@' } < 4
            }
    }
}