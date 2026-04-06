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
}

fun main() {
    val service = ExpenseService()

    service.add("Lunch", 150)
    service.add("Coffee", 50)
    service.add("Taxi", 480)
    service.add("Metro", 32)

    println("Count: ${service.getAll().size}")
    println("Total: ${service.total()} CZK")

    println("\n=== All expenses ===")
    service.getAll().forEach {
        println("[${it.id}] ${it.description}: ${it.amount} CZK")
    }

    println("\nFind ID 2: ${service.findById(2)?.description ?: "not found"}")
    println("Find ID 99: ${service.findById(99)?.description ?: "not found"}")

    println("\nDeleted ID 1: ${service.delete(1)}")
    println("Deleted ID 99: ${service.delete(99)}")
    println("Count after delete: ${service.getAll().size}")

    // BONUS
    println("\n=== Above 100 CZK ===")
    service.getAbove(100).forEach {
        println("${it.description}: ${it.amount} CZK")
    }
}
