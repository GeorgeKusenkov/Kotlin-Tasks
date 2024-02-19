fun main() {
    val employeeOne = HourlyEmployee("Petya", 27, 10.0, 200.0 )
    val employeeTwo = SalariedEmployee("Vasya", 45, 10000.0 )
    employeeOne.info()
    employeeTwo.info()
}

abstract class Employee(
    val name: String,
    val age: Int,
) {
    abstract fun info()
}

interface Payable {
    fun salary(): Double
}

class HourlyEmployee(
    name: String,
    age: Int,
    private val hoursWorked: Double,
    private val hourRate: Double
) : Employee(name, age), Payable {
    override fun info() {
        println("==================")
        println("Hourly Employee")
        println("Name: $name")
        println("Age: $age")
        println("Salary: ${salary()}\n")
    }

    override fun salary(): Double {
        return hourRate * hoursWorked
    }
}

class SalariedEmployee(name: String, age: Int, private val salary: Double) : Employee(name, age), Payable {
    override fun info() {
        println("==================")
        println("Hourly Employee")
        println("Name: $name")
        println("Age: $age")
        println("Salary: ${salary()}\n")
    }

    override fun salary(): Double {
        return salary
    }
}
