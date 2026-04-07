# Lesson 04 — Data Class
## Datový model

---

## Cíl / Goal

Seskupit příbuzné hodnoty do jednoho pojmenovaného celku.  
Group related values into one named structure.

Na konci lekce budeš mít `data class Expense` — základ celého Expense Trackeru.

---

## Co je nové / What is new

| Konstrukt | Co dělá |
|---|---|
| `data class Name(val field: Type, ...)` | Definice datové třídy — šablona |
| `Name(field = value, ...)` | Vytvoření instance — konkrétní objekt |
| `instance.field` | Přístup k hodnotě přes tečku |
| `.copy(field = newValue)` | Kopie s upravenou hodnotou |
| Automatický `toString()` | Hezký tisk bez `com.example.Expense@7852e922` |
| Automatický `equals()` | Porovnání podle hodnot |

---

## Kontext / Context

> Výdaj má popis, částku a datum — to jsou 3 proměnné.  
> Pro 100 výdajů = 300 proměnných → chaos.  
>
> `data class` je šablona — říká "výdaj je věc která má id, popis, částku a datum".  
> Instance je konkrétní výdaj vytvořený podle šablony.

**Analogie pro DevOps:**

```yaml
# YAML schema — to znáš
expense:
  id: integer
  description: string
  amount: integer
  date: string
```

```kotlin
// Přesně totéž v Kotlinu
data class Expense(
    val id: Int,
    val description: String,
    val amount: Int,
    val date: String
)
```

---

## Zadání / Exercises

Otevři `start/Main.kt` a vyřeš:

1. Definuj `data class Expense` s poli: `id` (Int), `description` (String), `amount` (Int), `date` (String)

2. Vytvoř 3 instance s vlastními výdaji — použij pojmenované parametry:  
   `Expense(id = 1, description = "Lunch", amount = 150, date = "2024-01-15")`

3. Pro každý výdaj vytiskni:  
   `"Expense #<id>: <description> — <amount> CZK"`

4. Najdi a vytiskni výdaj s nejvyšší částkou  
   Hint: porovnej `.amount` pomocí `if`

5. **Bonus:** Použij `.copy()` pro vytvoření upraveného výdaje  
   Ukaž že originál se nezměnil

---

## Kotlin Playground

> Nemáš IntelliJ? Cvičení můžeš udělat přímo v prohlížeči:

| | Link |
|---|---|
| Cvičení (start) | [Otevřít v Playground](https://play.kotlinlang.org/#eyJ2ZXJzaW9uIjogIjIuMS4wIiwgInBsYXRmb3JtIjogImphdmEiLCAiYXJncyI6ICIiLCAibm9uZU1hcmtlcnMiOiB0cnVlLCAidGhlbWUiOiAiaWRlYSIsICJjb2RlIjogIi8vIFRPRE8gMTogRGVmaW5lIGRhdGEgY2xhc3MgRXhwZW5zZSB3aXRoOlxuLy8gICB2YWwgaWQ6IEludFxuLy8gICB2YWwgZGVzY3JpcHRpb246IFN0cmluZ1xuLy8gICB2YWwgYW1vdW50OiBJbnRcbi8vICAgdmFsIGRhdGU6IFN0cmluZ1xuXG5mdW4gbWFpbigpIHtcbiAgICAvLyBUT0RPIDI6IENyZWF0ZSAzIGV4cGVuc2UgaW5zdGFuY2VzIHdpdGggbmFtZWQgcGFyYW1ldGVyc1xuICAgIC8vIHZhbCBsdW5jaCA9IEV4cGVuc2UoaWQgPSAxLCBkZXNjcmlwdGlvbiA9IFwiTHVuY2hcIiwgYW1vdW50ID0gMTUwLCBkYXRlID0gXCIyMDI0LTAxLTE1XCIpXG4gICAgLy8gdmFsIGNvZmZlZSA9IEV4cGVuc2UoaWQgPSAyLCBkZXNjcmlwdGlvbiA9IFwiQ29mZmVlXCIsIGFtb3VudCA9IDUwLCBkYXRlID0gXCIyMDI0LTAxLTE1XCIpXG4gICAgLy8gdmFsIG1ldHJvID0gRXhwZW5zZShpZCA9IDMsIGRlc2NyaXB0aW9uID0gXCJNZXRyb1wiLCBhbW91bnQgPSAzMiwgZGF0ZSA9IFwiMjAyNC0wMS0xNVwiKVxuXG4gICAgLy8gVE9ETyAzOiBQcmludCBlYWNoOiBcIkV4cGVuc2UgIzxpZD46IDxkZXNjcmlwdGlvbj4gXHUyMDE0IDxhbW91bnQ+IENaS1wiXG5cbiAgICAvLyBUT0RPIDQ6IEZpbmQgdGhlIG1vc3QgZXhwZW5zaXZlIGFuZCBwcmludDpcbiAgICAvLyAgIFwiTW9zdCBleHBlbnNpdmU6IDxkZXNjcmlwdGlvbj4gKDxhbW91bnQ+IENaSylcIlxuXG4gICAgLy8gQk9OVVM6IFVzZSAuY29weSgpIHRvIGNyZWF0ZSB1cGRhdGVkIGV4cGVuc2Ugd2l0aCBkaWZmZXJlbnQgYW1vdW50XG4gICAgLy8gICB2YWwgdXBkYXRlZCA9IGx1bmNoLmNvcHkoYW1vdW50ID0gMjAwKVxuICAgIC8vICAgUHJpbnQgdXBkYXRlZCBhbW91bnQgQU5EIG9yaWdpbmFsIHRvIHNob3cgb3JpZ2luYWwgaXMgdW5jaGFuZ2VkXG59In0=) |
| Řešení (finish) | [Otevřít v Playground](https://play.kotlinlang.org/#eyJ2ZXJzaW9uIjogIjIuMS4wIiwgInBsYXRmb3JtIjogImphdmEiLCAiYXJncyI6ICIiLCAibm9uZU1hcmtlcnMiOiB0cnVlLCAidGhlbWUiOiAiaWRlYSIsICJjb2RlIjogImRhdGEgY2xhc3MgRXhwZW5zZShcbiAgICB2YWwgaWQ6IEludCxcbiAgICB2YWwgZGVzY3JpcHRpb246IFN0cmluZyxcbiAgICB2YWwgYW1vdW50OiBJbnQsXG4gICAgdmFsIGRhdGU6IFN0cmluZ1xuKVxuXG5mdW4gbWFpbigpIHtcbiAgICB2YWwgbHVuY2ggPSBFeHBlbnNlKGlkID0gMSwgZGVzY3JpcHRpb24gPSBcIkx1bmNoXCIsIGFtb3VudCA9IDE1MCwgZGF0ZSA9IFwiMjAyNC0wMS0xNVwiKVxuICAgIHZhbCBjb2ZmZWUgPSBFeHBlbnNlKGlkID0gMiwgZGVzY3JpcHRpb24gPSBcIkNvZmZlZVwiLCBhbW91bnQgPSA1MCwgZGF0ZSA9IFwiMjAyNC0wMS0xNVwiKVxuICAgIHZhbCBtZXRybyA9IEV4cGVuc2UoaWQgPSAzLCBkZXNjcmlwdGlvbiA9IFwiTWV0cm9cIiwgYW1vdW50ID0gMzIsIGRhdGUgPSBcIjIwMjQtMDEtMTVcIilcblxuICAgIHByaW50bG4oXCJFeHBlbnNlICMke2x1bmNoLmlkfTogJHtsdW5jaC5kZXNjcmlwdGlvbn0gXHUyMDE0ICR7bHVuY2guYW1vdW50fSBDWktcIilcbiAgICBwcmludGxuKFwiRXhwZW5zZSAjJHtjb2ZmZWUuaWR9OiAke2NvZmZlZS5kZXNjcmlwdGlvbn0gXHUyMDE0ICR7Y29mZmVlLmFtb3VudH0gQ1pLXCIpXG4gICAgcHJpbnRsbihcIkV4cGVuc2UgIyR7bWV0cm8uaWR9OiAke21ldHJvLmRlc2NyaXB0aW9ufSBcdTIwMTQgJHttZXRyby5hbW91bnR9IENaS1wiKVxuXG4gICAgcHJpbnRsbihcIk1vc3QgZXhwZW5zaXZlOiAke2x1bmNoLmRlc2NyaXB0aW9ufSAoJHtsdW5jaC5hbW91bnR9IENaSylcIilcblxuICAgIHZhbCB1cGRhdGVkID0gbHVuY2guY29weShhbW91bnQgPSAyMDApXG4gICAgcHJpbnRsbihcIlVwZGF0ZWQ6ICR7dXBkYXRlZC5hbW91bnR9IENaS1wiKVxuICAgIHByaW50bG4oXCJPcmlnaW5hbDogJHtsdW5jaC5hbW91bnR9IENaS1wiKVxufSJ9) |

---

## Spuštění / Running

Očekávaný výstup:
```
Expense #1: Lunch — 150 CZK
Expense #2: Coffee — 50 CZK
Expense #3: Metro — 32 CZK
Most expensive: Lunch (150 CZK)
Updated: 200 CZK
Original: 150 CZK
```

---

## Syntaxe / Syntax reference

```kotlin
// Definice
data class Expense(val id: Int, val description: String,
                   val amount: Int, val date: String)

// Instance — pojmenované parametry (doporučeno)
val lunch = Expense(id = 1, description = "Lunch", amount = 150, date = "2024-01-15")

// Instance — poziční (kratší, ale méně čitelné)
val coffee = Expense(2, "Coffee", 50, "2024-01-15")

// Přístup
println(lunch.description)   // Lunch
println(lunch)               // Expense(id=1, description=Lunch, amount=150, date=2024-01-15)

// copy() — originál nezměněn
val updated = lunch.copy(amount = 200)
```

---

## Klíčové poznatky / Key takeaways

- `data class` je šablona — existuje jednou v kódu
- Instance je konkrétní objekt vytvořený podle šablony — může jich být kolik chceme
- `data class` automaticky přidá `toString`, `equals`, `copy` — napsat je ručně by bylo desítky řádků
- Pojmenované parametry zvýší čitelnost — doporučeno vždy

---

## Dokumentace / Docs

- Data classes: https://kotlinlang.org/docs/data-classes.html
- Classes: https://kotlinlang.org/docs/classes.html

---

## Další lekce / Next lesson

→ [Lesson 05 — Collections](../lesson-05-collections/)
