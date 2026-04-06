package workshop

data class Expense(
    val id: Int,
    val description: String,
    val amount: Int,
    val date: String
)

fun main() {
    val database = HashMap<Int, Expense>()

    database[1] = Expense(1, "Lunch", 150, "2024-01-15")
    database[2] = Expense(2, "Coffee", 50, "2024-01-15")
    database[3] = Expense(3, "Metro", 32, "2024-01-16")
    database[4] = Expense(4, "Taxi", 480, "2024-01-16")

    println("Count: ${database.size}")

    val found = database[2]
    println(found?.description)

    val missing = database[999]
    println(missing?.description ?: "Not found")

    println("\n=== All expenses ===")
    for ((id, expense) in database) {
        println("ID $id: ${expense.description} — ${expense.amount} CZK")
    }

    database.remove(1)
    println("After delete: ${database.size} expenses")

    // BONUS
    val total = database.values.sumOf { it.amount }
    println("Total: $total CZK")
}
