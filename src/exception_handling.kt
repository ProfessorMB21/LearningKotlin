import java.security.InvalidParameterException

// Exception handling in Kotlin
// Exception handling in Kotlin is very similar to Java's approach

fun main() {
    println("What is your name: ")
    val name = readln()
    try {
        sayHelloTo(name)
    } catch (e : InvalidParameterException) {
        println("Error: ${e.message}")
    } finally {
        println("This block always runs")
    }

    val result = readInteger(10)
    println(result)
}

// Says hello to a person
fun sayHelloTo(name : String) {
    val message = when {
        name.isNotEmpty() -> "Hello, $name"
        else -> throw InvalidParameterException("Empty name")
    }
    println(message)
}

// Handling exceptions with the try-catch statements
fun readInteger(default : Int) : Int {
    try {
        return readln().toInt()
    } catch (e : NumberFormatException) {
        println(e.message)
    } catch (e : Exception) {
        println(e.message)
    }
    return default
}
