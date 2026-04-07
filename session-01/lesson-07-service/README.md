# Lesson 07 — Service Class
## Třída s logikou: ExpenseService

---

## Cíl / Goal

Zabalit veškerou logiku správy výdajů do jedné třídy s jasně definovaným rozhraním.  
Encapsulate all expense management logic into one class with a well-defined interface.

Na konci lekce budeš mít kompletní `ExpenseService` — to samé co dostaneš jako základ v Session 2.

---

## Co je nové / What is new

| Konstrukt | Co dělá |
|---|---|
| `class Name { ... }` | Třída s metodami a stavem |
| `private val field` | Skrytá proměnná — přístupná jen uvnitř |
| `private var field` | Skrytá měnná proměnná |
| `fun methodName()` | Veřejná metoda — přístupná zvenku |
| `nextId++` | Post-increment: použij hodnotu, pak zvyš o 1 |

---

## Kontext / Context

> V lekcích 01–06 jsme dělali vše v `main()`.  
> HashMap byl volně přístupný, logika rozhazená.  
> Kdybychom to chtěli použít na dvou místech → kopírování.  
> Kdybychom měnili databázi za SQLite → hledáme změny všude.
>
> **Service třída = jedno místo, jedna zodpovědnost.**

**Single Responsibility Principle:**
- `ExpenseService` spravuje výdaje — nic jiného
- Zvenku vidíš jen metody: `add`, `getAll`, `findById`, `delete`, `total`
- Jak to funguje uvnitř (HashMap, nextId) — to nikoho nezajímá

**Analogie pro DevOps:**
- `private` = `internal` v Ansible roli — implementační detail je skrytý
- Veřejné metody = veřejné rozhraní role
- Kdokoliv může zavolat `add()` — nikdo nemůže smazat `database` přímo

---

## Zadání / Exercises

Otevři `start/Main.kt` — `ExpenseService` má připravené prázdné metody s `TODO`.

Implementuj:

1. `add(description: String, amount: Int): Expense`
   - Vytvoř `Expense` s `nextId`, `description`, `amount`, `"2024-01-15"`
   - Ulož do `database`
   - Zvyš `nextId`
   - Vrať vytvořený výdaj

2. `getAll(): List<Expense>`
   - Vrať všechny výdaje jako List
   - Hint: `database.values.toList()`

3. `findById(id: Int): Expense?`
   - Vrať výdaj nebo `null`
   - Hint: `database[id]`

4. `delete(id: Int): Boolean`
   - Smaž a vrať `true` pokud existoval, `false` pokud ne
   - Hint: `database.remove(id) != null`

5. `total(): Int`
   - Vrať celkovou sumu
   - Hint: `database.values.sumOf { it.amount }`

6. **Bonus:** `getAbove(threshold: Int): List<Expense>`
   - Vrať výdaje jejichž `amount > threshold`

---

## Kotlin Playground

> Nemáš IntelliJ? Cvičení můžeš udělat přímo v prohlížeči:

| | Link |
|---|---|
| Cvičení (start) | [Otevřít v Playground](https://play.kotlinlang.org/#eyJ2ZXJzaW9uIjogIjIuMS4wIiwgInBsYXRmb3JtIjogImphdmEiLCAiYXJncyI6ICIiLCAibm9uZU1hcmtlcnMiOiB0cnVlLCAidGhlbWUiOiAiaWRlYSIsICJjb2RlIjogImRhdGEgY2xhc3MgRXhwZW5zZShcbiAgICB2YWwgaWQ6IEludCxcbiAgICB2YWwgZGVzY3JpcHRpb246IFN0cmluZyxcbiAgICB2YWwgYW1vdW50OiBJbnQsXG4gICAgdmFsIGRhdGU6IFN0cmluZ1xuKVxuXG5jbGFzcyBFeHBlbnNlU2VydmljZSB7XG5cbiAgICBwcml2YXRlIHZhbCBkYXRhYmFzZSA9IEhhc2hNYXA8SW50LCBFeHBlbnNlPigpXG4gICAgcHJpdmF0ZSB2YXIgbmV4dElkID0gMVxuXG4gICAgLy8gVE9ETyAxOiBmdW4gYWRkKGRlc2NyaXB0aW9uOiBTdHJpbmcsIGFtb3VudDogSW50KTogRXhwZW5zZVxuICAgIC8vICAgQ3JlYXRlIEV4cGVuc2Ugd2l0aCBuZXh0SWQsIFwiMjAyNC0wMS0xNVwiIGFzIGRhdGVcbiAgICAvLyAgIFN0b3JlIGluIGRhdGFiYXNlLCBpbmNyZW1lbnQgbmV4dElkLCByZXR1cm4gdGhlIGV4cGVuc2VcblxuICAgIC8vIFRPRE8gMjogZnVuIGdldEFsbCgpOiBMaXN0PEV4cGVuc2U+XG4gICAgLy8gICBSZXR1cm4gZGF0YWJhc2UudmFsdWVzLnRvTGlzdCgpXG5cbiAgICAvLyBUT0RPIDM6IGZ1biBmaW5kQnlJZChpZDogSW50KTogRXhwZW5zZT9cbiAgICAvLyAgIFJldHVybiBkYXRhYmFzZVtpZF1cblxuICAgIC8vIFRPRE8gNDogZnVuIGRlbGV0ZShpZDogSW50KTogQm9vbGVhblxuICAgIC8vICAgUmV0dXJuIGRhdGFiYXNlLnJlbW92ZShpZCkgIT0gbnVsbFxuXG4gICAgLy8gVE9ETyA1OiBmdW4gdG90YWwoKTogSW50XG4gICAgLy8gICBSZXR1cm4gZGF0YWJhc2UudmFsdWVzLnN1bU9mIHsgaXQuYW1vdW50IH1cblxuICAgIC8vIEJPTlVTOiBmdW4gZ2V0QWJvdmUodGhyZXNob2xkOiBJbnQpOiBMaXN0PEV4cGVuc2U+XG4gICAgLy8gICBSZXR1cm4gZGF0YWJhc2UudmFsdWVzLmZpbHRlciB7IGl0LmFtb3VudCA+IHRocmVzaG9sZCB9XG59XG5cbmZ1biBtYWluKCkge1xuICAgIHZhbCBzZXJ2aWNlID0gRXhwZW5zZVNlcnZpY2UoKVxuXG4gICAgLy8gVE9ETyA2OiBBZGQgNCBleHBlbnNlcyB1c2luZyBzZXJ2aWNlLmFkZCguLi4pXG4gICAgLy8gICBcIkx1bmNoXCIgMTUwLCBcIkNvZmZlZVwiIDUwLCBcIlRheGlcIiA0ODAsIFwiTWV0cm9cIiAzMlxuXG4gICAgLy8gVE9ETyA3OiBQcmludCBjb3VudCBhbmQgdG90YWxcblxuICAgIC8vIFRPRE8gODogUHJpbnQgYWxsIGV4cGVuc2VzXG4gICAgcHJpbnRsbihcIlxcbj09PSBBbGwgZXhwZW5zZXMgPT09XCIpXG5cbiAgICAvLyBUT0RPIDk6IEZpbmQgYnkgSUQgMiBhbmQgSUQgOTlcblxuICAgIC8vIFRPRE8gMTA6IERlbGV0ZSBJRCAxIChzaG91bGQgYmUgdHJ1ZSksIGRlbGV0ZSBJRCA5OSAoc2hvdWxkIGJlIGZhbHNlKVxuICAgIC8vICAgUHJpbnQgY291bnQgYWZ0ZXIgZGVsZXRlXG5cbiAgICAvLyBCT05VUzogUHJpbnQgZXhwZW5zZXMgYWJvdmUgMTAwIENaS1xufSJ9) |
| Řešení (finish) | [Otevřít v Playground](https://play.kotlinlang.org/#eyJ2ZXJzaW9uIjogIjIuMS4wIiwgInBsYXRmb3JtIjogImphdmEiLCAiYXJncyI6ICIiLCAibm9uZU1hcmtlcnMiOiB0cnVlLCAidGhlbWUiOiAiaWRlYSIsICJjb2RlIjogImRhdGEgY2xhc3MgRXhwZW5zZShcbiAgICB2YWwgaWQ6IEludCxcbiAgICB2YWwgZGVzY3JpcHRpb246IFN0cmluZyxcbiAgICB2YWwgYW1vdW50OiBJbnQsXG4gICAgdmFsIGRhdGU6IFN0cmluZ1xuKVxuXG5jbGFzcyBFeHBlbnNlU2VydmljZSB7XG5cbiAgICBwcml2YXRlIHZhbCBkYXRhYmFzZSA9IEhhc2hNYXA8SW50LCBFeHBlbnNlPigpXG4gICAgcHJpdmF0ZSB2YXIgbmV4dElkID0gMVxuXG4gICAgZnVuIGFkZChkZXNjcmlwdGlvbjogU3RyaW5nLCBhbW91bnQ6IEludCk6IEV4cGVuc2Uge1xuICAgICAgICB2YWwgZXhwZW5zZSA9IEV4cGVuc2UobmV4dElkLCBkZXNjcmlwdGlvbiwgYW1vdW50LCBcIjIwMjQtMDEtMTVcIilcbiAgICAgICAgZGF0YWJhc2VbbmV4dElkXSA9IGV4cGVuc2VcbiAgICAgICAgbmV4dElkKytcbiAgICAgICAgcmV0dXJuIGV4cGVuc2VcbiAgICB9XG5cbiAgICBmdW4gZ2V0QWxsKCk6IExpc3Q8RXhwZW5zZT4gPSBkYXRhYmFzZS52YWx1ZXMudG9MaXN0KClcblxuICAgIGZ1biBmaW5kQnlJZChpZDogSW50KTogRXhwZW5zZT8gPSBkYXRhYmFzZVtpZF1cblxuICAgIGZ1biBkZWxldGUoaWQ6IEludCk6IEJvb2xlYW4gPSBkYXRhYmFzZS5yZW1vdmUoaWQpICE9IG51bGxcblxuICAgIGZ1biB0b3RhbCgpOiBJbnQgPSBkYXRhYmFzZS52YWx1ZXMuc3VtT2YgeyBpdC5hbW91bnQgfVxuXG4gICAgZnVuIGdldEFib3ZlKHRocmVzaG9sZDogSW50KTogTGlzdDxFeHBlbnNlPiA9XG4gICAgICAgIGRhdGFiYXNlLnZhbHVlcy5maWx0ZXIgeyBpdC5hbW91bnQgPiB0aHJlc2hvbGQgfVxufVxuXG5mdW4gbWFpbigpIHtcbiAgICB2YWwgc2VydmljZSA9IEV4cGVuc2VTZXJ2aWNlKClcblxuICAgIHNlcnZpY2UuYWRkKFwiTHVuY2hcIiwgMTUwKVxuICAgIHNlcnZpY2UuYWRkKFwiQ29mZmVlXCIsIDUwKVxuICAgIHNlcnZpY2UuYWRkKFwiVGF4aVwiLCA0ODApXG4gICAgc2VydmljZS5hZGQoXCJNZXRyb1wiLCAzMilcblxuICAgIHByaW50bG4oXCJDb3VudDogJHtzZXJ2aWNlLmdldEFsbCgpLnNpemV9XCIpXG4gICAgcHJpbnRsbihcIlRvdGFsOiAke3NlcnZpY2UudG90YWwoKX0gQ1pLXCIpXG5cbiAgICBwcmludGxuKFwiXFxuPT09IEFsbCBleHBlbnNlcyA9PT1cIilcbiAgICBzZXJ2aWNlLmdldEFsbCgpLmZvckVhY2gge1xuICAgICAgICBwcmludGxuKFwiWyR7aXQuaWR9XSAke2l0LmRlc2NyaXB0aW9ufTogJHtpdC5hbW91bnR9IENaS1wiKVxuICAgIH1cblxuICAgIHByaW50bG4oXCJcXG5GaW5kIElEIDI6ICR7c2VydmljZS5maW5kQnlJZCgyKT8uZGVzY3JpcHRpb24gPzogXCJub3QgZm91bmRcIn1cIilcbiAgICBwcmludGxuKFwiRmluZCBJRCA5OTogJHtzZXJ2aWNlLmZpbmRCeUlkKDk5KT8uZGVzY3JpcHRpb24gPzogXCJub3QgZm91bmRcIn1cIilcblxuICAgIHByaW50bG4oXCJcXG5EZWxldGVkIElEIDE6ICR7c2VydmljZS5kZWxldGUoMSl9XCIpXG4gICAgcHJpbnRsbihcIkRlbGV0ZWQgSUQgOTk6ICR7c2VydmljZS5kZWxldGUoOTkpfVwiKVxuICAgIHByaW50bG4oXCJDb3VudCBhZnRlciBkZWxldGU6ICR7c2VydmljZS5nZXRBbGwoKS5zaXplfVwiKVxuXG4gICAgcHJpbnRsbihcIlxcbj09PSBBYm92ZSAxMDAgQ1pLID09PVwiKVxuICAgIHNlcnZpY2UuZ2V0QWJvdmUoMTAwKS5mb3JFYWNoIHtcbiAgICAgICAgcHJpbnRsbihcIiR7aXQuZGVzY3JpcHRpb259OiAke2l0LmFtb3VudH0gQ1pLXCIpXG4gICAgfVxufSJ9) |

---

## Spuštění / Running

Očekávaný výstup:
```
Count: 4
Total: 712 CZK

=== All expenses ===
[1] Lunch: 150 CZK
[2] Coffee: 50 CZK
[3] Taxi: 480 CZK
[4] Metro: 32 CZK

Find ID 2: Coffee
Find ID 99: not found

Deleted ID 1: true
Deleted ID 99: false
Count after delete: 3

=== Above 100 CZK ===
Taxi: 480 CZK
```

---

## Vizualizace architektury

```
main() nebo budoucí Controller
         │ volá
         ▼
    ExpenseService              ← VEŠKERÁ logika tady
    ┌─────────────────────┐
    │ + add()             │ ← veřejné (přístupné zvenku)
    │ + getAll()          │
    │ + findById()        │
    │ + delete()          │
    │ + total()           │
    │                     │
    │ - database: HashMap │ ← private (skryté zvenku)
    │ - nextId: Int       │
    └─────────────────────┘
         │
         ▼
    HashMap<Int, Expense>  ← implementační detail
                             (v Session 2 vyměníme za SQLite
                              aniž se dotkne volající kód)
```

---

## Syntaxe / Syntax reference

```kotlin
class ExpenseService {
    private val database = HashMap<Int, Expense>()
    private var nextId = 1

    fun add(description: String, amount: Int): Expense {
        val expense = Expense(nextId, description, amount, "2024-01-15")
        database[nextId] = expense
        nextId++           // použij 1, pak nastav na 2
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
// service.database       ← CHYBA — private, nepřístupné
```

---

## Klíčové poznatky / Key takeaways

- `class` = objekt se stavem (fieldy) a chováním (metodami)
- `private` = skryj implementační detail před okolním světem
- Veřejné metody tvoří kontrakt — co třída nabízí
- `database.remove(id) != null` → `true` pokud klíč existoval
- Single Responsibility: každá třída dělá jednu věc dobře

---

## Dokumentace / Docs

- Classes: https://kotlinlang.org/docs/classes.html
- Visibility modifiers: https://kotlinlang.org/docs/visibility-modifiers.html
- Single Responsibility Principle: https://en.wikipedia.org/wiki/Single-responsibility_principle

---

## Další lekce / Next lesson

→ [Lesson 08 — Final](../lesson-08-final/) — Vše dohromady
