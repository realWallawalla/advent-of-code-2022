import java.io.File

fun main() {
    val input = File("input.txt").readLines().map { it.split(",") }.map { apair ->
        apair.map { section -> Range(section.substringBefore("-").toInt(), section.substringAfter("-").toInt()) } }
    val answer = when (System.getenv("part")) {"part2" -> solutionPart2(input) else -> solutionPart1(input) }
    println(answer)
}

private fun solutionPart1(input: List<List<Range>>): Int {
    return input.filter { pair -> pair[0].rangeContainedInOtherRange(pair[1]) }.count()
}

private fun solutionPart2(input: List<List<Range>>): Int {
    return input.filter { pair -> pair[0].rangeOverlap(pair[1]) }.count()
}

class Range(val min: Int, val max: Int) {
    fun rangeContainedInOtherRange(range: Range): Boolean = (this.min >= range.min && this.max <= range.max) || (this.min <= range.min && this.max >= range.max)
    fun rangeOverlap(range: Range): Boolean = (this.max >= range.min) && (this.min <= range.max)
}