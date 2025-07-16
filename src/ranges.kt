// Ranges, progressions and in operation

fun main() {
    // creating a range of characters from a to x
    val chars = 'a'..'x'
    println('z' in chars)
    println('k' !in chars)
    println('f' in chars)

    println("Create your range")
    val a = readln().toInt()
    val b = readln().toInt()
    val myRange = a..b

    println("Enter some number")
    val num = readln().toInt()

    println("$num is ${if (isInRange(a, b, num)) "in range" else "not in range"}")
    println("$num is ${if (isInRange(myRange, num)) "in range $myRange" else "not in range $myRange"}")

}

fun isInRange(from: Int, to : Int, num: Int) : Boolean {
    return num in from..to
}

// function overloading
fun isInRange(range: IntRange, num : Int) : Boolean {
    return num in range
}
