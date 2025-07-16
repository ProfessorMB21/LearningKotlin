// Kotlin's `when` keyword is used in a similar case as C/C++ switch case

fun main() {

    println("Enter a digit to get its hexadecimal equivalent")
    val n = readln().toInt()

    val hex = getHexDigit(n)
    println("The hex equiv. of $n is $hex")
    println(getHexDigit(n, ))
    println(getHexDigit(n, 10, ))

}

// with if-statements
fun getHexDigit(n : Int) : Char {
    if (n in 0..9) return '0' + n
    else if (n in 10..15) return 'A' + n - 10
    else return '?'
}

// using when-statement
fun getHexDigit(n : Int, param : Any ="") : Char {
    when {
        n in 0..9 -> return '0' + n
        n in 10..15 -> return 'A' + n - 10
        else -> return '?'
    }
}

// modified when-statement
fun getHexDigit(n : Int, param1 : Any = "param1", param2 : Any = "param2") = when {
    n in 0..9 -> '0' + n
    n in 10..15 -> 'A' + n - 10
    else -> '?'
}
