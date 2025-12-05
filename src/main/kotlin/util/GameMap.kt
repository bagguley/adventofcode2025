package util

import kotlin.Int
import kotlin.collections.flatMapIndexed

class GameMap(val width: Int, val height: Int) {
    private lateinit var map: Map<Vec2, Char>

    constructor(input: List<String>) : this(input.dimensions().first, input.dimensions().second) {
        map = input.flatMapIndexed { y, s -> s.mapIndexed { x, c -> Vec2(x,y) to c } }.toMap()
    }

    fun filter(filter: (Vec2, Char) -> Boolean): List<Pair<Vec2, Char>> {
        return sequence {
            for (y in 0..< height) {
                for (x in 0..< width) {
                    yield(Vec2(x, y))
                }
            }
        }.map { it to map[it]!! }.asIterable().filter { filter(it.first, it.second ) }
    }

    fun <R> map(transform: (Vec2, Char) -> R): List<R> {
        return sequence {
            for (y in 0..< height) {
                for (x in 0..< width) {
                    yield(Vec2(x, y))
                }
            }
        }.asIterable().map { transform.invoke(it, map[it]!!) }
    }

    fun forEach(default: Char, operation: (Vec2, Char) -> Unit) {
        sequence {
            for (y in 0..< height) {
                for (x in 0..< width) {
                    yield(Pair(Vec2(x, y), get(x, y, default)))
                }
            }
        }.forEach { operation(it.first, it.second) }
    }

    fun neighbours(start: Vec2, default: Char): List<Char> = Direction.ALL.map { map.getOrDefault((start + it), default) }

    fun get(x: Int, y: Int, default: Char): Char = map.getOrDefault(Vec2(x, y), default)
    fun get(vec: Vec2, default: Char): Char = map.getOrDefault(vec, default)
}

fun List<String>.toGameMap() = GameMap(this)
