package workshop

data class Expense(
    val id: Int,
    val description: String,
    val amount: Int,
    val date: String
)

class ExpenseService {

    private val database = HashMap<Int, Expense>()
    private var nextId = 1

    // TODO 1: fun add(description: String, amount: Int): Expense
    //   Create Expense with nextId, "2024-01-15" as date
    //   Store in database, increment nextId, return the expense

    // TODO 2: fun getAll(): List<Expense>
    //   Return database.values.toList()

    // TODO 3: fun findById(id: Int): Expense?
    //   Return database[id]

    // TODO 4: fun delete(id: Int): Boolean
    //   Return database.remove(id) != null

    // TODO 5: fun total(): Int
    //   Return database.values.sumOf { it.amount }

    // BONUS: fun getAbove(threshold: Int): List<Expense>
    //   Return database.values.filter { it.amount > threshold }
}

fun main() {
    val service = ExpenseService()

    // TODO 6: Add 4 expenses using service.add(...)
    //   "Lunch" 150, "Coffee" 50, "Taxi" 480, "Metro" 32

    // TODO 7: Print count and total

    // TODO 8: Print all expenses
    println("\n=== All expenses ===")

    // TODO 9: Find by ID 2 and ID 99

    // TODO 10: Delete ID 1 (should be true), delete ID 99 (should be false)
    //   Print count after delete

    // BONUS: Print expenses above 100 CZK
}
