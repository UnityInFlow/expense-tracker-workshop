package workshop

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
//   fun categorize(id: Int): String   <-- NEW!
//     Use when:
//       amount < 50   -> "small"
//       amount < 500  -> "medium"
//       else          -> "large"
//     If not found    -> "not found"
