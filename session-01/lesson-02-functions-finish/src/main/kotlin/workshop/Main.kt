package workshop

fun formatExpense(description: String, amount: Int): String {
    return "$description: $amount CZK"
}

fun withTax(amount: Int): Int = (amount * 1.21).toInt()

fun printExpense(description: String, amount: Int) {
    println(">>> $description: $amount CZK")
}

fun isExpensive(amount: Int): Boolean = amount > 100

fun f1(test1234: Int, y: Int, z: Double): Int {
    return test1234 + y
}

fun getUsername(): String = "JackHammer"
fun getFirstname(): String = "Jack"
fun getLastname(): String = "Hammer"

fun toPrint(username: String, firstname: String, lastname: String) {
    println("$username, $firstname, $lastname")
}

fun main() {
    println(formatExpense("Lunch", 150))

    println(withTax(amount = 100))
    println(withTax(200))

    printExpense("Coffee", 50)

    // BONUS
    println(isExpensive(150))
    println(isExpensive(50))

    println(formatExpense("Lunch", withTax(150)))

    f1(test1234 = 1, y = 2, z = 3.5)

    toPrint(username = getUsername(), firstname = getFirstname(), lastname = getLastname())
}
