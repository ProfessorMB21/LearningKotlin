fun main() {
    println("Hello, Kotlinverse!")

    println("Enter your first name")
    val firstName = readLine()!!

    println("Enter your last name")
    val lastName = readLine()!!

    val fullName = firstName + lastName

    println("Hello, $firstName $lastName, pleased to meet you.")
    println("Details: \n" +
            "Length: ${fullName.length}\n" +
            "Substring: ${fullName.substring(4)}\n" +
            "Substring 2: ${fullName.substring(6, 9)}")

}
