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
