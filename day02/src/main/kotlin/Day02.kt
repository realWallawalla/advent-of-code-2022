import java.io.File

fun main() {
    val input = File("input.txt").readLines().map { it.filter { !it.isWhitespace() } }
    val answer = when (System.getenv("part")) {
        "part2" -> solutionPart2(input)
        else -> solutionPart1(input)
    }
    println(answer)
}

private fun solutionPart1(input: List<String>): Int {
    val scoreTable = mapOf("AY" to 8, "AX" to 4, "AZ" to 3,  "BX" to 1, "BY" to 5, "BZ" to 9, "CX" to 7, "CY" to 2, "CZ" to 6)
    return input.map { round -> scoreTable.getValue(round) }.sum()
}

private fun solutionPart2(input: List<String>): Int {
    val scoreTable = mapOf("AY" to 4, "AX" to 3, "AZ" to 8,  "BX" to 1, "BY" to 5, "BZ" to 9, "CX" to 2, "CY" to 6, "CZ" to 7)
    return input.map { round -> scoreTable.getValue(round) }.sum()
}