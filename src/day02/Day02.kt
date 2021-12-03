package day02

import readInput

fun main() {
    fun String.getCommandValue(command: String): Int {
        return if (this.contains(command)) this.removePrefix(command).trim().toInt() else 0
    }

    fun List<String>.getSumValueForCommand(command: String): Int {
        return this.filter { it.contains(command) }.map { it.getCommandValue(command) }.sum()
    }

    fun part1(input: List<String>): Int {
        val horizontal = input.getSumValueForCommand("forward")
        val aim = (input.getSumValueForCommand("down") - input.getSumValueForCommand("up"))
        return (horizontal * aim)
    }

    fun part2(input: List<String>): Int {
        var aim = 0
        var depth = 0
        var horizontal = 0

        input.forEach { command ->
            val value = command.getCommandValue("forward")
            horizontal += value
            if (aim > 0) {
                depth += aim * value
            }
            aim += command.getCommandValue("down")
            aim -= command.getCommandValue("up")
        }

        return (depth * horizontal)
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("day02/Day02_test")
    println("Test part 1 = ${part1(testInput) == 150}")
    println("Test part 2 = ${part2(testInput) == 900}")

    val input = readInput("day02/Day02")
    println("Part 1 = ${part1(input)}")
    println("Part 2 = ${part2(input)}")
}
