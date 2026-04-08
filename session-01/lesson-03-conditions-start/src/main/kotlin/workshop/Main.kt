package workshop

// TODO 1: Define function label(amount: Int): String
//   if amount > 100 return "expensive" else return "cheap"

// TODO 2: Define function categorize(amount: Int): String
//   Use when:
//     < 50   -> "small"
//     < 500  -> "medium"
//     < 5000 -> "large"
//     else   -> "luxury"

// TODO 3: Define function isAffordable(amount: Int, budget: Int): Boolean
//   Use if as expression: return if (amount <= budget) true else false

// BONUS: Define function dayType(day: String): String
//   Use when(day):
//     "Saturday", "Sunday" -> "weekend"
//     "Monday","Tuesday","Wednesday","Thursday","Friday" -> "workday"
//     else -> "unknown"

fun label(amout: Int): String{
    if(amout == 0){
        return ""
    }else if(amout == 100){
        return "expensive"
    }else if(amout == 200){
        return "much expensive"
    }else{
        return "expensive"
    }
}

data class User(
    val id: Int,
    val name: String,
    val age: Int,
    val username: String,
    val lastName: String,
)

fun onliner(lastName: String, users: List<User>): List<Int> =
    users.filter { it.lastName == lastName }
        .filter { user -> user.age > 35 }
        .map { user -> user.id }




fun main() {
    // TODO 4: Test your functions
    // println(label(150))
    // println(label(30))
    // println(categorize(25))
    // println(categorize(150))
    // println(categorize(1500))
    // println(categorize(10000))
    // println(isAffordable(100, 200))
    // println(isAffordable(300, 200))
    // BONUS: println(dayType("Monday"))
    // BONUS: println(dayType("Saturday"))
    // BONUS: println(dayType("Holiday"))
}
