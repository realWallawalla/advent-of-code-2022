import java.io.File

fun main() {
    val input = File("input.txt").readLines()
        .map { it.toInt() }

    val answer = when (System.getenv("part")) {
        "part2" -> solutionPart2(input)
        else -> solutionPart1(input)
    }
    println(answer)
}

private fun solutionPart1(input: List<Int>): Int {
    return input[0]
}

private fun solutionPart2(input: List<Int>): Int {
    return input[1]
}