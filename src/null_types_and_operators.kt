// Nullable types and operators in Kotlin
// There are 3 types of operators in Kotlin used to work with Nullable types:
//      -> Not-Null assertion operator (!!)
//      -> Safe call operator
//      -> Elvis operator (Null coalescing operator)
// I like to think of the Elvis operator as the ternary operator in C++ and C#

fun main() {
    // Not-Null assertion operator
    val n = readLine()!!.toInt()

    // Safe call operator
    var num1 : Int?      // Nullable type
    fun readInt() = readLine()?.toInt()
    num1 = readInt()

    // Elvis operator
    fun sayHello(name : String?) {
        println("Hello, ${name ?: "No one"}")
    }
    sayHello("Jack")
    sayHello(null)
}
