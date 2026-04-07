# Kotlin Cheatsheet
## Session 1 — Expense Tracker Workshop

> Rychlý přehled všech konstruktů ze Session 1.  
> Měj tento soubor otevřený vedle editoru během cvičení.

---

## Typy — přehled všech základních typů

```kotlin
// Číselné typy (celá čísla)
val b: Byte    = 127              // 8-bit   (-128 .. 127)
val s: Short   = 32000            // 16-bit  (-32768 .. 32767)
val i: Int     = 2_000_000        // 32-bit  (±2.1 miliardy) — DEFAULT
val l: Long    = 9_999_999_999L   // 64-bit  (±9.2 quintillion)

// Desetinné typy
val f: Float   = 3.14f            // 32-bit  (~7 platných číslic)
val d: Double  = 3.14159265       // 64-bit  (~16 platných číslic) — DEFAULT

// Ostatní typy
val flag: Boolean = true           // pravda / nepravda
val ch: Char      = 'A'           // jeden Unicode znak
val text: String  = "Hello"       // řetězec (text)

// Type inference — Kotlin odhaduje typy automaticky
val x = 42         // Int
val y = 3.14       // Double
val z = "Kotlin"   // String
val ok = true      // Boolean
```

### Konverze mezi typy

```kotlin
val i = 42
val d = i.toDouble()       // 42.0
val s = i.toString()       // "42"
val l = i.toLong()         // 42L
val back = "42".toInt()    // 42
val safe = "abc".toIntOrNull()  // null (bezpečné parsování)

// POZOR: Kotlin NEKONVERTUJE automaticky!
// val d: Double = 42     // ❌ CHYBA
// val d: Double = 42.0   // ✅ OK
// val d: Double = 42.toDouble()  // ✅ OK
```

### Speciální zápisy

```kotlin
val million = 1_000_000        // podtržítka pro čitelnost
val hex = 0xFF                 // hexadecimální
val bin = 0b1010               // binární
val longNum = 100L             // explicitně Long
val floatNum = 3.14f           // explicitně Float
```

📖 https://kotlinlang.org/docs/basic-types.html
📖 https://kotlinlang.org/docs/numbers.html

---

## val / var — proměnné

```kotlin
val description = "Lunch"    // neměnné — nelze změnit po přiřazení
var total = 0                 // měnné
total = total + 150
total += 50                   // zkratka

// Explicitní typy (většinou není nutné — Kotlin odhadne sám)
val name:   String  = "Lunch"
val price:  Int     = 150
val ratio:  Double  = 0.21
val paid:   Boolean = true
```

📖 https://kotlinlang.org/docs/basic-syntax.html#variables

---

## String templates — vkládání proměnných do textu

```kotlin
val description = "Lunch"
val amount = 150

println("$description: $amount CZK")          // Lunch: 150 CZK
println("With VAT: ${amount * 1.21} CZK")     // výraz v ${}
```

📖 https://kotlinlang.org/docs/strings.html#string-templates

---

## fun — funkce

```kotlin
// Plný zápis
fun formatExpense(description: String, amount: Int): String {
    return "$description: $amount CZK"
}

// Zkrácený zápis — pro jednoduché funkce
fun withTax(amount: Int): Int = (amount * 1.21).toInt()

// Bez návratové hodnoty
fun printExpense(description: String) {
    println(description)
}

// Volání
println(formatExpense("Lunch", 150))   // Lunch: 150 CZK
println(withTax(100))                  // 121
```

📖 https://kotlinlang.org/docs/functions.html

---

## if / else

```kotlin
val amount = 150

// Klasické — jako statement
if (amount > 100) {
    println("Expensive")
} else {
    println("Cheap")
}

// Jako výraz — vrátí hodnotu
val label = if (amount > 100) "expensive" else "cheap"
```

📖 https://kotlinlang.org/docs/control-flow.html

---

## when

```kotlin
// when s podmínkami (bez hodnoty v závorce)
val category = when {
    amount < 50   -> "small"
    amount < 500  -> "medium"
    amount < 5000 -> "large"
    else          -> "luxury"
}

// when s konkrétní hodnotou
val result = when (day) {
    "Saturday", "Sunday" -> "weekend"
    else                 -> "workday"
}
```

📖 https://kotlinlang.org/docs/control-flow.html#when-expression

---

## data class — datový model

```kotlin
// Definice — šablona
data class Expense(
    val id: Int,
    val description: String,
    val amount: Int,
    val date: String
)

// Instance — konkrétní výdaj
val lunch = Expense(id = 1, description = "Lunch", amount = 150, date = "2024-01-15")

// Přístup k hodnotám
println(lunch.description)   // Lunch
println(lunch.amount)        // 150
println(lunch)               // Expense(id=1, description=Lunch, amount=150, date=2024-01-15)

```

📖 https://kotlinlang.org/docs/data-classes.html

---

## List — seřazená kolekce

```kotlin
val expenses = listOf(
    Expense(1, "Lunch",  150, "2024-01-15"),
    Expense(2, "Coffee",  50, "2024-01-15"),
    Expense(3, "Metro",   32, "2024-01-15")
)

// Iterace
for (expense in expenses) {
    println("${expense.description}: ${expense.amount} CZK")
}

// Funkcionální styl
expenses.forEach { println("${it.description}: ${it.amount} CZK") }

// Operace
val total  = expenses.sumOf { it.amount }          // 232
val big    = expenses.filter { it.amount > 100 }   // [Lunch]
val sorted = expenses.sortedBy { it.amount }       // Metro, Coffee, Lunch
val names  = expenses.map { it.description }       // [Lunch, Coffee, Metro]
val max    = expenses.maxByOrNull { it.amount }    // Lunch
```

📖 https://kotlinlang.org/docs/collections-overview.html

---

## HashMap — klíč → hodnota

```kotlin
val database = HashMap<Int, Expense>()

// Přidání
database[1] = Expense(1, "Lunch", 150, "2024-01-15")
database[2] = Expense(2, "Coffee", 50, "2024-01-15")

// Čtení — POZOR: může vrátit null!
val found   = database[2]    // Expense? — může být null
val missing = database[99]   // null

// Iterace
for ((id, expense) in database) {
    println("ID $id: ${expense.description}")
}

// Smazání
database.remove(1)

// Velikost / existence
println(database.size)             // 1
println(database.containsKey(2))   // true
println(database.values.toList())  // všechny hodnoty jako List
```

📖 https://kotlinlang.org/docs/map-operations.html

---

## Null safety — `?.` a `?:`

```kotlin
val found: Expense? = database[99]   // může být null

// ?. = safe call — přistup jen když není null
println(found?.description)           // null nebo "Lunch" — bez pádu

// ?: = elvis — pokud null, použij tuto hodnotu
val name = found?.description ?: "Not found"

// Explicitní kontrola
if (found != null) {
    println(found.description)        // Kotlin ví, že není null
}
```

📖 https://kotlinlang.org/docs/null-safety.html

---

## class — třída s logikou

```kotlin
class ExpenseService {

    private val database = HashMap<Int, Expense>()   // skryto zvenku
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
}

// Použití
val service = ExpenseService()
service.add("Lunch", 150)
println(service.total())           // 150
println(service.getAll().size)     // 1
service.delete(1)
```

📖 https://kotlinlang.org/docs/classes.html  
📖 https://kotlinlang.org/docs/visibility-modifiers.html

---

## Rychlý přehled — co kdy použít

| Potřebuji | Použiji |
|---|---|
| Uložit hodnotu která se nemění | `val` |
| Uložit hodnotu která se mění | `var` |
| Vložit proměnnou do textu | `$variable` nebo `${expression}` |
| Pojmenovat opakovanou akci | `fun` |
| Rozhodovat podle podmínky | `if/else` nebo `when` |
| Popsat strukturu dat | `data class` |
| Uložit seřazené objekty | `listOf()` / `mutableListOf()` |
| Hledat rychle podle ID | `HashMap<Int, Expense>()` |
| Přistoupit k hodnotě která může být null | `?.` |
| Nahradit null výchozí hodnotou | `?:` |
| Zabalit logiku do jedné třídy | `class` |
| Skrýt implementační detail | `private` |

---

## Zdroje pro hlubší studium

| Téma | URL |
|---|---|
| Kotlin tour (interaktivní, začátečníci) | https://kotlinlang.org/docs/kotlin-tour-hello-world.html |
| Kotlin Koans (cvičení online) | https://play.kotlinlang.org/koans |
| Basic syntax | https://kotlinlang.org/docs/basic-syntax.html |
| Functions | https://kotlinlang.org/docs/functions.html |
| Data classes | https://kotlinlang.org/docs/data-classes.html |
| Collections | https://kotlinlang.org/docs/collections-overview.html |
| Null safety | https://kotlinlang.org/docs/null-safety.html |
| Classes | https://kotlinlang.org/docs/classes.html |
| Baeldung — Kotlin articles | https://www.baeldung.com/kotlin |
