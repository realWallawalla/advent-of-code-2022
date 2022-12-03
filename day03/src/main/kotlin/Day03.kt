import java.io.File

fun main() {
    val input = File("input.txt").readLines()
    val answer = when (System.getenv("part")) { "part2" -> solutionPart2(input) else -> solutionPart1(input) }
    println(answer)
}

private fun solutionPart1(input: List<String>): Int {
    val prioTable = ('a'..'z').associateWith { it - 'a' + 1 }.toMutableMap()
    prioTable.putAll(('A'..'Z').associateWith { it - 'A' + 27 })
    val rackSack = input.map { s -> listOf(s.substring(0, Math.floorDiv(s.length, 2)), s.substring(Math.floorDiv(s.length, 2), s.length)) }
    return rackSack.map { comps -> comps[0].firstOrNull { item -> comps[1].contains(item) } }.sumOf { duplicate -> prioTable.getValue(duplicate!!)}
}

private fun solutionPart2(input: List<String>): Int {
    return 2
}

class Racksack(comp1: CharSequence, comp2: CharSequence) {

}