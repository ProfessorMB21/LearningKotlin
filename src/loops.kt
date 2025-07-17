// Loops in Kotlin
// For-loops in Kotlin resemble foreach loops in Java and C#

fun main() {

    println("Loops in Kotlin")
    println("Enter a range of numbers to find its sum (e.g. 1..10)")

    val s = readln()
    val integerRange = makeRangeFromString(s)

    val result = getRangeSum(checkNotNull(integerRange))
    println("The sum of the range $integerRange is $result")

}

fun isNegative(n : Int) : Boolean  = n < 0

fun makeRangeFromString(s : String?) : IntRange? {
    if (!s.isNullOrBlank()) {
        // getting the range values
        val fromValue : Int = s.substringBefore(delimiter = '.').toInt()
        val toValue : Int = s.substringAfterLast('.').toInt()

        return IntRange(fromValue, toValue)
    }
    return null
}

fun makeRangeFromString(s : String) : IntProgression {
    val fromValue : Int = s.substringBefore(delimiter = '.').toInt()
    val toValue : Int = s.substringAfterLast('.').toInt()
    return fromValue.downTo(toValue)
}

// we'll use the for-loop to find the sum of the given range
fun getRangeSum(range : IntRange) : Int {
    var sum : Int = 0
    for (i in range)
        sum += i
    return sum
}

fun getRangeSum(prog : IntProgression) : Int {
    var sum = 0
    for (i in prog)
        sum += i
    return sum
}
