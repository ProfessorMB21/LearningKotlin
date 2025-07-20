import java.security.InvalidParameterException

// A taste of object-oriented programming in Kotlin
// Similarly to Java, a class in Kotlin is defined using a `class` keyword

fun main() {

    val person = Person()
    person.firstName = "john"
    person.lastName = "smith"
    person.age = 21

    println(person.getFullName())
    println(person.getPersonAge())

    val persona = Persona("john", "smith", 21)
    println(persona.getPersonaFullName())

    val employee = Employee("Bupe Mwansa")
    println(employee.getEmployeeName())
    val employee2 = Employee("jackyy", "Conrad", 10)
    println(employee2.getEmployeeName())
    val employee3 = Employee("franklin richards", 5)
    println(employee3.getEmployeeName())

}

// An example of a class holding information about a person
class Person {
    var firstName : String = ""
    var lastName : String = ""
    var age : Int = 0

    fun getFullName() = "$firstName $lastName"
    fun getPersonAge() : Int = age
}

// A person class with a constructor
class Persona(firstName : String, lastName : String, age : Int) {
    val fullName = "$firstName $lastName"
    // An initializer, similar to Python
    init {
        if (firstName.isEmpty() or lastName.isEmpty())
            throw IllegalArgumentException("Args cannot be empty")
    }

    fun getPersonaFullName() : String {
        return fullName
    }
}

// A class with multiple constructors
class Employee {
    val firstName : String
    val lastName : String
    val employeeId : Int
    constructor(firstName: String, lastName: String, employeeId : Int) {
        this.firstName = firstName
        this.lastName = lastName
        this.employeeId = employeeId
    }

    constructor(fullName : String, employeeId : Int) {
        val names = fullName.split(" ")
        if (names.size != 2)
            throw InvalidParameterException("Two names allowed only")
        firstName = names[0]
        lastName = names[1]
        this.employeeId = employeeId
    }

    constructor(fullName: String) : this(fullName, 100)

    fun getEmployeeName() : String = "$firstName $lastName"
}
