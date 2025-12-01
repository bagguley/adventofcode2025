package day1

fun main() {
    println("Test data: ${Part2.calc(testData)}")
    println("Real data: ${Part2.calc(data)}")
}

object Part2 {
    fun calc(input: List<String>): Int {
        return input.runningFold(50 to 0) { r, s ->
            val direction = s.first()
            val turn = s.drop(1).toInt()
            val pos = r.first
            val newPos = when (direction) {
                'R' -> (pos + turn).mod(100)
                else -> (pos - turn).mod(100)
            }

            val zeroCount = when (direction) {
                'R' -> {
                    val diff = 100 - pos
                    if (diff > turn) 0 else {
                        1 + (turn - diff).div(100)
                    }
                }
                else -> {
                    val diff = if (pos == 0) 100 else pos
                    if (turn < diff) 0 else {
                        1 + (turn - diff).div(100)
                    }
                }
            }

            newPos to zeroCount
        }.sumOf { it.second }
    }
}