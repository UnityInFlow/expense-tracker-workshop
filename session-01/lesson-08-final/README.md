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

## Kotlin Playground

> Nemáš IntelliJ? Cvičení můžeš udělat přímo v prohlížeči:

| | Link |
|---|---|
| Cvičení (start) | [Otevřít v Playground](https://play.kotlinlang.org/#eyJ2ZXJzaW9uIjogIjIuMS4wIiwgInBsYXRmb3JtIjogImphdmEiLCAiYXJncyI6ICIiLCAibm9uZU1hcmtlcnMiOiB0cnVlLCAidGhlbWUiOiAiaWRlYSIsICJjb2RlIjogIi8vIFRPRE8gMTogRGVmaW5lIGRhdGEgY2xhc3MgRXhwZW5zZVxuLy8gICBpZDogSW50LCBkZXNjcmlwdGlvbjogU3RyaW5nLCBhbW91bnQ6IEludCwgZGF0ZTogU3RyaW5nXG5cbi8vIFRPRE8gMjogRGVmaW5lIGNsYXNzIEV4cGVuc2VTZXJ2aWNlIHdpdGg6XG4vLyAgIHByaXZhdGUgdmFsIGRhdGFiYXNlID0gSGFzaE1hcDxJbnQsIEV4cGVuc2U+KClcbi8vICAgcHJpdmF0ZSB2YXIgbmV4dElkID0gMVxuLy9cbi8vICAgZnVuIGFkZChkZXNjcmlwdGlvbjogU3RyaW5nLCBhbW91bnQ6IEludCk6IEV4cGVuc2Vcbi8vICAgZnVuIGdldEFsbCgpOiBMaXN0PEV4cGVuc2U+XG4vLyAgIGZ1biBmaW5kQnlJZChpZDogSW50KTogRXhwZW5zZT9cbi8vICAgZnVuIGRlbGV0ZShpZDogSW50KTogQm9vbGVhblxuLy8gICBmdW4gdG90YWwoKTogSW50XG4vLyAgIGZ1biBnZXRBYm92ZSh0aHJlc2hvbGQ6IEludCk6IExpc3Q8RXhwZW5zZT5cbi8vICAgZnVuIGNhdGVnb3JpemUoaWQ6IEludCk6IFN0cmluZyAgIDwtLSBORVchXG4vLyAgICAgVXNlIHdoZW46XG4vLyAgICAgICBhbW91bnQgPCA1MCAgIC0+IFwic21hbGxcIlxuLy8gICAgICAgYW1vdW50IDwgNTAwICAtPiBcIm1lZGl1bVwiXG4vLyAgICAgICBlbHNlICAgICAgICAgIC0+IFwibGFyZ2VcIlxuLy8gICAgIElmIG5vdCBmb3VuZCAgICAtPiBcIm5vdCBmb3VuZFwiXG5cbmZ1biBtYWluKCkge1xuICAgIC8vIFRPRE8gMzogQ3JlYXRlIEV4cGVuc2VTZXJ2aWNlIGFuZCBhZGQgZXhwZW5zZXM6XG4gICAgLy8gICBcIkx1bmNoXCIgMTUwLCBcIkNvZmZlZVwiIDUwLCBcIk1ldHJvXCIgMzIsIFwiVGF4aVwiIDQ4MCwgXCJOb3RlYm9va1wiIDI1MDAwXG5cbiAgICAvLyBUT0RPIDQ6IFByaW50IGV4cGVuc2UgcmVwb3J0OlxuICAgIC8vICAgPT09IEV4cGVuc2UgUmVwb3J0ID09PVxuICAgIC8vICAgWzFdIEx1bmNoOiAxNTAgQ1pLIFx1MjAxNCBtZWRpdW1cbiAgICAvLyAgIC4uLlxuXG4gICAgLy8gVE9ETyA1OiBQcmludCB0b3RhbCwgY291bnQsIGhvdyBtYW55IGFib3ZlIDEwMCBDWktcblxuICAgIC8vIFRPRE8gNjogRGVsZXRlIENvZmZlZSAoSUQgMiksIHByaW50IHVwZGF0ZWQgdG90YWwgYW5kIGNvdW50XG59In0=) |
| Řešení (finish) | [Otevřít v Playground](https://play.kotlinlang.org/#eyJ2ZXJzaW9uIjogIjIuMS4wIiwgInBsYXRmb3JtIjogImphdmEiLCAiYXJncyI6ICIiLCAibm9uZU1hcmtlcnMiOiB0cnVlLCAidGhlbWUiOiAiaWRlYSIsICJjb2RlIjogImRhdGEgY2xhc3MgRXhwZW5zZShcbiAgICB2YWwgaWQ6IEludCxcbiAgICB2YWwgZGVzY3JpcHRpb246IFN0cmluZyxcbiAgICB2YWwgYW1vdW50OiBJbnQsXG4gICAgdmFsIGRhdGU6IFN0cmluZ1xuKVxuXG5jbGFzcyBFeHBlbnNlU2VydmljZSB7XG5cbiAgICBwcml2YXRlIHZhbCBkYXRhYmFzZSA9IEhhc2hNYXA8SW50LCBFeHBlbnNlPigpXG4gICAgcHJpdmF0ZSB2YXIgbmV4dElkID0gMVxuXG4gICAgZnVuIGFkZChkZXNjcmlwdGlvbjogU3RyaW5nLCBhbW91bnQ6IEludCk6IEV4cGVuc2Uge1xuICAgICAgICB2YWwgZXhwZW5zZSA9IEV4cGVuc2UobmV4dElkLCBkZXNjcmlwdGlvbiwgYW1vdW50LCBcIjIwMjQtMDEtMTVcIilcbiAgICAgICAgZGF0YWJhc2VbbmV4dElkXSA9IGV4cGVuc2VcbiAgICAgICAgbmV4dElkKytcbiAgICAgICAgcmV0dXJuIGV4cGVuc2VcbiAgICB9XG5cbiAgICBmdW4gZ2V0QWxsKCk6IExpc3Q8RXhwZW5zZT4gPSBkYXRhYmFzZS52YWx1ZXMudG9MaXN0KClcblxuICAgIGZ1biBmaW5kQnlJZChpZDogSW50KTogRXhwZW5zZT8gPSBkYXRhYmFzZVtpZF1cblxuICAgIGZ1biBkZWxldGUoaWQ6IEludCk6IEJvb2xlYW4gPSBkYXRhYmFzZS5yZW1vdmUoaWQpICE9IG51bGxcblxuICAgIGZ1biB0b3RhbCgpOiBJbnQgPSBkYXRhYmFzZS52YWx1ZXMuc3VtT2YgeyBpdC5hbW91bnQgfVxuXG4gICAgZnVuIGdldEFib3ZlKHRocmVzaG9sZDogSW50KTogTGlzdDxFeHBlbnNlPiA9XG4gICAgICAgIGRhdGFiYXNlLnZhbHVlcy5maWx0ZXIgeyBpdC5hbW91bnQgPiB0aHJlc2hvbGQgfVxuXG4gICAgZnVuIGNhdGVnb3JpemUoaWQ6IEludCk6IFN0cmluZyB7XG4gICAgICAgIHZhbCBleHBlbnNlID0gZGF0YWJhc2VbaWRdID86IHJldHVybiBcIm5vdCBmb3VuZFwiXG4gICAgICAgIHJldHVybiB3aGVuIHtcbiAgICAgICAgICAgIGV4cGVuc2UuYW1vdW50IDwgNTAgICAtPiBcInNtYWxsXCJcbiAgICAgICAgICAgIGV4cGVuc2UuYW1vdW50IDwgNTAwICAtPiBcIm1lZGl1bVwiXG4gICAgICAgICAgICBlbHNlICAgICAgICAgICAgICAgICAgLT4gXCJsYXJnZVwiXG4gICAgICAgIH1cbiAgICB9XG59XG5cbmZ1biBtYWluKCkge1xuICAgIHZhbCBzZXJ2aWNlID0gRXhwZW5zZVNlcnZpY2UoKVxuXG4gICAgc2VydmljZS5hZGQoXCJMdW5jaFwiLCAxNTApXG4gICAgc2VydmljZS5hZGQoXCJDb2ZmZWVcIiwgNTApXG4gICAgc2VydmljZS5hZGQoXCJNZXRyb1wiLCAzMilcbiAgICBzZXJ2aWNlLmFkZChcIlRheGlcIiwgNDgwKVxuICAgIHNlcnZpY2UuYWRkKFwiTm90ZWJvb2tcIiwgMjUwMDApXG5cbiAgICBwcmludGxuKFwiPT09IEV4cGVuc2UgUmVwb3J0ID09PVwiKVxuICAgIHNlcnZpY2UuZ2V0QWxsKCkuZm9yRWFjaCB7XG4gICAgICAgIHByaW50bG4oXCJbJHtpdC5pZH1dICR7aXQuZGVzY3JpcHRpb259OiAke2l0LmFtb3VudH0gQ1pLIFx1MjAxNCAke3NlcnZpY2UuY2F0ZWdvcml6ZShpdC5pZCl9XCIpXG4gICAgfVxuXG4gICAgcHJpbnRsbihcIlxcblRvdGFsOiAke3NlcnZpY2UudG90YWwoKX0gQ1pLXCIpXG4gICAgcHJpbnRsbihcIkNvdW50OiAke3NlcnZpY2UuZ2V0QWxsKCkuc2l6ZX1cIilcbiAgICBwcmludGxuKFwiQWJvdmUgMTAwIENaSzogJHtzZXJ2aWNlLmdldEFib3ZlKDEwMCkuc2l6ZX0gZXhwZW5zZXNcIilcblxuICAgIHByaW50bG4oXCJcXG5BZnRlciBkZWxldGluZyBbMl06XCIpXG4gICAgc2VydmljZS5kZWxldGUoMilcbiAgICBwcmludGxuKFwiVG90YWw6ICR7c2VydmljZS50b3RhbCgpfSBDWktcIilcbiAgICBwcmludGxuKFwiQ291bnQ6ICR7c2VydmljZS5nZXRBbGwoKS5zaXplfVwiKVxufSJ9) |

---

