package util

import kotlin.math.abs

data class Vec2(val x: Int, val y: Int)

infix fun Vec2.distanceTo(other: Vec2): Int = abs(x - other.x) + abs(y - other.y)

fun List<Vec2>.allPairs(): List<Pair<Vec2, Vec2>> = flatMap { p -> (this - p).map { n -> p to n } }
fun List<Vec2>.allLaterPairs(skip: Int = 1): List<Pair<Vec2, Vec2>> = flatMapIndexed { i, p -> this.drop(i + skip).map { n -> p to n } }

operator fun Vec2.plus(direction: Direction): Vec2 = Vec2(this.x + direction.x, this.y + direction.y)
operator fun Vec2.plus(other: Vec2): Vec2 = Vec2(this.x + other.x, this.y + other.y)
operator fun Vec2.minus(direction: Direction): Vec2 = Vec2(this.x - direction.x, this.y - direction.y)
operator fun Vec2.minus(other: Vec2): Vec2 = Vec2(this.x - other.x, this.y - other.y)
operator fun Vec2.times(times: Int): Vec2 = Vec2(this.x * times, this.y * times)