import java.io.File

fun main() {
    val input = File("input.txt").readLines()
    val answer = when (System.getenv("part")) {
        "part2" -> solutionPart2(input)
        else -> solutionPart2(input)
    }
    println(answer)
}

private fun solutionPart1(input: List<String>): Int {
    val scoreTable = mapOf("A Y" to 8, "A X" to 4, "A Z" to 3,  "B X" to 1, "B Y" to 5, "B Z" to 9, "C X" to 7, "C Y" to 2, "C Z" to 6)
    return input.map { round -> scoreTable.getValue(round) }.sum()
}

private fun solutionPart2(input: List<String>): Int {
    val scoreTable = mapOf("A Y" to 4, "A X" to 3, "A Z" to 8,  "B X" to 1, "B Y" to 5, "B Z" to 9, "C X" to 2, "C Y" to 6, "C Z" to 7)
    return input.map { round -> scoreTable.getValue(round) }.sum()
}