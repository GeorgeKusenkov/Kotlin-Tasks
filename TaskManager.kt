fun main() {
    val listOfTask = TaskManager()

    val tasksToAdd = listOf(
        Task("1", "Tell about our work", "12.02.2024", false),
        Task("2", "New car for travel", "27.03.2024", false),
        Task("3", "The cat is hungry and needs food", "20.03.2024", true),
        Task("4", "The cat is hungry and needs food", "20.03.2024", false)
    )

    listOfTask.addSeveralTasks(*tasksToAdd.toTypedArray())
    listOfTask.info()
    listOfTask.sortByStatus()
    listOfTask.info()
}

data class Task (
    val taskName: String,
    val description: String,
    val date: String,
    val status: Boolean
)

class TaskManager {
    private val taskList: MutableList<Task> = mutableListOf()

    fun addTask(task: Task) {
        taskList.add(task)
    }

    fun addSeveralTasks(vararg tasks: Task) {
        taskList.addAll(tasks)
    }

    fun deleteTask(index: Int) {
        if (index in taskList.indices) {
            taskList.removeAt(index)
        } else {
            println("Task index out of bounds")
        }
    }

    fun sortByStatus() {
        taskList.sortBy { it.status }
    }

    fun info() {
        taskList.forEach {
            with(it) {
                println("=================")
                println("Task: $taskName")
                println("Description: $description")
                println("Date: $date")
                println("Status: $status")
                println("=================\n")
            }
        }
    }
}
