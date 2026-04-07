package workshop

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
