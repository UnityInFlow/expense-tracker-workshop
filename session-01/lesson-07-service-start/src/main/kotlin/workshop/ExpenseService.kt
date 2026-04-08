package workshop

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
