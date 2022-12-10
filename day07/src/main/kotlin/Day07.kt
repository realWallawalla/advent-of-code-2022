
fun main() {
    val input = java.io.File("inputtest.txt").readLines().iterator()
    val answer = when (System.getenv("part")) {
        "part2" -> solutionPart2(input)
        else -> solutionPart1(input)
    }
    println(answer)
}
var currentDirectory = Directory("", null)
val allDirs = mutableListOf<Directory>()
private fun solutionPart1(iterator: Iterator<String>): Int {
    val root = Directory(iterator.next()[5].toString(), null)
    currentDirectory = root
    var command = iterator.next()

    while (iterator.hasNext()) {
        command = when(command[0]) {
            '$' ->
                if (command.contains("ls")) {
                    addChildren(currentDirectory, iterator)
                } else if (command[5] == '.') {
                    currentDirectory = currentDirectory.parent!!
                    iterator.next()
                } else  {
                        //val newCurrentDir = currentDirectory.children.values.first { dir -> dir.value == command.substring(5, command.length) }
                        val newCurrentDir = currentDirectory.children.getValue(command.substring(5, command.length))
                        currentDirectory = newCurrentDir
                        iterator.next()
                }
            else -> throw RuntimeException("inputfile corrupted, code should not come here")
            }
        }
    return allDirs.map { it.getDirStorageSize(it) }.filter { it < 100_000  }.sum()
}
fun addChildren(parent: Directory, iterator: Iterator<String>): String {
    var command = iterator.next()
    while (command[0] != '$' && iterator.hasNext()) {
        when(command[0]) {
            'd' -> {
                val value = command.substring(4, command.length)
                val child = Directory(value, parent)
                parent.add(value, child)
                allDirs.add(child)
            }
            else -> {
                val fileData = command.split(" ")
                parent.add(File(fileData[0].toInt(), fileData[1]))
            }
        }
        command = iterator.next()
    }
    return command
}
private fun solutionPart2(input: Iterator<String>): Int {
    return 2
}
data class Directory(val value: String, val parent: Directory?) {
    val children = mutableMapOf<String, Directory>()
    val files = mutableSetOf<File>()

    fun add(key: String, child: Directory) = children.set(key, child)
    fun add(file: File) = files.add(file)
    fun getDirStorageSize(dir: Directory): Int {
        val fileStorageSize = dir.files.sumOf { it.storageSize }
        if (dir.children.size != 0) {
            for (child in dir.children.values) {
                return fileStorageSize + getDirStorageSize(child)
            }
        }
        return fileStorageSize
    }
}
class File(val storageSize: Int, val name: String)