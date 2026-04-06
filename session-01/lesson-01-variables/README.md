# Lesson 01 — Variables & Types
## Proměnné a typy

---

## Cíl / Goal

Naučit se pojmenovat a uložit hodnotu v Kotlinu.  
Learn how to name and store a value in Kotlin.

Na konci lekce budeš umět vytisknout formátovaný výdaj jako:  
`Expense: Lunch costs 150 CZK, paid: false`

---

## Co je nové / What is new

| Konstrukt | Co dělá |
|---|---|
| `val` | Neměnná proměnná — hodnota se po přiřazení nemění |
| `var` | Měnná proměnná — hodnotu lze přepisovat |
| `String` | Typ pro text |
| `Int` | Typ pro celé číslo |
| `Boolean` | Typ pro `true` / `false` |
| `$variable` | String template — vloží hodnotu proměnné do textu |
| `${expression}` | String template s výrazem |

---

## Kontext / Context

> Chceme uložit informaci o výdaji.  
> Výdaj má popis, částku a příznak jestli byl zaplacen.  
> Kde tyto hodnoty uložíme?

Odpověď: **proměnné**.

---

## Zadání / Exercises

Otevři `start/src/main/kotlin/workshop/Main.kt` a vyplň `// TODO` sekce:

1. Vytvoř `val` proměnnou `description` (String) — napiš libovolný výdaj
2. Vytvoř `val` proměnnou `amount` (Int) — napiš částku v Kč
3. Vytvoř `val` proměnnou `paid` (Boolean) — `true` nebo `false`
4. Vytiskni každou proměnnou zvlášť pomocí `println()`
5. Vytiskni větu pomocí string template:  
   `"Expense: <description> costs <amount> CZK, paid: <paid>"`
6. Vytvoř `var total = 0`, přičti k němu `amount` a vytiskni výsledek

**Bonus:** Spočítej částku s DPH 21% a vytiskni ji.  
Hint: `(amount * 1.21).toInt()`

---

## Spuštění / Running

1. Otevři `start/` složku v IntelliJ (**File → Open**)
2. Počkej na Gradle sync
3. Otevři `Main.kt`
4. Klikni na ▶ vedle `fun main()`

Očekávaný výstup:
```
Lunch
150
false
Expense: Lunch costs 150 CZK, paid: false
Total: 150 CZK
With VAT: 181 CZK
```

---

## Klíčové poznatky / Key takeaways

```kotlin
val x = 5       // neměnné — použij jako výchozí
var y = 5       // měnné — jen když potřebuješ měnit
y = 10          // OK
// x = 10       // CHYBA — val nelze změnit

"$variable"     // vloží hodnotu proměnné
"${1 + 1}"      // vloží výsledek výrazu — 2
```

---

## Časté chyby / Common mistakes

| Chyba | Příčina | Řešení |
|---|---|---|
| `Val cannot be reassigned` | Zkusil jsi změnit `val` | Použij `var` |
| `Unresolved reference` | Proměnná neexistuje nebo je špatně napsaná | Zkontroluj název |
| `Type mismatch` | Přiřazuješ špatný typ | Zkontroluj typ proměnné |

---

## Dokumentace / Docs

- Variables: https://kotlinlang.org/docs/basic-syntax.html#variables
- Basic types: https://kotlinlang.org/docs/basic-types.html
- String templates: https://kotlinlang.org/docs/strings.html#string-templates

---

## Další lekce / Next lesson

→ [Lesson 02 — Functions](../lesson-02-functions/)  
V lekci 02 pojmenujeme opakované akce jako funkce.
