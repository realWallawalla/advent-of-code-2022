import java.io.File

fun main() {
    val input = File("input.txt").readLines()
    val prioTable = ('a'..'z').associateWith { it - 'a' + 1 }.toMutableMap()
    prioTable.putAll(('A'..'Z').associateWith { it - 'A' + 27 })
    val answer = when (System.getenv("part")) {
        "part2" -> solutionPart2(input, prioTable) else -> solutionPart1(input, prioTable) }
    println(answer)
}

private fun solutionPart1(input: List<String>, prioTable: MutableMap<Char, Int>): Int {
    val rackSacks = input.map { s -> listOf(s.substring(0, Math.floorDiv(s.length, 2)), s.substring(Math.floorDiv(s.length, 2), s.length)) }
    return rackSacks.map { comps -> comps[0].first { item -> comps[1].contains(item) } }.sumOf { duplicate -> prioTable.getValue(duplicate) }
}

private fun solutionPart2(input: List<String>, prioTable: MutableMap<Char, Int>): Int {
    return input.chunked(3).map { group -> group[0].first { item -> group[1].contains(item) && group[2].contains(item) }}
        .sumOf { badge -> prioTable.getValue(badge) }
}