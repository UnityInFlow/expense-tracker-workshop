package workshop

data class Expense(
    val id: Int,
    val description: String,
    val amount: Int,
    val date: String
)

fun main() {
    val database = HashMap<Int, Expense>()

    // TODO 1: Add 4 expenses to database
    //   database[1] = Expense(1, "Lunch", 150, "2024-01-15")
    //   database[2] = Expense(2, "Coffee", 50, "2024-01-15")
    //   database[3] = Expense(3, "Metro", 32, "2024-01-16")
    //   database[4] = Expense(4, "Taxi", 480, "2024-01-16")

    // TODO 2: Print count: "Count: <size>"

    // TODO 3: Load expense with ID 2, print its description using ?.
    //   val found = database[2]
    //   println(found?.description)

    // TODO 4: Load ID 999, print description or "Not found" using ?:
    //   val missing = database[999]
    //   println(missing?.description ?: "Not found")

    // TODO 5: Iterate and print all:
    //   for ((id, expense) in database) { ... }
    println("\n=== All expenses ===")

    // TODO 6: Delete expense with ID 1
    //   database.remove(1)
    //   Print: "After delete: <size> expenses"

    // BONUS: Calculate sum of remaining expenses
    //   database.values.sumOf { it.amount }
}
