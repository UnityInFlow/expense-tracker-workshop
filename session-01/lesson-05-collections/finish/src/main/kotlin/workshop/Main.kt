package workshop

fun main() {
    val expenses = listOf(
        Expense(1, "Lunch", 150, "2024-01-15"),
        Expense(2, "Coffee", 50, "2024-01-15"),
        Expense(3, "Metro", 32, "2024-01-16"),
        Expense(4, "Taxi", 480, "2024-01-16"),
        Expense(5, "Groceries", 890, "2024-01-17")
    )

    println("=== All expenses ===")
    for (expense in expenses) {
        println("ID ${expense.id}: ${expense.description} — ${expense.amount} CZK")
    }

    val total = expenses.sumOf { it.amount }
    println("Total: $total CZK")

    println("\n=== Above 100 CZK ===")
    expenses.filter { it.amount > 100 }.forEach {
        println("${it.description}: ${it.amount} CZK")
    }

    println("\n=== Sorted most to least expensive ===")
    expenses.sortedByDescending { it.amount }.forEach {
        println("${it.description}: ${it.amount} CZK")
    }

    // BONUS
    val descriptions = expenses.map { it.description }
    println("\nDescriptions: $descriptions")

    val mostExpensive = expenses.maxByOrNull { it.amount }
    println("Most expensive: ${mostExpensive?.description} (${mostExpensive?.amount} CZK)")
}
