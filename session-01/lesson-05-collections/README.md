# Lesson 05 — Collections
## Kolekce: List, for, forEach, filter, sumOf

---

## Cíl / Goal

Uložit více výdajů najednou a efektivně s nimi pracovat.  
Store multiple expenses at once and work with them efficiently.

Na konci lekce budeš umět iterovat, filtrovat a počítat součty přes seznam výdajů.

---

## Co je nové / What is new

| Konstrukt | Co dělá |
|---|---|
| `listOf(...)` | Neměnný seznam |
| `mutableListOf(...)` | Měnný seznam — lze přidávat |
| `for (item in list)` | Klasická smyčka přes kolekci |
| `list.forEach { it.xxx }` | Funkcionální iterace |
| `list.filter { podmínka }` | Vrátí prvky splňující podmínku |
| `list.sumOf { it.field }` | Součet hodnot |
| `list.sortedBy { it.field }` | Seřazená kopie |
| `list.map { transformace }` | Transformace každého prvku |
| `list.maxByOrNull { it.field }` | Prvek s nejvyšší hodnotou |
| `it` | Zkratka pro aktuální prvek v lambda výrazu |

---

## Kontext / Context

> V lekci 04 jsme vytvořili 3 separátní instance Expense.  
> Jsou od sebe oddělené — nelze je najednou iterovat, filtrovat nebo sečíst.  
> List je kontejner pro více objektů na jednom místě.

---

## Zadání / Exercises

Otevři `start/Main.kt` — k dispozici máš předpřipravený seznam 5 výdajů.

1. Vytiskni všechny výdaje pomocí `for` smyčky  
   Formát: `"ID <id>: <description> — <amount> CZK"`

2. Totéž pomocí `forEach`  
   Hint: `expenses.forEach { expense -> println(...) }`

3. Vypočítej a vytiskni celkovou sumu  
   Hint: `expenses.sumOf { it.amount }`

4. Vytiskni jen výdaje nad 100 CZK  
   Hint: `expenses.filter { it.amount > 100 }`

5. Vytiskni výdaje seřazené od nejdražšího  
   Hint: `expenses.sortedByDescending { it.amount }`

6. **Bonus:** Vytiskni jen popisy jako seznam  
   Hint: `expenses.map { it.description }`

7. **Bonus:** Najdi a vytiskni nejdražší výdaj  
   Hint: `expenses.maxByOrNull { it.amount }`

---

## Spuštění / Running

Očekávaný výstup:
```
=== All expenses ===
ID 1: Lunch — 150 CZK
ID 2: Coffee — 50 CZK
...

Total: 1602 CZK

=== Above 100 CZK ===
Lunch: 150 CZK
Taxi: 480 CZK
Groceries: 890 CZK

=== Sorted most to least expensive ===
Groceries: 890 CZK
Taxi: 480 CZK
...
```

---

## Syntaxe / Syntax reference

```kotlin
val expenses = listOf(
    Expense(1, "Lunch", 150, "2024-01-15"),
    Expense(2, "Coffee", 50, "2024-01-15")
)

for (expense in expenses) { ... }             // klasická smyčka
expenses.forEach { expense -> ... }           // funkcionální
expenses.forEach { println(it.description) } // zkrácené 'it'

expenses.sumOf { it.amount }                 // 200
expenses.filter { it.amount > 100 }          // [Lunch]
expenses.sortedBy { it.amount }              // Coffee, Lunch
expenses.sortedByDescending { it.amount }    // Lunch, Coffee
expenses.map { it.description }              // [Lunch, Coffee]
expenses.maxByOrNull { it.amount }           // Expense(Lunch)
```

---

## Klíčové poznatky / Key takeaways

- `listOf()` je neměnný — nelze přidávat; `mutableListOf()` je měnný
- `forEach` a `for` dají stejný výsledek — `forEach` je idiomatičtější Kotlin
- `it` je implicitní název pro aktuální prvek v lambda — lze pojmenovat explicitně
- Operace jako `filter`, `sumOf`, `map` jsou built-in — nepište smyčky ručně

---

## Dokumentace / Docs

- Collections overview: https://kotlinlang.org/docs/collections-overview.html
- Collection filtering: https://kotlinlang.org/docs/collection-filtering.html
- Collection transformations: https://kotlinlang.org/docs/collection-transformations.html

---

## Další lekce / Next lesson

→ [Lesson 06 — HashMap](../lesson-06-hashmap/)
