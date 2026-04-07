package workshop

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
