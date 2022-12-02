import java.io.File

fun main() {
    val input = File("input.txt").readLines().toMutableList()
    input.add("")
    val answer = when (System.getenv("part")) {
        "part2" -> solutionPart2(input)
        else -> solutionPart1(input)
    }
    println(answer)
}

private fun solutionPart1(input: MutableList<String>): Int {
    return createElfes(input).sortedBy { it.getTotCal() }.last().getTotCal()
}

private fun solutionPart2(input: List<String>): Int {
    return createElfes(input).sortedBy { it.getTotCal() }.takeLast(3).map { it.getTotCal() }.sum()
}

private fun createElfes(input: List<String>): MutableList<Elf> {
    val elfes = mutableListOf<Elf>()
    var elf = Elf()
    for (row in input) {
        if (row.isBlank()) {
            elfes.add(elf)
            elf = Elf()
        } else
            elf.addFood(row.toInt())
    }
    return elfes
}

class Elf {
    private val food = mutableListOf<Int>()
    fun addFood(cal: Int) {
        food.add(cal)
    }
    fun getTotCal(): Int {
        return food.sum()
    }
}
