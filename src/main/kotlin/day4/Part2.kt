package day4

import util.setAt
import util.toGameMap


fun main() {
    println("Test data: ${Part2.calc(testData)}")
    println("Real data: ${Part2.calc(data)}")
}

object Part2 {
    fun calc(input: List<String>): Int {
        var inputString = input
        var gameMap = input.toGameMap()

        var count = 0

        while ( true) {
            val toRemove = gameMap
                .filter { _, c -> c == '@' }
                .filter { p ->
                    gameMap.neighbours(p.first, '.').count { it == '@' } < 4
                }

            if (toRemove.isEmpty()) return count

            count += toRemove.size

            toRemove.forEach {
                inputString = inputString.setAt(it.first, '.')
            }

            gameMap = inputString.toGameMap()
        }
    }
}