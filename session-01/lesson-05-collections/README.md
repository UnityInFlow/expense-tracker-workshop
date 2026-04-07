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

## Kotlin Playground

> Nemáš IntelliJ? Cvičení můžeš udělat přímo v prohlížeči:

| | Link |
|---|---|
| Cvičení (start) | [Otevřít v Playground](https://play.kotlinlang.org/#eyJ2ZXJzaW9uIjogIjIuMS4wIiwgInBsYXRmb3JtIjogImphdmEiLCAiYXJncyI6ICIiLCAibm9uZU1hcmtlcnMiOiB0cnVlLCAidGhlbWUiOiAiaWRlYSIsICJjb2RlIjogImRhdGEgY2xhc3MgRXhwZW5zZShcbiAgICB2YWwgaWQ6IEludCxcbiAgICB2YWwgZGVzY3JpcHRpb246IFN0cmluZyxcbiAgICB2YWwgYW1vdW50OiBJbnQsXG4gICAgdmFsIGRhdGU6IFN0cmluZ1xuKVxuXG5mdW4gbWFpbigpIHtcbiAgICB2YWwgZXhwZW5zZXMgPSBsaXN0T2YoXG4gICAgICAgIEV4cGVuc2UoMSwgXCJMdW5jaFwiLCAxNTAsIFwiMjAyNC0wMS0xNVwiKSxcbiAgICAgICAgRXhwZW5zZSgyLCBcIkNvZmZlZVwiLCA1MCwgXCIyMDI0LTAxLTE1XCIpLFxuICAgICAgICBFeHBlbnNlKDMsIFwiTWV0cm9cIiwgMzIsIFwiMjAyNC0wMS0xNlwiKSxcbiAgICAgICAgRXhwZW5zZSg0LCBcIlRheGlcIiwgNDgwLCBcIjIwMjQtMDEtMTZcIiksXG4gICAgICAgIEV4cGVuc2UoNSwgXCJHcm9jZXJpZXNcIiwgODkwLCBcIjIwMjQtMDEtMTdcIilcbiAgICApXG5cbiAgICAvLyBUT0RPIDE6IFByaW50IGFsbCBleHBlbnNlcyB1c2luZyBmb3IgbG9vcFxuICAgIC8vICAgXCJJRCA8aWQ+OiA8ZGVzY3JpcHRpb24+IFx1MjAxNCA8YW1vdW50PiBDWktcIlxuICAgIHByaW50bG4oXCI9PT0gQWxsIGV4cGVuc2VzID09PVwiKVxuXG4gICAgLy8gVE9ETyAyOiBDYWxjdWxhdGUgYW5kIHByaW50IHRvdGFsIHVzaW5nIHN1bU9mXG4gICAgLy8gICBcIlRvdGFsOiA8dG90YWw+IENaS1wiXG5cbiAgICAvLyBUT0RPIDM6IEZpbHRlciBhbmQgcHJpbnQgZXhwZW5zZXMgYWJvdmUgMTAwIENaS1xuICAgIHByaW50bG4oXCJcXG49PT0gQWJvdmUgMTAwIENaSyA9PT1cIilcblxuICAgIC8vIFRPRE8gNDogUHJpbnQgZXhwZW5zZXMgc29ydGVkIGZyb20gbW9zdCB0byBsZWFzdCBleHBlbnNpdmVcbiAgICAvLyAgIFVzZSBzb3J0ZWRCeURlc2NlbmRpbmdcbiAgICBwcmludGxuKFwiXFxuPT09IFNvcnRlZCBtb3N0IHRvIGxlYXN0IGV4cGVuc2l2ZSA9PT1cIilcblxuICAgIC8vIEJPTlVTOiBQcmludCBvbmx5IGRlc2NyaXB0aW9ucyBhcyBhIGxpc3QgdXNpbmcgbWFwXG4gICAgLy8gQk9OVVM6IEZpbmQgYW5kIHByaW50IG1vc3QgZXhwZW5zaXZlIHVzaW5nIG1heEJ5T3JOdWxsXG59In0=) |
| Řešení (finish) | [Otevřít v Playground](https://play.kotlinlang.org/#eyJ2ZXJzaW9uIjogIjIuMS4wIiwgInBsYXRmb3JtIjogImphdmEiLCAiYXJncyI6ICIiLCAibm9uZU1hcmtlcnMiOiB0cnVlLCAidGhlbWUiOiAiaWRlYSIsICJjb2RlIjogImRhdGEgY2xhc3MgRXhwZW5zZShcbiAgICB2YWwgaWQ6IEludCxcbiAgICB2YWwgZGVzY3JpcHRpb246IFN0cmluZyxcbiAgICB2YWwgYW1vdW50OiBJbnQsXG4gICAgdmFsIGRhdGU6IFN0cmluZ1xuKVxuXG5mdW4gbWFpbigpIHtcbiAgICB2YWwgZXhwZW5zZXMgPSBsaXN0T2YoXG4gICAgICAgIEV4cGVuc2UoMSwgXCJMdW5jaFwiLCAxNTAsIFwiMjAyNC0wMS0xNVwiKSxcbiAgICAgICAgRXhwZW5zZSgyLCBcIkNvZmZlZVwiLCA1MCwgXCIyMDI0LTAxLTE1XCIpLFxuICAgICAgICBFeHBlbnNlKDMsIFwiTWV0cm9cIiwgMzIsIFwiMjAyNC0wMS0xNlwiKSxcbiAgICAgICAgRXhwZW5zZSg0LCBcIlRheGlcIiwgNDgwLCBcIjIwMjQtMDEtMTZcIiksXG4gICAgICAgIEV4cGVuc2UoNSwgXCJHcm9jZXJpZXNcIiwgODkwLCBcIjIwMjQtMDEtMTdcIilcbiAgICApXG5cbiAgICBwcmludGxuKFwiPT09IEFsbCBleHBlbnNlcyA9PT1cIilcbiAgICBmb3IgKGV4cGVuc2UgaW4gZXhwZW5zZXMpIHtcbiAgICAgICAgcHJpbnRsbihcIklEICR7ZXhwZW5zZS5pZH06ICR7ZXhwZW5zZS5kZXNjcmlwdGlvbn0gXHUyMDE0ICR7ZXhwZW5zZS5hbW91bnR9IENaS1wiKVxuICAgIH1cblxuICAgIHZhbCB0b3RhbCA9IGV4cGVuc2VzLnN1bU9mIHsgaXQuYW1vdW50IH1cbiAgICBwcmludGxuKFwiVG90YWw6ICR0b3RhbCBDWktcIilcblxuICAgIHByaW50bG4oXCJcXG49PT0gQWJvdmUgMTAwIENaSyA9PT1cIilcbiAgICBleHBlbnNlcy5maWx0ZXIgeyBpdC5hbW91bnQgPiAxMDAgfS5mb3JFYWNoIHtcbiAgICAgICAgcHJpbnRsbihcIiR7aXQuZGVzY3JpcHRpb259OiAke2l0LmFtb3VudH0gQ1pLXCIpXG4gICAgfVxuXG4gICAgcHJpbnRsbihcIlxcbj09PSBTb3J0ZWQgbW9zdCB0byBsZWFzdCBleHBlbnNpdmUgPT09XCIpXG4gICAgZXhwZW5zZXMuc29ydGVkQnlEZXNjZW5kaW5nIHsgaXQuYW1vdW50IH0uZm9yRWFjaCB7XG4gICAgICAgIHByaW50bG4oXCIke2l0LmRlc2NyaXB0aW9ufTogJHtpdC5hbW91bnR9IENaS1wiKVxuICAgIH1cblxuICAgIHZhbCBkZXNjcmlwdGlvbnMgPSBleHBlbnNlcy5tYXAgeyBpdC5kZXNjcmlwdGlvbiB9XG4gICAgcHJpbnRsbihcIlxcbkRlc2NyaXB0aW9uczogJGRlc2NyaXB0aW9uc1wiKVxuXG4gICAgdmFsIG1vc3RFeHBlbnNpdmUgPSBleHBlbnNlcy5tYXhCeU9yTnVsbCB7IGl0LmFtb3VudCB9XG4gICAgcHJpbnRsbihcIk1vc3QgZXhwZW5zaXZlOiAke21vc3RFeHBlbnNpdmU/LmRlc2NyaXB0aW9ufSAoJHttb3N0RXhwZW5zaXZlPy5hbW91bnR9IENaSylcIilcbn0ifQ==) |

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
