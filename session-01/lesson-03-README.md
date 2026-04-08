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

Modul: `lesson-03-conditions-start` — otevři `Main.kt` a implementuj:

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

## Kotlin Playground

> Nemáš IntelliJ? Cvičení můžeš udělat přímo v prohlížeči:

| | Link |
|---|---|
| Cvičení (start) | [Otevřít v Playground](https://play.kotlinlang.org/#eyJ2ZXJzaW9uIjogIjIuMS4wIiwgInBsYXRmb3JtIjogImphdmEiLCAiYXJncyI6ICIiLCAibm9uZU1hcmtlcnMiOiB0cnVlLCAidGhlbWUiOiAiaWRlYSIsICJjb2RlIjogIi8vIFRPRE8gMTogRGVmaW5lIGZ1bmN0aW9uIGxhYmVsKGFtb3VudDogSW50KTogU3RyaW5nXG4vLyAgIGlmIGFtb3VudCA+IDEwMCByZXR1cm4gXCJleHBlbnNpdmVcIiBlbHNlIHJldHVybiBcImNoZWFwXCJcblxuLy8gVE9ETyAyOiBEZWZpbmUgZnVuY3Rpb24gY2F0ZWdvcml6ZShhbW91bnQ6IEludCk6IFN0cmluZ1xuLy8gICBVc2Ugd2hlbjpcbi8vICAgICA8IDUwICAgLT4gXCJzbWFsbFwiXG4vLyAgICAgPCA1MDAgIC0+IFwibWVkaXVtXCJcbi8vICAgICA8IDUwMDAgLT4gXCJsYXJnZVwiXG4vLyAgICAgZWxzZSAgIC0+IFwibHV4dXJ5XCJcblxuLy8gVE9ETyAzOiBEZWZpbmUgZnVuY3Rpb24gaXNBZmZvcmRhYmxlKGFtb3VudDogSW50LCBidWRnZXQ6IEludCk6IEJvb2xlYW5cbi8vICAgVXNlIGlmIGFzIGV4cHJlc3Npb246IHJldHVybiBpZiAoYW1vdW50IDw9IGJ1ZGdldCkgdHJ1ZSBlbHNlIGZhbHNlXG5cbi8vIEJPTlVTOiBEZWZpbmUgZnVuY3Rpb24gZGF5VHlwZShkYXk6IFN0cmluZyk6IFN0cmluZ1xuLy8gICBVc2Ugd2hlbihkYXkpOlxuLy8gICAgIFwiU2F0dXJkYXlcIiwgXCJTdW5kYXlcIiAtPiBcIndlZWtlbmRcIlxuLy8gICAgIFwiTW9uZGF5XCIsXCJUdWVzZGF5XCIsXCJXZWRuZXNkYXlcIixcIlRodXJzZGF5XCIsXCJGcmlkYXlcIiAtPiBcIndvcmtkYXlcIlxuLy8gICAgIGVsc2UgLT4gXCJ1bmtub3duXCJcblxuZnVuIG1haW4oKSB7XG4gICAgLy8gVE9ETyA0OiBUZXN0IHlvdXIgZnVuY3Rpb25zXG4gICAgLy8gcHJpbnRsbihsYWJlbCgxNTApKVxuICAgIC8vIHByaW50bG4obGFiZWwoMzApKVxuICAgIC8vIHByaW50bG4oY2F0ZWdvcml6ZSgyNSkpXG4gICAgLy8gcHJpbnRsbihjYXRlZ29yaXplKDE1MCkpXG4gICAgLy8gcHJpbnRsbihjYXRlZ29yaXplKDE1MDApKVxuICAgIC8vIHByaW50bG4oY2F0ZWdvcml6ZSgxMDAwMCkpXG4gICAgLy8gcHJpbnRsbihpc0FmZm9yZGFibGUoMTAwLCAyMDApKVxuICAgIC8vIHByaW50bG4oaXNBZmZvcmRhYmxlKDMwMCwgMjAwKSlcbiAgICAvLyBCT05VUzogcHJpbnRsbihkYXlUeXBlKFwiTW9uZGF5XCIpKVxuICAgIC8vIEJPTlVTOiBwcmludGxuKGRheVR5cGUoXCJTYXR1cmRheVwiKSlcbiAgICAvLyBCT05VUzogcHJpbnRsbihkYXlUeXBlKFwiSG9saWRheVwiKSlcbn0ifQ==) |
| Řešení (finish) | [Otevřít v Playground](https://play.kotlinlang.org/#eyJ2ZXJzaW9uIjogIjIuMS4wIiwgInBsYXRmb3JtIjogImphdmEiLCAiYXJncyI6ICIiLCAibm9uZU1hcmtlcnMiOiB0cnVlLCAidGhlbWUiOiAiaWRlYSIsICJjb2RlIjogImZ1biBsYWJlbChhbW91bnQ6IEludCk6IFN0cmluZyB7XG4gICAgcmV0dXJuIGlmIChhbW91bnQgPiAxMDApIFwiZXhwZW5zaXZlXCIgZWxzZSBcImNoZWFwXCJcbn1cblxuZnVuIGNhdGVnb3JpemUoYW1vdW50OiBJbnQpOiBTdHJpbmcgPSB3aGVuIHtcbiAgICBhbW91bnQgPCA1MCAgIC0+IFwic21hbGxcIlxuICAgIGFtb3VudCA8IDUwMCAgLT4gXCJtZWRpdW1cIlxuICAgIGFtb3VudCA8IDUwMDAgLT4gXCJsYXJnZVwiXG4gICAgZWxzZSAgICAgICAgICAtPiBcImx1eHVyeVwiXG59XG5cbmZ1biBpc0FmZm9yZGFibGUoYW1vdW50OiBJbnQsIGJ1ZGdldDogSW50KTogQm9vbGVhbiA9IGlmIChhbW91bnQgPD0gYnVkZ2V0KSB0cnVlIGVsc2UgZmFsc2VcblxuZnVuIGRheVR5cGUoZGF5OiBTdHJpbmcpOiBTdHJpbmcgPSB3aGVuIChkYXkpIHtcbiAgICBcIlNhdHVyZGF5XCIsIFwiU3VuZGF5XCIgLT4gXCJ3ZWVrZW5kXCJcbiAgICBcIk1vbmRheVwiLCBcIlR1ZXNkYXlcIiwgXCJXZWRuZXNkYXlcIiwgXCJUaHVyc2RheVwiLCBcIkZyaWRheVwiIC0+IFwid29ya2RheVwiXG4gICAgZWxzZSAtPiBcInVua25vd25cIlxufVxuXG5mdW4gbWFpbigpIHtcbiAgICBwcmludGxuKGxhYmVsKDE1MCkpXG4gICAgcHJpbnRsbihsYWJlbCgzMCkpXG4gICAgcHJpbnRsbihjYXRlZ29yaXplKDI1KSlcbiAgICBwcmludGxuKGNhdGVnb3JpemUoMTUwKSlcbiAgICBwcmludGxuKGNhdGVnb3JpemUoMTUwMCkpXG4gICAgcHJpbnRsbihjYXRlZ29yaXplKDEwMDAwKSlcbiAgICBwcmludGxuKGlzQWZmb3JkYWJsZSgxMDAsIDIwMCkpXG4gICAgcHJpbnRsbihpc0FmZm9yZGFibGUoMzAwLCAyMDApKVxuICAgIHByaW50bG4oZGF5VHlwZShcIk1vbmRheVwiKSlcbiAgICBwcmludGxuKGRheVR5cGUoXCJTYXR1cmRheVwiKSlcbiAgICBwcmludGxuKGRheVR5cGUoXCJIb2xpZGF5XCIpKVxufSJ9) |

---

## Spuštění / Running

V IntelliJ klikni na ▶ vedle `fun main()` v modulu `lesson-03-conditions-start`.

Alternativně z terminálu (ze složky `session-01/`):
```bash
./gradlew :lesson-03-conditions-start:run
```

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

→ [Lesson 04 — Data Class](./lesson-04-README.md)
