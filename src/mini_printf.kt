import com.sun.jdi.IntegerType

// A mini version of C's printf function in Kotlin

fun main() {
    val string = "Eli"
    val char = 'A'
    val number = 1234

    val len = printf("Hello world %c %s %d", char, string, number)
    println(len)
}

/**
 * The Kotlin implementation of the printf function of the STL in C
 * used for formatted output to STDOUT
 *
 * @param format - A string literal containing the text to be printed and optionally,
 * format specifiers (%d for integers, %s for strings, %f for floating-point numbers)
 * Supported format specifiers: %s, %d, %c
 *
 * @param args - A variable number of arguments, corresponding to the format specifiers
 * in the format string
 *
 * @return Returns the number of characters printed successfully, or a negative value
 * on error
 */
fun printf(format : String?, vararg args : Any) : Int {
    if (format.isNullOrBlank()) {
        println()
        return 0
    }

    val args = args.toList()
    var count = 0
    val specifierOrder : MutableList<Pair<String, Int>> = mutableListOf()
    var specifierIndexOrder = 0
    var tempMessage = ""
    var specifier : String
    for (i in format.indices) {
        if ((format[i] == '%') and (i+1 < format.length)) {
            if (format[i+1].isLetter() and isSpecifier(format[i+1]) ) {
                specifier = format[i] + format[i + 1].toString()
                specifierOrder.add(Pair(specifier, specifierIndexOrder))
                specifierIndexOrder += 1
            }
        }
        tempMessage += format[i]
        count += 1
    }

    var finalMessage = ""
    var index = 0
    for ((k,v) in specifierOrder) {
        if (k in tempMessage) {
            if ((index == v) and checkSpecifierToType(k, args[index])) {
                finalMessage = tempMessage.replace(k, args[index].toString())
                println("true")
            }
            index += 1
        }
    }

    println(tempMessage)
    println(finalMessage)
    println(specifierOrder)
    println(args)
    return count
}

// printf helper function
fun isSpecifier(c : Char) : Boolean {
    return (c == 's') or (c == 'd') or (c == 'c')
}

// checks if specifier corresponds to the given type
fun checkSpecifierToType(specifier : String, type : Any) : Boolean {
    if ((specifier == "%s") and (type is String)) return true
    else if ((specifier == "%c") and (type is Char)) return true
    else if ((specifier == "%d") and (type is Integer)) return true
    return false
}

