# Session 01 — Kotlin Foundations
## Základy Kotlinu pro DevOps inženýry

---

## Cíl session / Session goal

Na konci session 1 budeš umět:

- číst Kotlin kód a rozumět co dělá
- napsat jednoduché funkce a datové modely
- postavit in-memory Expense Tracker s CRUD operacemi

Tohle je základ pro Session 2, kde stejnou logiku vystavíme jako HTTP REST API.

---

## Jak lekce fungují / How lessons work

Celý `session-01/` je jeden Gradle multi-module projekt. Každá lekce má dva moduly:

```
session-01/                         ← otevři tuto složku v IntelliJ
├── build.gradle.kts                ← společná konfigurace
├── settings.gradle.kts             ← definice všech modulů
├── gradlew                         ← Gradle wrapper
├── lesson-XX-README.md             ← zadání, cíle, tipy — přečti si první
├── lesson-XX-topic-start/          ← tady začínáš, soubor s TODO komentáři
│   └── src/main/kotlin/workshop/
└── lesson-XX-topic-finish/         ← referenční řešení pokud se zasekneš
    └── src/main/kotlin/workshop/
```

**Postup:**
1. Otevři `session-01/` v IntelliJ (**File → Open**) — stačí jednou, na začátku
2. Přečti `lesson-XX-README.md` aktuální lekce
3. Rozbal modul `lesson-XX-topic-start` v levém panelu
4. Otevři `Main.kt` a vyplň `// TODO` sekce
5. Spusť ▶ a ověř výstup
6. Zasekl ses? Podívej se do modulu `lesson-XX-topic-finish`

---

## Přehled lekcí / Lesson overview

| # | Lekce | Nový koncept | Výstup |
|---|---|---|---|
| 01 | [Variables](./lesson-01-README.md) | `val`, `var`, typy, string templates | Vytisknutý výdaj |
| 02 | [Functions](./lesson-02-README.md) | `fun`, parametry, návratové typy | Formátovací funkce |
| 03 | [Conditions](./lesson-03-README.md) | `if`/`else`, `when` | Kategorizace výdajů |
| 04 | [Data Class](./lesson-04-README.md) | `data class`, instance, `toString()` | Model `Expense` |
| 05 | [Collections](./lesson-05-README.md) | `listOf`, `for`, `forEach`, `filter` | Práce se seznamem výdajů |
| 06 | [HashMap](./lesson-06-README.md) | `HashMap`, `?.`, `?:` | In-memory databáze |
| 07 | [Service](./lesson-07-README.md) | `class`, `private` | `ExpenseService` s CRUD |
| 08 | [Final](./lesson-08-README.md) | Vše dohromady | Kompletní Expense Tracker |

---

## Červená nit / Red thread

Každá lekce odpovídá na otázku: **"Co nám chybí aby Expense Tracker fungoval?"**

```
Lekce 01: Jak uložím jméno výdaje a částku?        → val/var
Lekce 02: Jak pojmenuji opakovanou akci?            → fun
Lekce 03: Jak rozhodnu jestli je výdaj drahý?      → if/when
Lekce 04: Jak skupinu příbuzných hodnot pohromadě? → data class
Lekce 05: Jak pracuji s více výdaji najednou?      → collections
Lekce 06: Jak rychle najdu výdaj podle ID?         → HashMap
Lekce 07: Kde bude logika správy výdajů?           → class/service
Lekce 08: Jak to vše spojím?                       → final tracker
```

---

## Bridge do Session 2

Po dokončení session 1 máš:
```kotlin
val service = ExpenseService()
service.add("Lunch", 150)
service.getAll()      // [Expense(1, "Lunch", 150, ...)]
service.total()       // 150
service.delete(1)     // true
```

V Session 2 to rozšíříme na:
```bash
curl -X POST /expenses -d '{"description":"Lunch","amount":150}'
curl GET /expenses
curl -X DELETE /expenses/1
```

Stejná logika, HTTP vrstva přidaná Spring Bootem.  
`ExpenseService` se nezmění ani řádek.
