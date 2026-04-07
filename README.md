# Expense Tracker Workshop
## Kotlin + Spring Boot for DevOps Engineers

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
│   ├── README.md                ← přehled session 1 / session 1 overview
│   ├── lesson-01-variables/
│   │   ├── README.md            ← zadání a cíle lekce / lesson brief & goals
│   │   ├── start/               ← tady začínáš / you start here
│   │   │   ├── build.gradle.kts
│   │   │   ├── settings.gradle.kts
│   │   │   └── src/main/kotlin/workshop/Main.kt   ← TODO cvičení
│   │   └── finish/              ← referenční řešení / reference solution
│   │       ├── build.gradle.kts
│   │       ├── settings.gradle.kts
│   │       └── src/main/kotlin/workshop/Main.kt   ← hotové řešení
│   ├── lesson-02-functions/
│   ├── lesson-03-conditions/
│   ├── lesson-04-data-class/
│   ├── lesson-05-collections/
│   ├── lesson-06-hashmap/
│   ├── lesson-07-service/
│   └── lesson-08-final/         ← kompletní Expense Tracker / complete tracker
│
└── session-02/                  ← Spring Boot REST API (4 hours) — coming soon
```

---

## Jak repozitář používat / How to use this repo

### Před workshopem / Before the workshop

1. Nainstaluj prostředí podle → [SETUP.md](./SETUP.md)
2. Naklonuj repozitář:
   ```bash
   git clone https://github.com/YOUR_ORG/expense-tracker-workshop.git
   ```
3. Otevři složku `session-01/lesson-01-variables/start/` v IntelliJ IDEA

### Během workshopu / During the workshop

1. Otevři `start/` složku aktuální lekce v IntelliJ (**File → Open**)
2. Počkej na Gradle sync (progress bar dole)
3. Otevři `src/main/kotlin/workshop/Main.kt`
4. Vyplň sekce označené `// TODO`
5. Spusť zeleným ▶ tlačítkem vedle `fun main()`

Zasekl ses? Otevři `finish/` složku stejné lekce — je tam kompletní řešení.

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

> Přijde brzy / Coming soon

Session 2 vezme `ExpenseService` z lekce 07/08 a vystaví ji jako HTTP REST API pomocí Spring Boot.  
Session 2 takes the `ExpenseService` from lesson 07/08 and exposes it as an HTTP REST API using Spring Boot.

```
Session 1 výsledek:          Session 2 výsledek:
service.add("Lunch", 150)    POST /expenses {"description":"Lunch","amount":150}
service.getAll()             GET  /expenses → [{"id":1,...}]
service.delete(1)            DELETE /expenses/1
```

---

## Zdroje / Resources

| Téma | Odkaz |
|---|---|
| Kotlin dokumentace | https://kotlinlang.org/docs/home.html |
| Kotlin tour (interaktivní) | https://kotlinlang.org/docs/kotlin-tour-hello-world.html |
| Kotlin Koans (cvičení) | https://play.kotlinlang.org/koans |
| Spring Boot guides | https://spring.io/guides |
| Baeldung Kotlin | https://www.baeldung.com/kotlin |
