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

    // Different types
    val price: Double = 149.90
    val bigId: Long = 9999999999
    val initial: Char = 'L'
    println("Price: $price CZK")
    println("Big ID: $bigId")
    println("Initial: $initial")

    // BONUS — VAT calculation
    val withVat = (amount * 1.21).toInt()
    println("With VAT: $withVat CZK")

    // BONUS — Type conversion
    val text = amount.toString()
    val back = "200".toInt()
    println("text: $text, back: $back")
}
