import kotlin.math.tan

fun main() {
    println("Welcome! To-Do App")
    val todoList: MutableList<String?> = mutableListOf()
    while (true) {
        println("To add use 'Add', to delete use 'Delete', to view use 'Show', to find use 'Find', and to edit use 'Edit'")
        val input = readlnOrNull().toString()
        when (input) {
            "Add" -> addTodo(todoList)
            "Show" -> showTodo(todoList)
            else -> {
                println("You Entered Wrong Value")
                continue
            }
        }
    }
}

fun addTodo(todoList: MutableList<String?>){
    println("Enter To-Do :")
    println("Type 'Exit' to Exit")
    while (true) {
        val userInput = readlnOrNull()
        if (userInput == null) {
            println("You entered wrong value.")
            continue
        } else if (userInput == "Exit") {
            break
        } else {
            todoList.add(userInput)
        }
    }
}

fun showTodo(todoList: MutableList<String?>): MutableList<String?> {
    println("Todo Listesi:")
    val show: MutableList<String?> = mutableListOf()
    var count = 1
    for (i in todoList) {
        println("$count-$i")
        count++
    }
    return show
}