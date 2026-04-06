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
