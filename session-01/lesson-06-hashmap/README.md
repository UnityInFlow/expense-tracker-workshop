# Lesson 06 — HashMap + Null Safety
## Mapa klíč→hodnota a null safety

---

## Cíl / Goal

Uložit výdaje do klíč→hodnota struktury a naučit se bezpečně pracovat s hodnotami které mohou být `null`.  
Store expenses in a key→value structure and handle nullable values safely.

Na konci lekce budeš mít in-memory "databázi" výdajů s rychlým vyhledáváním podle ID.

---

## Co je nové / What is new

| Konstrukt | Co dělá |
|---|---|
| `HashMap<K, V>()` | Klíč→hodnota mapa |
| `map[key] = value` | Vložení |
| `map[key]` | Čtení — vrátí `V?` (může být null!) |
| `map.remove(key)` | Smazání — vrátí smazaný objekt nebo null |
| `map.containsKey(key)` | Existence klíče |
| `map.values.toList()` | Všechny hodnoty jako List |
| `Type?` | Nullable typ — může obsahovat null |
| `?.` | Safe call — přistupuj jen pokud není null |
| `?:` | Elvis — výchozí hodnota pokud null |

---

## Kontext / Context

> List funguje skvěle pro iteraci.  
> Ale co když chceme rychle najít výdaj s ID 9999 z 10 000 výdajů?  
> List musí projít každý prvek — pomalé.  
>
> HashMap najde okamžitě — `database[9999]`.  
> Stejně rychlé pro 10 výdajů i pro 10 000.

**Analogie pro DevOps:**
- HashMap = ENV variables (KEY=VALUE, klíč je vždy unikátní)
- HashMap = Redis key→value store
- List = bash pole s číselným indexem

---

## Null safety — proč je důležitá

```
V Javě:
  database.get(999).getDescription()
  → NullPointerException za runtime → produkce padá

V Kotlinu:
  database[999]?.description
  → typový systém tě NUTÍ ošetřit null při kompilaci
  → chyba při psaní kódu, ne v produkci
```

---

## Zadání / Exercises

Otevři `start/Main.kt`:

1. Přidej 4 výdaje do `database` pomocí `database[id] = Expense(...)`

2. Vytiskni počet výdajů (`database.size`)

3. Načti výdaj s ID 2 a vytiskni jeho `description`  
   Použij `?.` (safe call) — MUSÍ fungovat i kdyby ID neexistovalo

4. Zkus načíst ID 999 (neexistuje)  
   Vytiskni `description` nebo `"Not found"` pokud null  
   Hint: `database[999]?.description ?: "Not found"`

5. Iteruj přes všechny výdaje: `for ((id, expense) in database)`  
   Formát: `"ID <id>: <description> — <amount> CZK"`

6. Smaž výdaj s ID 1, vytiskni počet znovu

7. **Bonus:** Spočítej sumu zbývajících výdajů  
   Hint: `database.values.sumOf { it.amount }`

---

## Kotlin Playground

> Nemáš IntelliJ? Cvičení můžeš udělat přímo v prohlížeči:

| | Link |
|---|---|
| Cvičení (start) | [Otevřít v Playground](https://play.kotlinlang.org/#eyJ2ZXJzaW9uIjogIjIuMS4wIiwgInBsYXRmb3JtIjogImphdmEiLCAiYXJncyI6ICIiLCAibm9uZU1hcmtlcnMiOiB0cnVlLCAidGhlbWUiOiAiaWRlYSIsICJjb2RlIjogImRhdGEgY2xhc3MgRXhwZW5zZShcbiAgICB2YWwgaWQ6IEludCxcbiAgICB2YWwgZGVzY3JpcHRpb246IFN0cmluZyxcbiAgICB2YWwgYW1vdW50OiBJbnQsXG4gICAgdmFsIGRhdGU6IFN0cmluZ1xuKVxuXG5mdW4gbWFpbigpIHtcbiAgICB2YWwgZGF0YWJhc2UgPSBIYXNoTWFwPEludCwgRXhwZW5zZT4oKVxuXG4gICAgLy8gVE9ETyAxOiBBZGQgNCBleHBlbnNlcyB0byBkYXRhYmFzZVxuICAgIC8vICAgZGF0YWJhc2VbMV0gPSBFeHBlbnNlKDEsIFwiTHVuY2hcIiwgMTUwLCBcIjIwMjQtMDEtMTVcIilcbiAgICAvLyAgIGRhdGFiYXNlWzJdID0gRXhwZW5zZSgyLCBcIkNvZmZlZVwiLCA1MCwgXCIyMDI0LTAxLTE1XCIpXG4gICAgLy8gICBkYXRhYmFzZVszXSA9IEV4cGVuc2UoMywgXCJNZXRyb1wiLCAzMiwgXCIyMDI0LTAxLTE2XCIpXG4gICAgLy8gICBkYXRhYmFzZVs0XSA9IEV4cGVuc2UoNCwgXCJUYXhpXCIsIDQ4MCwgXCIyMDI0LTAxLTE2XCIpXG5cbiAgICAvLyBUT0RPIDI6IFByaW50IGNvdW50OiBcIkNvdW50OiA8c2l6ZT5cIlxuXG4gICAgLy8gVE9ETyAzOiBMb2FkIGV4cGVuc2Ugd2l0aCBJRCAyLCBwcmludCBpdHMgZGVzY3JpcHRpb24gdXNpbmcgPy5cbiAgICAvLyAgIHZhbCBmb3VuZCA9IGRhdGFiYXNlWzJdXG4gICAgLy8gICBwcmludGxuKGZvdW5kPy5kZXNjcmlwdGlvbilcblxuICAgIC8vIFRPRE8gNDogTG9hZCBJRCA5OTksIHByaW50IGRlc2NyaXB0aW9uIG9yIFwiTm90IGZvdW5kXCIgdXNpbmcgPzpcbiAgICAvLyAgIHZhbCBtaXNzaW5nID0gZGF0YWJhc2VbOTk5XVxuICAgIC8vICAgcHJpbnRsbihtaXNzaW5nPy5kZXNjcmlwdGlvbiA/OiBcIk5vdCBmb3VuZFwiKVxuXG4gICAgLy8gVE9ETyA1OiBJdGVyYXRlIGFuZCBwcmludCBhbGw6XG4gICAgLy8gICBmb3IgKChpZCwgZXhwZW5zZSkgaW4gZGF0YWJhc2UpIHsgLi4uIH1cbiAgICBwcmludGxuKFwiXFxuPT09IEFsbCBleHBlbnNlcyA9PT1cIilcblxuICAgIC8vIFRPRE8gNjogRGVsZXRlIGV4cGVuc2Ugd2l0aCBJRCAxXG4gICAgLy8gICBkYXRhYmFzZS5yZW1vdmUoMSlcbiAgICAvLyAgIFByaW50OiBcIkFmdGVyIGRlbGV0ZTogPHNpemU+IGV4cGVuc2VzXCJcblxuICAgIC8vIEJPTlVTOiBDYWxjdWxhdGUgc3VtIG9mIHJlbWFpbmluZyBleHBlbnNlc1xuICAgIC8vICAgZGF0YWJhc2UudmFsdWVzLnN1bU9mIHsgaXQuYW1vdW50IH1cbn0ifQ==) |
| Řešení (finish) | [Otevřít v Playground](https://play.kotlinlang.org/#eyJ2ZXJzaW9uIjogIjIuMS4wIiwgInBsYXRmb3JtIjogImphdmEiLCAiYXJncyI6ICIiLCAibm9uZU1hcmtlcnMiOiB0cnVlLCAidGhlbWUiOiAiaWRlYSIsICJjb2RlIjogImRhdGEgY2xhc3MgRXhwZW5zZShcbiAgICB2YWwgaWQ6IEludCxcbiAgICB2YWwgZGVzY3JpcHRpb246IFN0cmluZyxcbiAgICB2YWwgYW1vdW50OiBJbnQsXG4gICAgdmFsIGRhdGU6IFN0cmluZ1xuKVxuXG5mdW4gbWFpbigpIHtcbiAgICB2YWwgZGF0YWJhc2UgPSBIYXNoTWFwPEludCwgRXhwZW5zZT4oKVxuXG4gICAgZGF0YWJhc2VbMV0gPSBFeHBlbnNlKDEsIFwiTHVuY2hcIiwgMTUwLCBcIjIwMjQtMDEtMTVcIilcbiAgICBkYXRhYmFzZVsyXSA9IEV4cGVuc2UoMiwgXCJDb2ZmZWVcIiwgNTAsIFwiMjAyNC0wMS0xNVwiKVxuICAgIGRhdGFiYXNlWzNdID0gRXhwZW5zZSgzLCBcIk1ldHJvXCIsIDMyLCBcIjIwMjQtMDEtMTZcIilcbiAgICBkYXRhYmFzZVs0XSA9IEV4cGVuc2UoNCwgXCJUYXhpXCIsIDQ4MCwgXCIyMDI0LTAxLTE2XCIpXG5cbiAgICBwcmludGxuKFwiQ291bnQ6ICR7ZGF0YWJhc2Uuc2l6ZX1cIilcblxuICAgIHZhbCBmb3VuZCA9IGRhdGFiYXNlWzJdXG4gICAgcHJpbnRsbihmb3VuZD8uZGVzY3JpcHRpb24pXG5cbiAgICB2YWwgbWlzc2luZyA9IGRhdGFiYXNlWzk5OV1cbiAgICBwcmludGxuKG1pc3Npbmc/LmRlc2NyaXB0aW9uID86IFwiTm90IGZvdW5kXCIpXG5cbiAgICBwcmludGxuKFwiXFxuPT09IEFsbCBleHBlbnNlcyA9PT1cIilcbiAgICBmb3IgKChpZCwgZXhwZW5zZSkgaW4gZGF0YWJhc2UpIHtcbiAgICAgICAgcHJpbnRsbihcIklEICRpZDogJHtleHBlbnNlLmRlc2NyaXB0aW9ufSBcdTIwMTQgJHtleHBlbnNlLmFtb3VudH0gQ1pLXCIpXG4gICAgfVxuXG4gICAgZGF0YWJhc2UucmVtb3ZlKDEpXG4gICAgcHJpbnRsbihcIkFmdGVyIGRlbGV0ZTogJHtkYXRhYmFzZS5zaXplfSBleHBlbnNlc1wiKVxuXG4gICAgdmFsIHRvdGFsID0gZGF0YWJhc2UudmFsdWVzLnN1bU9mIHsgaXQuYW1vdW50IH1cbiAgICBwcmludGxuKFwiVG90YWw6ICR0b3RhbCBDWktcIilcbn0ifQ==) |

---

## Spuštění / Running

Očekávaný výstup:
```
Count: 4
Coffee
Not found
=== All expenses ===
ID 1: Lunch — 150 CZK
ID 2: Coffee — 50 CZK
ID 3: Metro — 32 CZK
ID 4: Taxi — 480 CZK
After delete: 3 expenses
Total: 562 CZK
```

---

## Syntaxe / Syntax reference

```kotlin
val database = HashMap<Int, Expense>()
database[1] = Expense(1, "Lunch", 150, "2024-01-15")

val found = database[2]            // Expense? — může být null!
println(found?.description)        // safe call — "Coffee" nebo null
val name = found?.description ?: "Not found"   // elvis

for ((id, expense) in database) { ... }   // destrukturace klíče a hodnoty

database.remove(1)                 // smaže klíč 1
database.size                      // počet záznamů
database.containsKey(2)            // true/false
database.values.toList()           // všechny hodnoty jako List
```

---

## Klíčové poznatky / Key takeaways

- `HashMap` = klíč→hodnota, rychlé hledání — na rozdíl od Listu který prochází sekvenčně
- `database[id]` vrací `Expense?` (s otazníkem) — MUSÍ ošetřit null
- `?.` = "přistupuj jen pokud není null" — bez `?.` hrozí NullPointerException
- `?:` = "pokud null, použij tuto hodnotu"
- Null safety je jeden z nejdůležitějších konceptů Kotlinu — chrání produkci

---

## Dokumentace / Docs

- Map operations: https://kotlinlang.org/docs/map-operations.html
- Null safety: https://kotlinlang.org/docs/null-safety.html
- Safe calls: https://kotlinlang.org/docs/null-safety.html#safe-calls
- Elvis operator: https://kotlinlang.org/docs/null-safety.html#elvis-operator

---

## Další lekce / Next lesson

→ [Lesson 07 — Service Class](../lesson-07-service/)
