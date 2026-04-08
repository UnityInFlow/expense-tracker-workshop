# Setup Guide — Příprava prostředí
## Expense Tracker Workshop

> ⏱ Odhadovaný čas: **10–15 minut**  
> Prosím proveď tento návod **před** workshopem — na místě budeme rovnou programovat.

---

## Co potřebuješ / What you need

| Nástroj | Povinné? | K čemu |
|---|---|---|
| **IntelliJ IDEA** | ✅ ano | Editor kódu (IDE) — základní verze je zdarma |
| **JDK 24** | ❌ volitelné | IntelliJ ji stáhne za tebe automaticky |
| **Git** | ❌ volitelné | Repozitář můžeš stáhnout i jako ZIP |

---

## 🪟 Windows

### Krok 1 — IntelliJ IDEA

1. Jdi na https://www.jetbrains.com/idea/download/
2. Stáhni `.exe` installer

> ℹ️ Od verze 2025.3 existuje jen jedna verze IntelliJ IDEA (Community Edition už neexistuje). Po instalaci tě může vyzvat k 30denní trial Ultimate funkcí — to klidně přeskoč, základní (free) verze pro náš workshop stačí.

3. Spusť installer → při instalaci zaškrtni:
   - ✅ **Add "Open Folder as Project"**
   - ✅ **Add launchers dir to the PATH**
4. Spusť IntelliJ → při prvním startu zvol **"Do not import settings"**

---

### Krok 2 — Stažení repozitáře

**Varianta A — ZIP (pro začátečníky):**

1. Jdi na https://github.com/UnityInFlow/expense-tracker-workshop
2. Klikni zelené tlačítko **Code** → **Download ZIP**
3. Rozbal ZIP na disk

**Varianta B — přes Git (pro pokročilé):**

```bash
git clone https://github.com/UnityInFlow/expense-tracker-workshop.git
```

---

### Krok 3 — Otevření projektu

1. Spusť IntelliJ IDEA
2. **File → Open** → vyber složku `session-01/`
3. Klikni **OK** — IntelliJ stáhne Gradle závislosti (progress bar dole, ~1 min)
4. Pokud tě IntelliJ vyzve k nastavení JDK → vyber **Download JDK** → verze **24**
5. V levém panelu rozbal modul `lesson-01-variables-start` → otevři `src/main/kotlin/workshop/Main.kt`
6. Klikni na zelený ▶ vedle `fun main()`
7. V konzoli dole uvidíš výstup

✅ **Prostředí je připraveno!**

---

## 🍎 macOS

### Krok 1 — IntelliJ IDEA

**Možnost A — Homebrew:**
```bash
brew install --cask intellij-idea
```

**Možnost B — ruční:**
1. Jdi na https://www.jetbrains.com/idea/download/
2. Stáhni `.dmg`
3. Otevři `.dmg` → přetáhni do Applications

> ℹ️ Od verze 2025.3 existuje jen jedna verze IntelliJ IDEA — základní (free) verze pro náš workshop stačí. Trial Ultimate funkcí klidně přeskoč.

> ❓ Nevíš jaký máš procesor? Apple menu → "About This Mac" → Chip  
> Apple Silicon (M1/M2/M3/M4) → stáhni "Apple Silicon" verzi  
> Intel → stáhni "Intel" verzi

---

### Krok 2 — Stažení repozitáře

**Varianta A — ZIP (pro začátečníky):**

1. Jdi na https://github.com/UnityInFlow/expense-tracker-workshop
2. Klikni zelené tlačítko **Code** → **Download ZIP**
3. Rozbal ZIP na disk

**Varianta B — přes Git (pro pokročilé):**

Git je na macOS často předinstalovaný (`git --version`). Pokud ne, macOS nabídne instalaci Xcode Command Line Tools — potvrď.

```bash
git clone https://github.com/UnityInFlow/expense-tracker-workshop.git
```

---

### Krok 3 — Otevření projektu

V IntelliJ: **File → Open** → `session-01/`

Pokud tě IntelliJ vyzve k nastavení JDK → vyber **Download JDK** → verze **24**

✅ **Prostředí je připraveno!**

---

## 🐧 Linux (Ubuntu / Debian)

```bash
# IntelliJ přes Snap
sudo snap install intellij-idea --classic
```

Stažení repozitáře:

**Varianta A — ZIP:** stáhni z https://github.com/UnityInFlow/expense-tracker-workshop (Code → Download ZIP)

**Varianta B — Git:**
```bash
sudo apt-get install git
git clone https://github.com/UnityInFlow/expense-tracker-workshop.git
```

V IntelliJ: **File → Open** → `session-01/`

Pokud tě IntelliJ vyzve k nastavení JDK → vyber **Download JDK** → verze **24**

---

## ✅ Checklist před workshopem

```
[ ] IntelliJ IDEA nainstalována a spuštěna
[ ] Repozitář stažen (ZIP nebo git clone)
[ ] session-01/ otevřena v IntelliJ jako projekt
[ ] Main.kt v modulu lesson-01-variables-start nalezena a spustitelná (zelené ▶ tlačítko)
```

---

## 🛠 Časté problémy / Common Issues

### IntelliJ nezná JDK — "No JDK configured"

1. **File → Project Structure** (Ctrl+Alt+Shift+S)
2. **SDKs → + → Download JDK**
3. Vyber verzi **24** → libovolný vendor (např. Temurin)

---

### Gradle sync selže

```bash
# Ve složce projektu spusť:
./gradlew build
```

Pokud selže kvůli proxy/firewallu — napiš nám před workshopem.

---

### Chci mít Javu i v terminálu (volitelné)

IntelliJ stáhne JDK jen pro sebe. Pokud chceš `java` i v příkazové řádce:

**macOS / Linux:**
```bash
curl -s "https://get.sdkman.io" | bash
source "$HOME/.sdkman/bin/sdkman-init.sh"
sdk install java 24-tem
```

**Windows:**
1. Stáhni z https://adoptium.net/temurin/releases/?version=24
2. Spusť installer
3. Ověř: `java -version`

---

## 📚 Užitečné odkazy

| | URL |
|---|---|
| IntelliJ IDEA | https://www.jetbrains.com/idea/download/ |
| Kotlin Playground (záloha bez instalace) | https://play.kotlinlang.org |
| Repozitář workshopu | https://github.com/UnityInFlow/expense-tracker-workshop |

> 💬 Problém s instalací? Otevři issue v repozitáři.
