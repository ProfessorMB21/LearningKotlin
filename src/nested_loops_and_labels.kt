import kotlin.random.Random
import kotlin.random.nextInt

// Nested loops and labels in Kotlin
// Labels in Kotlin can be used in nested loops to affect the control-flow of
// the outer loop(s)

fun main() {
    println("Nested loops and labels")

    val string = "Telekinesis"
    val substring = "Tele"
    if (findSubstringOf(substring, string)) println("Substring found")
    else println("Substring not found")

    guessTheMagicNumberSim2(Random.nextInt(100))

}

// finding the substring of a string using nested loops and labels
fun findSubstringOf(substring : String, string : String) : Boolean {
    outerloop@ for (i in string.indices) {
        for (j in substring.indices) {
            if (substring[j] != string[i + j]) {
                continue@outerloop      // terminates the iteration of the outer loop
            }
        }
        return true
    }
    return false
}

// Guess the magic number game using loops and labels
fun guessTheMagicNumberSim2(magicNumber : Int) {
    loop@ while (true) {
        println("Guess the magic number")
        val guess = readln().toInt()
        val message = when {
            guess < magicNumber -> "Too small"
            guess > magicNumber -> "Too big"
            else -> break@loop
        }
        println(message)
    }
    println("Correct! The magic number is $magicNumber")
}
