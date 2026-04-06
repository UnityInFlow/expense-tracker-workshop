# Lesson 08 — Final: Complete Expense Tracker
## Vše dohromady

---

## Cíl / Goal

Spojit všechny konstrukty z lekcí 01–07 do jednoho fungujícího Expense Trackeru.  
Combine all constructs from lessons 01–07 into one working Expense Tracker.

Toto je výsledný stav Session 1 — základ pro Session 2.

---

## Co procvičíš / What you will practice

| Konstrukt | Lekce |
|---|---|
| `val` / `var` | 01 |
| String templates `${}` | 01 |
| `fun` + zkrácený zápis | 02 |
| `if` / `when` | 03 |
| `data class` + instance | 04 |
| `for` / `forEach` / `filter` / `sumOf` | 05 |
| `HashMap` + `?.` + `?:` | 06 |
| `class` + `private` | 07 |

---

## Zadání / Exercise

Otevři `start/Main.kt`.

Postav kompletní Expense Tracker od nuly:

1. Definuj `data class Expense` s poli `id`, `description`, `amount`, `date`

2. Implementuj `ExpenseService` s metodami:
   - `add(description, amount): Expense`
   - `getAll(): List<Expense>`
   - `findById(id): Expense?`
   - `delete(id): Boolean`
   - `total(): Int`
   - `getAbove(threshold): List<Expense>`
   - `categorize(id): String`  ← NOVÉ  
     Použij `when` na `amount`:
     - `< 50` → `"small"`
     - `< 500` → `"medium"`
     - `>= 500` → `"large"`
     - ID nenalezeno → `"not found"`

3. V `main()` vytvoř zprávu:

```
=== Expense Report ===
[1] Lunch: 150 CZK — medium
[2] Coffee: 50 CZK — medium
[3] Metro: 32 CZK — small
[4] Taxi: 480 CZK — medium
[5] Notebook: 25000 CZK — large

Total: 25712 CZK
Count: 5
Above 100 CZK: 3 expenses

After deleting [2]:
Total: 25662 CZK
Count: 4
```

---

## Finish složka / Finish folder

`finish/` obsahuje kompletní referenční řešení.  
Otevři ho pokud se zasekneš, nebo pro inspiraci jak psát idiomatic Kotlin.

---

## Bridge do Session 2 / Bridge to Session 2

Po dokončení tohoto `start/` projektu máš základ pro Session 2.

**Co se stane v Session 2:**

```
Session 1:                        Session 2:

val service = ExpenseService()    @Service
                                  class ExpenseService(
                                      private val repository: ExpenseRepository
                                  )

service.add("Lunch", 150)         POST /expenses
                                  {"description":"Lunch","amount":150}

service.getAll()                  GET /expenses
                                  → [{"id":1,"description":"Lunch",...}]

service.delete(1)                 DELETE /expenses/1
                                  → {"success": true}
```

**Co se nezmění:**
- `data class Expense` — beze změny
- Logika `add`, `getAll`, `delete`, `total` — beze změny

**Co přibyde:**
- Spring Boot controller — převede HTTP request na volání service
- SQLite repository — nahradí HashMap (data přežijí restart)
- Swagger UI — vizuální API dokumentace v prohlížeči

---

## Finální architektura Session 1

```
data class Expense
  id: Int
  description: String
  amount: Int
  date: String

class ExpenseService
  private database: HashMap<Int, Expense>
  private nextId: Int
  ─────────────────────────
  + add(description, amount): Expense
  + getAll(): List<Expense>
  + findById(id): Expense?
  + delete(id): Boolean
  + total(): Int
  + getAbove(threshold): List<Expense>
  + categorize(id): String

fun main()
  → vytvoří ExpenseService
  → přidá výdaje
  → vytiskne report
```

---

## Gratulace / Congratulations

Pokud jsi sem došel, naučil ses:

- číst a psát Kotlin kód
- pracovat s proměnnými, funkcemi a podmínkami
- modelovat data pomocí `data class`
- pracovat s kolekcemi a HashMap
- zapouzdřit logiku do service třídy

To je základ který vývojáři používají každý den.  
**Session 2 tuto logiku vystaví jako HTTP API — žádný curl, žádné terminál. Swagger UI.**
