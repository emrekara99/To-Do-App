fun main() {
    println("Welcome! To-Do App")
    val todoList: MutableList<String?> = mutableListOf()
    while (true) {
        println("To add use 'Add', to delete use 'Delete', to view use 'Show', to find use 'Find', and to edit use 'Edit'")
        val input = readlnOrNull().toString()
        val lowerCaseInput = input.lowercase()
        when (lowerCaseInput) {
            "add" -> addTodo(todoList)
            "show" -> showTodo(todoList)
            "delete" -> deleteTodo(todoList)
            "find" -> findTodo(todoList)
            "edit" -> editTodo(todoList)
            else -> {
                println("You Entered Wrong Value")
                continue
            }
        }
    }
}

fun addTodo(todoList: MutableList<String?>) {
    println("Enter To-Do :")
    println("Type 'Exit' to Exit")
    while (true) {
        val userInput = readlnOrNull()
        val lowerCaseUserInput = userInput?.lowercase()
        if (userInput.isNullOrEmpty()) {
            println("You entered wrong value.")
            continue
        } else if (lowerCaseUserInput?.first() == ' ') {
            println("You entered Wrong value")
            continue
        } else if (lowerCaseUserInput == "exit") {
            break
        } else {
            todoList.add(userInput)
        }
    }
}

fun showTodo(todoList: MutableList<String?>): MutableList<String?> {
    println("Todo List:")
    val show: MutableList<String?> = mutableListOf()
    var count = 1
    for (i in todoList) {
        println("$count-$i")
        count++
    }
    return show
}

fun deleteTodo(todoList: MutableList<String?>) {
    showTodo(todoList)
    println("Enter the number you want to remove:")
    val userInput = readln().toInt()
    val updatedUserInput = userInput.minus(1)
    todoList.removeAt(updatedUserInput)
}

fun findTodo(todoList: MutableList<String?>) {
    while (true) {
        println("To find a To-do Enter the first letter:")
        val userInput = readlnOrNull()
        var count = 1
        if (userInput == null) {
            println("You Entered Wrong Value")
            continue
        } else {
            val asd = todoList.filter { it?.startsWith(userInput) ?: true }
            for (i in asd) {
                println("$count-$i")
                count++
            }
            break
        }
    }
}

fun editTodo(todoList: MutableList<String?>) {
    while (true) {
        showTodo(todoList)
        println("Enter the number of To-Do You want to edit")
        val userInput: Int? = readln().toIntOrNull()
        if (userInput == null) {
            println("You entered wrong value")
            continue
        } else {
            println("To do To Be edit:${todoList[userInput-1]}")
            println("Enter Edited To-Do:")
            val editedTodo = readlnOrNull().toString()
            todoList.removeAt(userInput - 1)
            todoList.add(index = userInput - 1, editedTodo)
            showTodo(todoList)
            break
        }
    }
}