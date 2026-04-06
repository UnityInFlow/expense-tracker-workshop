package workshop

// TODO 1: Define function formatExpense(description: String, amount: Int): String
//   Returns: "$description: $amount CZK"

// TODO 2: Define function withTax(amount: Int): Int
//   Returns: (amount * 1.21).toInt()
//   Use shorthand syntax: fun withTax(amount: Int): Int = ...

// TODO 3: Define function printExpense(description: String, amount: Int)
//   Prints: ">>> $description: $amount CZK"
//   No return value

// BONUS: Define function isExpensive(amount: Int): Boolean
//   Returns true if amount > 100

fun main() {
    // TODO 4: Call formatExpense("Lunch", 150) and print the result

    // TODO 5: Call withTax(100) and print, then withTax(200) and print

    // TODO 6: Call printExpense("Coffee", 50)

    // BONUS: Print isExpensive(150) and isExpensive(50)

    // BONUS: Print formatExpense with withTax inside:
    //   formatExpense("Lunch", withTax(150))
}
