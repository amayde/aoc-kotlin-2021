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
    println("Part 1 test = ${part1(testInput)}")
    println("Part 2 test = ${part2(testInput)}")

    val input = readInputInt("day01/Day01")
    println("Part 1 = ${part1(input)}")
    println("Part 2 = ${part2(input)}")
}
