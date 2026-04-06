package workshop

fun main() {
    // === Lesson 01: Variables & Types ===

    val description = "Lunch"
    val amount = 150
    val paid = false

    println(description)
    println(amount)
    println(paid)

    println("Expense: $description costs $amount CZK, paid: $paid")

    var total = 0
    total += amount
    println("Total: $total CZK")

    // BONUS
    val withVat = (amount * 1.21).toInt()
    println("With VAT: $withVat CZK")
}
