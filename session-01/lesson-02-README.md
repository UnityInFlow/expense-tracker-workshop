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

Modul: `lesson-02-functions-start` — otevři `Main.kt` a implementuj:

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

## Kotlin Playground

> Nemáš IntelliJ? Cvičení můžeš udělat přímo v prohlížeči:

| | Link |
|---|---|
| Cvičení (start) | [Otevřít v Playground](https://play.kotlinlang.org/#eyJ2ZXJzaW9uIjogIjIuMS4wIiwgInBsYXRmb3JtIjogImphdmEiLCAiYXJncyI6ICIiLCAibm9uZU1hcmtlcnMiOiB0cnVlLCAidGhlbWUiOiAiaWRlYSIsICJjb2RlIjogIi8vIFRPRE8gMTogRGVmaW5lIGZ1bmN0aW9uIGZvcm1hdEV4cGVuc2UoZGVzY3JpcHRpb246IFN0cmluZywgYW1vdW50OiBJbnQpOiBTdHJpbmdcbi8vICAgUmV0dXJuczogXCIkZGVzY3JpcHRpb246ICRhbW91bnQgQ1pLXCJcblxuLy8gVE9ETyAyOiBEZWZpbmUgZnVuY3Rpb24gd2l0aFRheChhbW91bnQ6IEludCk6IEludFxuLy8gICBSZXR1cm5zOiAoYW1vdW50ICogMS4yMSkudG9JbnQoKVxuLy8gICBVc2Ugc2hvcnRoYW5kIHN5bnRheDogZnVuIHdpdGhUYXgoYW1vdW50OiBJbnQpOiBJbnQgPSAuLi5cblxuLy8gVE9ETyAzOiBEZWZpbmUgZnVuY3Rpb24gcHJpbnRFeHBlbnNlKGRlc2NyaXB0aW9uOiBTdHJpbmcsIGFtb3VudDogSW50KVxuLy8gICBQcmludHM6IFwiPj4+ICRkZXNjcmlwdGlvbjogJGFtb3VudCBDWktcIlxuLy8gICBObyByZXR1cm4gdmFsdWVcblxuLy8gQk9OVVM6IERlZmluZSBmdW5jdGlvbiBpc0V4cGVuc2l2ZShhbW91bnQ6IEludCk6IEJvb2xlYW5cbi8vICAgUmV0dXJucyB0cnVlIGlmIGFtb3VudCA+IDEwMFxuXG5mdW4gbWFpbigpIHtcbiAgICAvLyBUT0RPIDQ6IENhbGwgZm9ybWF0RXhwZW5zZShcIkx1bmNoXCIsIDE1MCkgYW5kIHByaW50IHRoZSByZXN1bHRcblxuICAgIC8vIFRPRE8gNTogQ2FsbCB3aXRoVGF4KDEwMCkgYW5kIHByaW50LCB0aGVuIHdpdGhUYXgoMjAwKSBhbmQgcHJpbnRcblxuICAgIC8vIFRPRE8gNjogQ2FsbCBwcmludEV4cGVuc2UoXCJDb2ZmZWVcIiwgNTApXG5cbiAgICAvLyBCT05VUzogUHJpbnQgaXNFeHBlbnNpdmUoMTUwKSBhbmQgaXNFeHBlbnNpdmUoNTApXG5cbiAgICAvLyBCT05VUzogUHJpbnQgZm9ybWF0RXhwZW5zZSB3aXRoIHdpdGhUYXggaW5zaWRlOlxuICAgIC8vICAgZm9ybWF0RXhwZW5zZShcIkx1bmNoXCIsIHdpdGhUYXgoMTUwKSlcbn0ifQ==) |
| Řešení (finish) | [Otevřít v Playground](https://play.kotlinlang.org/#eyJ2ZXJzaW9uIjogIjIuMS4wIiwgInBsYXRmb3JtIjogImphdmEiLCAiYXJncyI6ICIiLCAibm9uZU1hcmtlcnMiOiB0cnVlLCAidGhlbWUiOiAiaWRlYSIsICJjb2RlIjogImZ1biBmb3JtYXRFeHBlbnNlKGRlc2NyaXB0aW9uOiBTdHJpbmcsIGFtb3VudDogSW50KTogU3RyaW5nIHtcbiAgICByZXR1cm4gXCIkZGVzY3JpcHRpb246ICRhbW91bnQgQ1pLXCJcbn1cblxuZnVuIHdpdGhUYXgoYW1vdW50OiBJbnQpOiBJbnQgPSAoYW1vdW50ICogMS4yMSkudG9JbnQoKVxuXG5mdW4gcHJpbnRFeHBlbnNlKGRlc2NyaXB0aW9uOiBTdHJpbmcsIGFtb3VudDogSW50KSB7XG4gICAgcHJpbnRsbihcIj4+PiAkZGVzY3JpcHRpb246ICRhbW91bnQgQ1pLXCIpXG59XG5cbmZ1biBpc0V4cGVuc2l2ZShhbW91bnQ6IEludCk6IEJvb2xlYW4gPSBhbW91bnQgPiAxMDBcblxuZnVuIG1haW4oKSB7XG4gICAgcHJpbnRsbihmb3JtYXRFeHBlbnNlKFwiTHVuY2hcIiwgMTUwKSlcblxuICAgIHByaW50bG4od2l0aFRheCgxMDApKVxuICAgIHByaW50bG4od2l0aFRheCgyMDApKVxuXG4gICAgcHJpbnRFeHBlbnNlKFwiQ29mZmVlXCIsIDUwKVxuXG4gICAgcHJpbnRsbihpc0V4cGVuc2l2ZSgxNTApKVxuICAgIHByaW50bG4oaXNFeHBlbnNpdmUoNTApKVxuXG4gICAgcHJpbnRsbihmb3JtYXRFeHBlbnNlKFwiTHVuY2hcIiwgd2l0aFRheCgxNTApKSlcbn0ifQ==) |

---

## Spuštění / Running

V IntelliJ klikni na ▶ vedle `fun main()` v modulu `lesson-02-functions-start`.

Alternativně z terminálu (ze složky `session-01/`):
```bash
./gradlew :lesson-02-functions-start:run
```

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

→ [Lesson 03 — Conditions](./lesson-03-README.md)
