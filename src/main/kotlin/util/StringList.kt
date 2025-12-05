package util

fun List<String>.findChar(char: Char): List<Vec2> =
    this.flatMapIndexed { y, s -> s.mapIndexed { x, c -> x to c }.filter { it.second == char }.map { Vec2(it.first, y) } }

fun List<String>.getOr(position: Vec2, default: Char): Char =
    this.getOrNull(position.y)?.getOrNull(position.x) ?: default

fun List<String>.setAt(position: Vec2, char: Char) =
    this.toMutableList().apply { this[position.y] = StringBuilder(this[position.y])
        .also { it.setCharAt(position.x, char) }.toString() }

fun <T> List<String>.toVec2Map(transform: (Char) -> T): Map<Vec2, T> =
    this.flatMapIndexed { y, l -> l.mapIndexed { x, c -> Vec2(x, y) to (transform(c)) } }.associate { it }

fun List<String>.dimensions(): Pair<Int, Int> = this[0].length to this.size

fun List<String>.width(): Int = this[0].length
fun List<String>.height(): Int = this.size

fun List<String>.transpose(): List<String> = this.map { it.map { c -> "$c" } }.reduce { a, b -> a.zip(b) { c, d -> c + d } }

fun List<String>.print() {
    for (y in indices) {
        val row = get(y)
        for (x in row.indices) {
            print(get(y)[x])
        }
        println()
    }
}