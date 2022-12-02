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
    return input.map { round -> calcScore(round) }.sum()
}

fun calcScore(signs: String): Int {
    val scoreTable = mapOf("AY" to 8, "AX" to 4, "AZ" to 3,  "BX" to 1, "BY" to 5, "BZ" to 9, "CX" to 7, "CY" to 2, "CZ" to 6)
    return scoreTable.getValue(signs)
}

private fun solutionPart2(input: List<String>): Int {
    return 2
}