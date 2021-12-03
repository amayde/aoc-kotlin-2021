package day03

import readInput
import readInputInt

fun main() {

    fun List<String>.mostCommonAtPosition(index: Int): Char? {
        return this.map { it[index] }.sortedDescending().groupBy { it }.mapValues { it.value.size }
            .maxByOrNull { it.value }?.key
    }

    fun List<String>.leastCommonAt(index: Int): Char? {
        return this.map { it[index] }.sorted().groupBy { it }.mapValues { it.value.size }.minByOrNull { it.value }?.key
    }

    fun part1(input: List<String>): Int {
        var gamma = ""
        var epsilon = ""
        input.first().indices.forEach {
            gamma += input.mostCommonAtPosition(it)
            epsilon += input.leastCommonAt(it)
        }

        val gammaInt = Integer.parseInt(gamma, 2)
        val epsilonInt = Integer.parseInt(epsilon, 2)

        return gammaInt * epsilonInt
    }

    fun recursiveMostSearch(input: List<String>, index: Int): String {
        val test = input.mostCommonAtPosition(index).toString()
        val filteredInput = input.filter { it[index].toString() == test }

        if (filteredInput.size != 1) {
            return recursiveMostSearch(filteredInput, index + 1)
        } else {
            return filteredInput[0]
        }
    }

    fun recursiveLeastSearch(input: List<String>, index: Int): String {
        val test = input.leastCommonAt(index).toString()
        val filteredInput = input.filter { it[index].toString() == test }

        if (filteredInput.size != 1) {
            return recursiveLeastSearch(filteredInput, index + 1)
        } else {
            return filteredInput[0]
        }
    }

    fun part2(input: List<String>): Int {
        val oxygenRate = Integer.parseInt(recursiveMostSearch(input, 0), 2)
        val co2Rate = Integer.parseInt(recursiveLeastSearch(input, 0), 2)

        return oxygenRate * co2Rate
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("day03/Day03_test")
    println("Test part 1 = ${part1(testInput)}")
    println("Test part 2 = ${part2(testInput)}")

    val input = readInput("day03/Day03")
    println("Part 1 = ${part1(input)}")
    println("Part 2 = ${part2(input)}")
}
