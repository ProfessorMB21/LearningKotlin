import kotlin.random.Random

// Loops in Kotlin
// For-loops in Kotlin resemble foreach loops in Java and C#
// Do-While and While loops in Kotlin have the same syntax as those in Java and C#

fun main() {

    println("Loops in Kotlin")
    //println("Enter a range of numbers to find its sum (e.g. 1..10)")

    /*
    val s = readln()
    val integerRange = makeRangeFromString(s)

    val result = getRangeSum(checkNotNull(integerRange))
    println("The sum of the range $integerRange is $result")
    */

    /*
    println("Bank Account Simulation using do-while loops")
    val initialBalance = 10000
    simulateBankAccount(initialBalance)
     */

    println("Guessing game simulation using while loops")
    val magicNumber = Random.nextInt(100)
    guessTheMagicNumberSim(magicNumber)

}

// A guessing game to illustrate while loops
fun guessTheMagicNumberSim(magicNumber : Int) {
    var guess = 0
    var attempts = 0
    while (guess != magicNumber) {
        println("Guess the magic number")
        guess = readln().toInt()
        if (guess > magicNumber)
            println("Oopsy, too big:))")
        else if (guess < magicNumber)
            println("Haha, too small:)))")
        attempts += 1
    }
    when (attempts) {
        in 1..2 -> println("You're godlike")    // Todo: add what you like
        in 3..5 -> println("You're very smart")
        in 6..10 -> println("You're pretty smart")
        in 11..15 -> println("Average Joe, huh!!")
        else -> println("You need more than just luck, you're pathetic!")
    }
}

// A simple example illustrating do-while loops
fun simulateBankAccount(balance : Int) {
    if (isNegative(balance)) {
        println("Balance must be positive")
        return
    }
    // simulation
    var accountBalance = balance
    var withdraw = 0
    var deposit = 0
    var operation = 0

    do {
        println("Please select an operation: " +
                "\n1. Deposit" +
                "\n2. Withdraw" +
                "\n3. Quit" +
                "\nBalance: $$accountBalance" +
                "\n:::")

        operation = readln().toInt()
        if (operation == 1){                                    /// deposit
            println("Please enter an amount to deposit")
            deposit = readln().toInt()
            if (deposit > 100000) {
                println("Can't deposit more than $100000 in a single operation")
                continue
            } else
                accountBalance += deposit
        } else if (operation == 2) {                         /// withdraw
            println("Please enter an amount to withdraw")
            withdraw = readln().toInt()
            if (isNegative(withdraw)) {
                println("Can't withdraw a negative amount")
                continue
            } else if (withdraw > accountBalance) {
                println("Insufficient credit to withdraw $$withdraw")
                continue
            } else
                accountBalance -= withdraw
        }

    } while ((!isNegative(accountBalance)) and (operation != 3))

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
    var sum = 0
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
