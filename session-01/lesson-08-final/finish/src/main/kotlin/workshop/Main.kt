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

    fun add(description: String, amount: Int): Expense {
        val expense = Expense(nextId, description, amount, "2024-01-15")
        database[nextId] = expense
        nextId++
        return expense
    }

    fun getAll(): List<Expense> = database.values.toList()

    fun findById(id: Int): Expense? = database[id]

    fun delete(id: Int): Boolean = database.remove(id) != null

    fun total(): Int = database.values.sumOf { it.amount }

    fun getAbove(threshold: Int): List<Expense> =
        database.values.filter { it.amount > threshold }

    fun categorize(id: Int): String {
        val expense = database[id] ?: return "not found"
        return when {
            expense.amount < 50   -> "small"
            expense.amount < 500  -> "medium"
            else                  -> "large"
        }
    }
}

fun main() {
    val service = ExpenseService()

    service.add("Lunch", 150)
    service.add("Coffee", 50)
    service.add("Metro", 32)
    service.add("Taxi", 480)
    service.add("Notebook", 25000)

    println("=== Expense Report ===")
    service.getAll().forEach {
        println("[${it.id}] ${it.description}: ${it.amount} CZK — ${service.categorize(it.id)}")
    }

    println("\nTotal: ${service.total()} CZK")
    println("Count: ${service.getAll().size}")
    println("Above 100 CZK: ${service.getAbove(100).size} expenses")

    println("\nAfter deleting [2]:")
    service.delete(2)
    println("Total: ${service.total()} CZK")
    println("Count: ${service.getAll().size}")
}
