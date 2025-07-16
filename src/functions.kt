// Defining functions
import kotlin.math.PI

fun main() {
    println("What is PI??")

    weCallUponPi()

    println("And PI has brought forth the calculation of area")
    println("Enter the radius of a circle: ")
    val radius = readln().toDouble()

    calcAreaOfCircle(radius)
}

// no parameter function
fun weCallUponPi() {
    println("This is PI: $PI")
}

// single parameter function
fun calcAreaOfCircle(radius : Double) {
    if (test(radius))
        println("Area of circle with radius $radius is ${calcAreaOfCircleHelper(radius)}")
    else
        println("Helper functions implementations not equivalent")
}

// function returning a value
fun calcAreaOfCircleHelper(radius : Double) : Double {
    return radius * radius * PI
}

// Single line functions expressions
fun calcAreaOfCircleHelper2(radius: Double) : Double = PI * radius * radius

fun calcAreaOfCircleHelper3(radius: Double) = PI * radius * radius


fun test(radius : Double) : Boolean {

    val res1 = calcAreaOfCircleHelper(radius)
    val res2 = calcAreaOfCircleHelper2(radius)
    val res3 = calcAreaOfCircleHelper3(radius)

    return (res1 == res2) and (res1 == res3) and (res2 == res3)
}
