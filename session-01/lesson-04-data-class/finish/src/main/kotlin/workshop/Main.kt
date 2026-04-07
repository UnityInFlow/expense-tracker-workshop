package workshop

fun main() {
    val lunch = Expense(id = 1, description = "Lunch", amount = 150, date = "2024-01-15")
    val coffee = Expense(id = 2, description = "Coffee", amount = 50, date = "2024-01-15")
    val metro = Expense(id = 3, description = "Metro", amount = 32, date = "2024-01-15")

    println("Expense #${lunch.id}: ${lunch.description} — ${lunch.amount} CZK")
    println("Expense #${coffee.id}: ${coffee.description} — ${coffee.amount} CZK")
    println("Expense #${metro.id}: ${metro.description} — ${metro.amount} CZK")

    println("Most expensive: ${lunch.description} (${lunch.amount} CZK)")

    // BONUS
    val updated = lunch.copy(amount = 200)
    println("Updated: ${updated.amount} CZK")
    println("Original: ${lunch.amount} CZK")
}
