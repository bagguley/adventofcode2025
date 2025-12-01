package day1

fun main() {
    println("Test data: ${Part1.calc(testData)}")
    println("Real data: ${Part1.calc(data)}")
    println("Real data: ${Part1.calc2(data)}")
}

object Part1 {
    fun calc(input: List<String>): Int {
        return input.runningFold(50) { r, s ->
            val direction = s.first()
            val number = s.drop(1).toInt()
            when (direction) {
                'R' -> (r + number).mod(100)
                else -> (r - number).mod(100)
            }
        }.count { it == 0 }
    }

    fun calc2(input: List<String>): Int =
        input.runningFold(50) { r, s ->
            when (s.first()) {
                'R' -> (r + s.drop(1).toInt()).mod(100)
                else -> (r - s.drop(1).toInt()).mod(100)
            }
        }.count { it == 0 }
}