import java.io.File

fun main() {
    val input = File("input.txt").readLines()
    val answer = when (System.getenv("part")) {
        "part2" -> solutionPart2(input)
        else -> solutionPart1(input)
    }
    println(answer)
}

private fun solutionPart1(input: List<String>): Int {
    return charBeforeMarker(input, 4)
}

private fun charBeforeMarker(input: List<String>, codeSize: Int): Int {
    var charsBeforeMarker = 0
    outer@ for (s in input) {
        for ((i, _) in s.iterator().withIndex()) {
            if (s.substring(i, i + codeSize).isUnique()) {
                charsBeforeMarker = i + codeSize
                break@outer
            }
        }
    }
    return charsBeforeMarker
}

private fun solutionPart2(input: List<String>): Int {
    return charBeforeMarker(input, 14)
}
fun String.isUnique(): Boolean = all(hashSetOf<Char>()::add)
