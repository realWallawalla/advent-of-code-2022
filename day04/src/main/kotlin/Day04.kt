import java.io.File

fun main() {
    val input = File("input.txt").readLines()
    val answer = when (System.getenv("part")) {"part2" -> solutionPart2(input) else -> solutionPart1(input) }
    println(answer)
}

private fun solutionPart1(input: List<String>): Int {
    return input.map { it.split(",") }.filter { apair -> Range(apair[0].substringBefore("-").toInt(),
        apair[0].substringAfter("-").toInt()).rangeContainedInOtherRange(Range(apair[1].substringBefore("-").toInt(),
        apair[1].substringAfter("-").toInt())) }.count()
}

private fun solutionPart2(input: List<String>): Int {
    return 2
}

class Range(val min: Int, val max: Int) {
    fun rangeContainedInOtherRange(range: Range): Boolean = (this.min >= range.min && this.max <= range.max) || (this.min <= range.min && this.max >= range.max)
}