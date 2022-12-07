import java.io.File
import java.util.*
fun main() {
    val input = File("input.txt").readLines()
    val answer = when (System.getenv("part")) {"part2" -> solutionPart2(input) else -> solutionPart1(input) }
    println(answer)
}

private fun solutionPart1(input: List<String>): String {
    val ques = mutableMapOf<Long, Fifo>()
    var numberOfQues = 0
    var queContent = listOf<String>()
    var instructions = listOf<String>()
    for ((i, s) in input.iterator().withIndex()) {
        if (s.isNotBlank() && s[1].isDigit()) {
            numberOfQues = s.trim().last().digitToInt()
            queContent = input.subList(0, i)
            instructions = input.subList(i+2, input.size)
            break
        }
    }
    for (i in 1..numberOfQues) { ques.put(i.toLong(), Fifo()) }
    queContent.forEach { s -> s.split("").forEachIndexed { i, s ->
        if (s.isOnlyLetters()) {
            ques.getValue(Math.round((i).toDouble()/4)).add(s)
        }
    } }

    instructions.map {
        listOf(it.substring(5, 7).trim().toLong(), it[it.lastIndexOf("m")+2].digitToInt().toLong(), it.last().digitToInt().toLong()) }
        .map { Intstruction(it[0], it[1], it[2]) }.forEach{
            val crates = ques.getValue(it.from).poll(it.polls)
            ques.getValue(it.to).add(crates)
        }

    return ques.map { it.value.poll() }.joinToString(separator="")
}

private fun solutionPart2(input: List<String>): Int {
    return 2
}
fun String.isOnlyLetters() = length > 0 && all { it.isLetter() }
class Fifo {
    val que: LinkedList<String> = LinkedList()

    fun add(crates: LinkedList<String>) {
        for (crate in crates) { que.addFirst(crate) }
    }
    fun add(crate: String) = que.add(crate)
    fun poll(numberOfpolls: Long): LinkedList<String> {
        val polls = LinkedList<String>()
        for (i in 1..numberOfpolls) { polls.add(que.poll()) }
        return polls
    }
    fun poll(): String = que.poll()
}
class Intstruction(val polls: Long, val from: Long, val to: Long)