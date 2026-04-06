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
