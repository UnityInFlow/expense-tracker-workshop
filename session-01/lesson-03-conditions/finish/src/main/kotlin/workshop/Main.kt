package workshop

fun label(amount: Int): String {
    return if (amount > 100) "expensive" else "cheap"
}

fun categorize(amount: Int): String = when {
    amount < 50   -> "small"
    amount < 500  -> "medium"
    amount < 5000 -> "large"
    else          -> "luxury"
}

fun isAffordable(amount: Int, budget: Int): Boolean = if (amount <= budget) true else false

fun dayType(day: String): String = when (day) {
    "Saturday", "Sunday" -> "weekend"
    "Monday", "Tuesday", "Wednesday", "Thursday", "Friday" -> "workday"
    else -> "unknown"
}

fun main() {
    println(label(150))
    println(label(30))
    println(categorize(25))
    println(categorize(150))
    println(categorize(1500))
    println(categorize(10000))
    println(isAffordable(100, 200))
    println(isAffordable(300, 200))
    println(dayType("Monday"))
    println(dayType("Saturday"))
    println(dayType("Holiday"))
}
