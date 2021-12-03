package day01

import readInputInt

fun main() {
    fun part1(input: List<Int>): Int {
        return input.windowed(2).count { (a, b) -> a < b }
    }

    fun part2(input: List<Int>): Int {
        return part1(input.windowed(3, 1, true).map { it.sum() })
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInputInt("day01/Day01_test")
    println("Test part 1 = ${part1(testInput) == 7}")
    println("Test part 2 = ${part2(testInput) == 5}")

    val input = readInputInt("day01/Day01")
    println("Part 1 = ${part1(input)}")
    println("Part 2 = ${part2(input)}")
}
