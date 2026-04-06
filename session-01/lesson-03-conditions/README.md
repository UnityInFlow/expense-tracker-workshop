# Lesson 03 — Conditions
## Podmínky: if / else / when

---

## Cíl / Goal

Dělat rozhodnutí na základě hodnot.  
Make decisions based on values.

Na konci lekce budeš umět kategorizovat výdaj podle výše částky.

---

## Co je nové / What is new

| Konstrukt | Co dělá |
|---|---|
| `if (podmínka) { ... } else { ... }` | Klasická podmínka |
| `val x = if (...) a else b` | `if` jako výraz — vrátí hodnotu |
| `when { podmínka -> hodnota }` | Čistší alternativa k if/else chains |
| `when (hodnota) { "x" -> ... }` | Porovnání s konkrétní hodnotou |
| `else ->` | Výchozí větev ve `when` |

---

## Kontext / Context

> Máme výdaj s částkou.  
> Chceme vědět jestli je "small", "medium", "large", nebo "luxury".  
> S `if/else if/else if/else` by kód byl těžko čitelný.  
> `when` to zapíše přehledně.

---

## Zadání / Exercises

Otevři `start/Main.kt` a implementuj:

1. `label(amount: Int): String` pomocí `if/else`  
   `amount > 100` → `"expensive"`, jinak → `"cheap"`

2. `categorize(amount: Int): String` pomocí `when`  
   - `< 50` → `"small"`  
   - `< 500` → `"medium"`  
   - `< 5000` → `"large"`  
   - jinak → `"luxury"`

3. `isAffordable(amount: Int, budget: Int): Boolean`  
   Vrátí `true` pokud `amount <= budget`  
   Použij `if` jako výraz: `val result = if (...) ... else ...`

4. **Bonus:** `dayType(day: String): String` pomocí `when (day)`  
   `"Saturday"`, `"Sunday"` → `"weekend"`, ostatní → `"workday"`, neznámé → `"unknown"`

---

## Spuštění / Running

Očekávaný výstup:
```
expensive
cheap
small
medium
large
luxury
true
false
workday
weekend
unknown
```

---

## Syntaxe / Syntax reference

```kotlin
// if jako statement
if (amount > 100) {
    println("Expensive")
} else {
    println("Cheap")
}

// if jako výraz
val label = if (amount > 100) "expensive" else "cheap"

// when s podmínkami
val category = when {
    amount < 50  -> "small"
    amount < 500 -> "medium"
    else         -> "large"
}

// when s hodnotou
val result = when (day) {
    "Saturday", "Sunday" -> "weekend"
    else                 -> "workday"
}
```

---

## Klíčové poznatky / Key takeaways

- `if` může být výraz — přiřadíme jeho výsledek do proměnné
- `when` je čitelnější než řetězec `if/else if/else if`
- V `when` lze testovat podmínky nebo porovnávat konkrétní hodnoty
- `else ->` je povinné v `when` výrazu pokud nejsou pokryty všechny možnosti

---

## Dokumentace / Docs

- Control flow: https://kotlinlang.org/docs/control-flow.html
- When expression: https://kotlinlang.org/docs/control-flow.html#when-expression

---

## Další lekce / Next lesson

→ [Lesson 04 — Data Class](../lesson-04-data-class/)
