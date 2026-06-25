# Expense Tracker Workshop
## Kotlin + Spring Boot pro DevOps i analytiky / for DevOps & Analysts

---

## Co je cílem / What is the goal

Za dvě session postavíte funkční Expense Tracker API v Kotlinu a Spring Boot.  
Nepředpokládáme žádné zkušenosti s programováním — jen zvědavost.

In two sessions you will build a working Expense Tracker API in Kotlin and Spring Boot.  
No prior programming experience assumed — just curiosity.

---

## Struktura repozitáře / Repository structure

```
expense-tracker-workshop/
│
├── README.md                    ← tento soubor / this file
├── SETUP.md                     ← instalace prostředí / environment setup
├── CHEATSHEET.md                ← rychlý přehled Kotlin syntaxe / quick syntax reference
│
├── session-01/                  ← Kotlin základy / Kotlin basics (4 hours)
│   ├── build.gradle.kts         ← jeden Gradle projekt / one Gradle project
│   ├── settings.gradle.kts      ← definice všech modulů / all modules defined here
│   ├── pom.xml                  ← Maven alternativa / Maven alternative
│   ├── gradlew                  ← Gradle wrapper
│   ├── README.md                ← přehled session 1 / session 1 overview
│   ├── lesson-01-README.md      ← zadání a cíle lekce / lesson brief & goals
│   ├── lesson-01-variables-start/    ← tady začínáš / you start here
│   │   └── src/main/kotlin/workshop/Main.kt   ← TODO cvičení
│   ├── lesson-01-variables-finish/   ← referenční řešení / reference solution
│   │   └── src/main/kotlin/workshop/Main.kt   ← hotové řešení
│   ├── lesson-02-functions-start/
│   ├── lesson-02-functions-finish/
│   ├── ...
│   └── lesson-08-final-finish/  ← kompletní Expense Tracker / complete tracker
│
└── session-02/                  ← SQLite + Repository + Validation (4 hours)
    ├── README.md                ← přehled session 2 / session 2 overview
    ├── SETUP.md                 ← instalace prostředí / environment setup
    ├── step-01-start/           ← tady začínáš / you start here (TODO stubs)
    │   └── (samostatný Maven projekt / standalone Maven project)
    ├── step-01-final/           ← referenční řešení / reference solution
    ├── step-02-start/
    ├── step-02-final/
    ├── ...
    └── step-07-final/           ← produkční API + Swagger / production API + Swagger
```

> Pozn.: každý krok session 2 je **samostatný Maven projekt** s dvojicí
> `step-NN-start` (TODO) + `step-NN-final` (řešení) — jiné uspořádání než
> session 1, kde lekce sdílejí jeden Gradle/Maven build.
> Note: each Session 2 step is a **standalone Maven project** with a
> `step-NN-start` (TODO) + `step-NN-final` (solution) pair — a different layout
> from Session 1, where the lessons share a single Gradle/Maven build.

---

## Jak repozitář používat / How to use this repo

### Před workshopem / Before the workshop

1. Nainstaluj prostředí podle → [SETUP.md](./SETUP.md)
2. Naklonuj repozitář:
   ```bash
   git clone https://github.com/UnityInFlow/expense-tracker-workshop.git
   ```
3. Otevři složku `session-01/` v IntelliJ IDEA

### Během workshopu / During the workshop

1. Otevři složku `session-01/` v IntelliJ (**File → Open**) — jeden projekt pro všechny lekce
2. Počkej na Gradle sync (progress bar dole)
3. Rozbal modul aktuální lekce (např. `lesson-01-variables-start`) v levém panelu
4. Otevři `src/main/kotlin/workshop/Main.kt`
5. Vyplň sekce označené `// TODO`
6. Spusť zeleným ▶ tlačítkem vedle `fun main()`

Zasekl ses? Podívej se do `-finish` modulu stejné lekce — je tam kompletní řešení.

**Session 2:** každý krok je vlastní Maven projekt. Otevři jednotlivé složky
`session-02/step-NN-start` (**File → Open**), vyplň `// TODO` a spusť
`./mvnw spring-boot:run`. Řešení je vždy v `step-NN-final`.

**Session 2:** each step is its own Maven project. Open the individual
`session-02/step-NN-start` folders (**File → Open**), fill in the `// TODO`s and
run `./mvnw spring-boot:run`. The solution lives in `step-NN-final`.

### After the workshop

Cheatsheet se všemi konstrukty: [CHEATSHEET.md](./CHEATSHEET.md)

---

## Session 1 — přehled lekcí / lesson overview

| Lekce | Téma | Nové konstrukty | Čas |
|---|---|---|---|
| 01 | Proměnné a typy | `val`, `var`, `String`, `Int`, `Boolean`, string templates | 35 min |
| 02 | Funkce | `fun`, parametry, návratové typy | 30 min |
| 03 | Podmínky | `if`/`else`, `when` | 30 min |
| 04 | Datový model | `data class`, instance, `toString()` | 40 min |
| 05 | Kolekce | `listOf`, `for`, `forEach`, `filter`, `sumOf` | 25 min |
| 06 | HashMap + null safety | `HashMap`, `?.`, `?:` | 40 min |
| 07 | Service třída | `class`, `private`, zapouzdření | 50 min |
| 08 | Vše dohromady | Kompletní Expense Tracker | 20 min |

---

## Session 2 — přehled / overview

**SQLite + Repository + Validation.** Session 2 vezme API z prvního workshopu a
přidá databázi SQLite, Repository vrstvu, validaci a ošetření chyb — data nakonec
přežijí restart. Controller se přitom nezmění ani o řádek.

**SQLite + Repository + Validation.** Session 2 takes the API from the first
workshop and adds a SQLite database, a Repository layer, validation and error
handling — until data finally survives a restart. The Controller does not change
a single line.

| Krok / Step | Téma / Topic | Co stavíme / What we build |
|---|---|---|
| 1 | SQLite setup a schéma / SQLite setup & schema | soubor `expenses.db` na disku / `expenses.db` file on disk |
| 2 | Repository: INSERT a SELECT | `ExpenseRepository` s `JdbcTemplate` |
| 3 | Repository: DELETE a findById | kompletní CRUD Repository / complete CRUD Repository |
| 4 | Service → Repository | data přežijí restart! / data survives a restart! |
| 5 | Validace requestu `@Valid` / Request validation `@Valid` | API odmítá nevalidní data / API rejects invalid data |
| 6 | Ošetření chyb / Error handling (`@RestControllerAdvice`) | konzistentní chybové odpovědi / consistent error responses |
| 7 | OpenAPI finalizace / OpenAPI finalization | produkční Swagger dokumentace / production Swagger docs |

Každý krok má dvojici **start** (TODO zadání) a **final** (hotové řešení).  
Each step has a **start** (TODO tasks) and **final** (complete solution) pair.

Krok / step se sestaví a spustí přes `./mvnw spring-boot:run`; API a Swagger UI
běží na `http://localhost:8080/swagger-ui/index.html`.  
Build and run a step with `./mvnw spring-boot:run`; the API and Swagger UI are at
`http://localhost:8080/swagger-ui/index.html`.

```
Session 1 výsledek:          Session 2 výsledek:
service.add("Lunch", 150)    POST /expenses {"description":"Lunch","amount":150}
service.getAll()             GET  /expenses → [{"id":1,...}]
service.delete(1)            DELETE /expenses/1
```

Detailní přehled session 2 / Full Session 2 overview: [session-02/README.md](./session-02/README.md)

---

## Zdroje / Resources

| Téma | Odkaz |
|---|---|
| Kotlin dokumentace | https://kotlinlang.org/docs/home.html |
| Kotlin tour (interaktivní) | https://kotlinlang.org/docs/kotlin-tour-hello-world.html |
| Kotlin Koans (cvičení) | https://play.kotlinlang.org/koans |
| Spring Boot guides | https://spring.io/guides |
| Baeldung Kotlin | https://www.baeldung.com/kotlin |
