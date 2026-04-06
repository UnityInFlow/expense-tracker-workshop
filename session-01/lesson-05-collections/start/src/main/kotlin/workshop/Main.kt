package workshop

data class Expense(
    val id: Int,
    val description: String,
    val amount: Int,
    val date: String
)

fun main() {
    val expenses = listOf(
        Expense(1, "Lunch", 150, "2024-01-15"),
        Expense(2, "Coffee", 50, "2024-01-15"),
        Expense(3, "Metro", 32, "2024-01-16"),
        Expense(4, "Taxi", 480, "2024-01-16"),
        Expense(5, "Groceries", 890, "2024-01-17")
    )

    // TODO 1: Print all expenses using for loop
    //   "ID <id>: <description> — <amount> CZK"
    println("=== All expenses ===")

    // TODO 2: Calculate and print total using sumOf
    //   "Total: <total> CZK"

    // TODO 3: Filter and print expenses above 100 CZK
    println("\n=== Above 100 CZK ===")

    // TODO 4: Print expenses sorted from most to least expensive
    //   Use sortedByDescending
    println("\n=== Sorted most to least expensive ===")

    // BONUS: Print only descriptions as a list using map
    // BONUS: Find and print most expensive using maxByOrNull
}
