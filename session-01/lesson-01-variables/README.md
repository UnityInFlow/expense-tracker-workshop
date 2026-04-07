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
| `Double` | Typ pro desetinné číslo (64-bit) |
| `Long` | Typ pro velké celé číslo (64-bit) |
| `Char` | Typ pro jeden Unicode znak |
| `.toInt()`, `.toDouble()`, `.toString()` | Konverze mezi typy |
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
7. Vyzkoušej další typy — vytvoř proměnné s explicitními typy a vytiskni je:
   - `val price: Double = 149.90`
   - `val bigId: Long = 9999999999`
   - `val initial: Char = 'L'`

**Bonus 1:** Spočítej částku s DPH 21% a vytiskni ji.  
Hint: `(amount * 1.21).toInt()`

**Bonus 2:** Vyzkoušej konverzi typů:
```kotlin
val text = amount.toString()
val back = "200".toInt()
println("text: $text, back: $back")
```

---

## Kotlin Playground

> Nemáš IntelliJ? Cvičení můžeš udělat přímo v prohlížeči:

| | Link |
|---|---|
| Cvičení (start) | [Otevřít v Playground](https://play.kotlinlang.org/#eyJ2ZXJzaW9uIjogIjIuMS4wIiwgInBsYXRmb3JtIjogImphdmEiLCAiYXJncyI6ICIiLCAibm9uZU1hcmtlcnMiOiB0cnVlLCAidGhlbWUiOiAiaWRlYSIsICJjb2RlIjogImZ1biBtYWluKCkge1xuICAgIC8vID09PSBMZXNzb24gMDE6IFZhcmlhYmxlcyAmIFR5cGVzID09PVxuXG4gICAgLy8gVE9ETyAxOiBDcmVhdGUgdmFsIGRlc2NyaXB0aW9uIChTdHJpbmcpIFx1MjAxNCBuYW1lIG9mIHlvdXIgZXhwZW5zZSAoZS5nLiBcIkx1bmNoXCIpXG5cbiAgICAvLyBUT0RPIDI6IENyZWF0ZSB2YWwgYW1vdW50IChJbnQpIFx1MjAxNCBhbW91bnQgaW4gQ1pLIChlLmcuIDE1MClcblxuICAgIC8vIFRPRE8gMzogQ3JlYXRlIHZhbCBwYWlkIChCb29sZWFuKSBcdTIwMTQgd2FzIGl0IHBhaWQ/IChlLmcuIGZhbHNlKVxuXG4gICAgLy8gVE9ETyA0OiBQcmludCBlYWNoIHZhcmlhYmxlIG9uIHNlcGFyYXRlIGxpbmVcbiAgICAvLyAgIHByaW50bG4oZGVzY3JpcHRpb24pXG4gICAgLy8gICBwcmludGxuKGFtb3VudClcbiAgICAvLyAgIHByaW50bG4ocGFpZClcblxuICAgIC8vIFRPRE8gNTogUHJpbnQgc2VudGVuY2UgdXNpbmcgc3RyaW5nIHRlbXBsYXRlOlxuICAgIC8vICAgXCJFeHBlbnNlOiA8ZGVzY3JpcHRpb24+IGNvc3RzIDxhbW91bnQ+IENaSywgcGFpZDogPHBhaWQ+XCJcblxuICAgIC8vIFRPRE8gNjogQ3JlYXRlIHZhciB0b3RhbCA9IDAsIHRoZW4gYWRkIGFtb3VudCB0byBpdFxuICAgIC8vICAgUHJpbnQ6IFwiVG90YWw6IDx0b3RhbD4gQ1pLXCJcblxuICAgIC8vIFRPRE8gNzogVHJ5IGRpZmZlcmVudCB0eXBlczpcbiAgICAvLyAgIHZhbCBwcmljZTogRG91YmxlID0gMTQ5LjkwXG4gICAgLy8gICB2YWwgYmlnSWQ6IExvbmcgPSA5OTk5OTk5OTk5XG4gICAgLy8gICB2YWwgaW5pdGlhbDogQ2hhciA9ICdMJ1xuICAgIC8vICAgUHJpbnQgZWFjaCBvbmVcblxuICAgIC8vIEJPTlVTOiBDYWxjdWxhdGUgYW1vdW50IHdpdGggMjElIFZBVFxuICAgIC8vICAgdmFsIHdpdGhWYXQgPSAoYW1vdW50ICogMS4yMSkudG9JbnQoKVxuICAgIC8vICAgUHJpbnQ6IFwiV2l0aCBWQVQ6IDx3aXRoVmF0PiBDWktcIlxuXG4gICAgLy8gQk9OVVM6IFRyeSB0eXBlIGNvbnZlcnNpb25cbiAgICAvLyAgIHZhbCB0ZXh0ID0gYW1vdW50LnRvU3RyaW5nKClcbiAgICAvLyAgIHZhbCBiYWNrID0gXCIyMDBcIi50b0ludCgpXG4gICAgLy8gICBwcmludGxuKFwidGV4dDogJHRleHQsIGJhY2s6ICRiYWNrXCIpXG59In0=) |
| Řešení (finish) | [Otevřít v Playground](https://play.kotlinlang.org/#eyJ2ZXJzaW9uIjogIjIuMS4wIiwgInBsYXRmb3JtIjogImphdmEiLCAiYXJncyI6ICIiLCAibm9uZU1hcmtlcnMiOiB0cnVlLCAidGhlbWUiOiAiaWRlYSIsICJjb2RlIjogImZ1biBtYWluKCkge1xuICAgIHZhbCBkZXNjcmlwdGlvbiA9IFwiTHVuY2hcIlxuICAgIHZhbCBhbW91bnQgPSAxNTBcbiAgICB2YWwgcGFpZCA9IGZhbHNlXG5cbiAgICBwcmludGxuKGRlc2NyaXB0aW9uKVxuICAgIHByaW50bG4oYW1vdW50KVxuICAgIHByaW50bG4ocGFpZClcblxuICAgIHByaW50bG4oXCJFeHBlbnNlOiAkZGVzY3JpcHRpb24gY29zdHMgJGFtb3VudCBDWkssIHBhaWQ6ICRwYWlkXCIpXG5cbiAgICB2YXIgdG90YWwgPSAwXG4gICAgdG90YWwgKz0gYW1vdW50XG4gICAgcHJpbnRsbihcIlRvdGFsOiAkdG90YWwgQ1pLXCIpXG5cbiAgICB2YWwgcHJpY2U6IERvdWJsZSA9IDE0OS45MFxuICAgIHZhbCBiaWdJZDogTG9uZyA9IDk5OTk5OTk5OTlcbiAgICB2YWwgaW5pdGlhbDogQ2hhciA9ICdMJ1xuICAgIHByaW50bG4oXCJQcmljZTogJHByaWNlIENaS1wiKVxuICAgIHByaW50bG4oXCJCaWcgSUQ6ICRiaWdJZFwiKVxuICAgIHByaW50bG4oXCJJbml0aWFsOiAkaW5pdGlhbFwiKVxuXG4gICAgdmFsIHdpdGhWYXQgPSAoYW1vdW50ICogMS4yMSkudG9JbnQoKVxuICAgIHByaW50bG4oXCJXaXRoIFZBVDogJHdpdGhWYXQgQ1pLXCIpXG5cbiAgICB2YWwgdGV4dCA9IGFtb3VudC50b1N0cmluZygpXG4gICAgdmFsIGJhY2sgPSBcIjIwMFwiLnRvSW50KClcbiAgICBwcmludGxuKFwidGV4dDogJHRleHQsIGJhY2s6ICRiYWNrXCIpXG59In0=) |

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
Price: 149.9 CZK
Big ID: 9999999999
Initial: L
With VAT: 181 CZK
text: 150, back: 200
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
