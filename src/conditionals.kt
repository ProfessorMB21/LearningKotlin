import kotlin.math.PI

// Conditionals in Kotlin

fun main() {
    println("Please enter 3 numbers")
    val a = readln().toInt()
    val b = readln().toInt()
    val c = readLine()!!.toInt()

    val maxVal = getMax(a, b, c)
    println("The max of $a, $b, and $c is $maxVal")
}

// some function that does some stuff I just made up
fun getMax(a : Int, b : Int, c: Int = 10) : Int {
    fun reportInternalMax() : Boolean {
        if ((a > c) and (c > b)) {
            println("$a is greater than $b and $c")
            return true
        }
        else if ((a < c) and (c < b)) {
            println("$c is less than $a and $b")
            return false
        }
        else if ((a < c) and (b > c)) {
            println("$b is greater than $a and $c")
            return true
        }
        return false
    }

    if (!reportInternalMax()) {
        if (a < b)
            return b
        return a
    }
    return c
}
