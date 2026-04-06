package workshop

// TODO 1: Define data class Expense
//   id: Int, description: String, amount: Int, date: String

// TODO 2: Define class ExpenseService with:
//   private val database = HashMap<Int, Expense>()
//   private var nextId = 1
//
//   fun add(description: String, amount: Int): Expense
//   fun getAll(): List<Expense>
//   fun findById(id: Int): Expense?
//   fun delete(id: Int): Boolean
//   fun total(): Int
//   fun getAbove(threshold: Int): List<Expense>
//   fun categorize(id: Int): String   ← NEW!
//     Use when:
//       amount < 50   -> "small"
//       amount < 500  -> "medium"
//       else          -> "large"
//     If not found    -> "not found"

fun main() {
    // TODO 3: Create ExpenseService and add expenses:
    //   "Lunch" 150, "Coffee" 50, "Metro" 32, "Taxi" 480, "Notebook" 25000

    // TODO 4: Print expense report:
    //   === Expense Report ===
    //   [1] Lunch: 150 CZK — medium
    //   ...

    // TODO 5: Print total, count, how many above 100 CZK

    // TODO 6: Delete Coffee (ID 2), print updated total and count
}
