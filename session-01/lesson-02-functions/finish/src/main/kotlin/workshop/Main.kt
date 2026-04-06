package workshop

fun formatExpense(description: String, amount: Int): String {
    return "$description: $amount CZK"
}

fun withTax(amount: Int): Int = (amount * 1.21).toInt()

fun printExpense(description: String, amount: Int) {
    println(">>> $description: $amount CZK")
}

fun isExpensive(amount: Int): Boolean = amount > 100

fun main() {
    println(formatExpense("Lunch", 150))

    println(withTax(100))
    println(withTax(200))

    printExpense("Coffee", 50)

    // BONUS
    println(isExpensive(150))
    println(isExpensive(50))

    println(formatExpense("Lunch", withTax(150)))
}
