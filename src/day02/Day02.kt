package day02

import readInput

fun main() {
    fun String.getCommandValue(command: String): Int {
        return this.removePrefix(command).trim().toInt()
    }

    fun getSumInstruction(input: List<String>, command: String): Int {
       return input.filter { it.contains(command) }.map { it.getCommandValue(command) }.sum()
    }

    fun part1(input: List<String>): Int {
        val sumForward = getSumInstruction(input, "forward")
        val sumDown = getSumInstruction(input, "down")
        val sumUp = getSumInstruction(input, "up")

        return (sumForward * (sumDown - sumUp))
    }

    // TODO find better solution
    fun part2(input: List<String>): Int {
        var aim = 0
        var depth = 0
        var horizontal = 0

        input.forEach { command ->
            when{
                command.contains("forward") -> {
                    val number = command.getCommandValue("forward")
                    horizontal += number
                    if(aim > 0) {
                        depth += aim * number
                    }
                }
                command.contains("down") -> {
                    aim += command.getCommandValue("down")
                }
                command.contains("up") -> {
                    aim -= command.getCommandValue("up")
                }
            }
        }

        return (depth * horizontal)
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("day02/Day02_test")
    println("Part 1 test = ${part1(testInput)}")
    println("Part 2 test = ${part2(testInput)}")

    val input = readInput("day02/Day02")
    println("Part 1 = ${part1(input)}")
    println("Part 2 = ${part2(input)}")
}
