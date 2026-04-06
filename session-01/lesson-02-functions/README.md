# Lesson 02 — Functions
## Funkce

---

## Cíl / Goal

Pojmenovat opakovanou akci tak, abychom ji mohli použít kdekoliv.  
Name a repeated action so we can reuse it anywhere.

Na konci lekce budeš mít sadu funkcí pro formátování a výpočet výdajů.

---

## Co je nové / What is new

| Konstrukt | Co dělá |
|---|---|
| `fun` | Klíčové slovo pro definici funkce |
| `(param: Type)` | Parametry funkce s typy |
| `: ReturnType` | Typ hodnoty kterou funkce vrátí |
| `return` | Vrátí hodnotu z funkce |
| `fun f() = expr` | Zkrácený zápis pro jednoduché funkce |

---

## Kontext / Context

> V lekci 01 jsme uložili popis a částku výdaje.  
> Teď chceme výdaj formátovat — `"Lunch: 150 CZK"`.  
> Kdybychom to psali na každém místě, při změně bychom opravovali 10 míst.  
> Funkce to pojmenuje a umožní opakované použití.

---

## Zadání / Exercises

Otevři `start/Main.kt` a implementuj:

1. `formatExpense(description: String, amount: Int): String`  
   `formatExpense("Lunch", 150)` → `"Lunch: 150 CZK"`

2. `withTax(amount: Int): Int`  
   `withTax(100)` → `121`  
   `withTax(200)` → `242`  
   Hint: `(amount * 1.21).toInt()`

3. `printExpense(description: String, amount: Int)` — bez návratové hodnoty  
   Vytiskne: `">>> Lunch: 150 CZK"`

4. **Bonus:** `isExpensive(amount: Int): Boolean`  
   Vrátí `true` pokud `amount > 100`  
   Zkus použít zkrácený zápis: `fun isExpensive(...) = ...`

5. **Bonus:** `formatWithTax()` která volá `withTax()` uvnitř sebe

---

## Spuštění / Running

Očekávaný výstup:
```
Lunch: 150 CZK
121
242
>>> Coffee: 50 CZK
true
false
Lunch: 181 CZK (incl. VAT)
```

---

## Syntaxe / Syntax reference

```kotlin
// Plný zápis
fun nazev(parametr: Typ): NavratovyTyp {
    return hodnota
}

// Zkrácený zápis — pro jednoduché funkce
fun nazev(parametr: Typ): NavratovyTyp = výraz

// Bez návratové hodnoty
fun nazev(parametr: Typ) {
    // dělá něco, nic nevrací
}
```

---

## Klíčové poznatky / Key takeaways

- Funkce pojmenuje akci — jednou napíšeš, použiješ kdekoliv
- Parametry říkají co funkce dostane — typy jsou povinné
- Návratový typ říká co funkce vrátí
- Zkrácený zápis `= výraz` je idiomatický Kotlin pro jednořádkové funkce

---

## Dokumentace / Docs

- Functions: https://kotlinlang.org/docs/functions.html
- Single-expression functions: https://kotlinlang.org/docs/functions.html#single-expression-functions

---

## Další lekce / Next lesson

→ [Lesson 03 — Conditions](../lesson-03-conditions/)
