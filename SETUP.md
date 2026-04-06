# Setup Guide — Příprava prostředí
## Expense Tracker Workshop

> ⏱ Odhadovaný čas: **15–20 minut**  
> Prosím proveď tento návod **před** workshopem — na místě budeme rovnou programovat.

---

## Co nainstaluješ / What you will install

| Nástroj | Verze | K čemu |
|---|---|---|
| **JDK 21** | 21 LTS | Runtime pro Kotlin — bez toho kód nespustíme |
| **IntelliJ IDEA Community** | nejnovější | Editor kódu (IDE) — zdarma |
| **Git** | nejnovější | Stažení repozitáře |

---

## 🪟 Windows

### Krok 1 — JDK 21

1. Jdi na https://adoptium.net/
2. Klikni **"Latest LTS Release"** — ujisti se že je vybráno **Temurin 21**
3. Stáhni `.msi` installer (Windows x64)
4. Spusť installer → Next → Next → Finish
5. Ověř v **Command Prompt** (Win+R → `cmd`):
   ```
   java -version
   ```
   Očekávaný výstup: `openjdk version "21.x.x"`

---

### Krok 2 — IntelliJ IDEA Community Edition

1. Jdi na https://www.jetbrains.com/idea/download/
2. Scrolluj dolů na **"IntelliJ IDEA Community Edition"** — je zdarma
3. Stáhni `.exe` installer
4. Při instalaci zaškrtni:
   - ✅ **Add "Open Folder as Project"**
   - ✅ **Add launchers dir to the PATH**
5. Spusť IntelliJ → při prvním startu zvol **"Do not import settings"**

> ⚠️ Nevybírej **Ultimate** — ta je placená. Community Edition je zdarma a pro workshop plně dostačuje.

---

### Krok 3 — Git

1. Jdi na https://git-scm.com/download/win
2. Stáhni a nainstaluj — všechna výchozí nastavení jsou OK
3. Ověř:
   ```
   git --version
   ```

---

### Krok 4 — Klonování repozitáře

Otevři **Command Prompt** nebo **Git Bash**:
```bash
git clone https://github.com/YOUR_ORG/expense-tracker-workshop.git
```

---

### Krok 5 — Otevření projektu

1. Spusť IntelliJ IDEA
2. **File → Open** → vyber složku `session-01/lesson-01-variables/start/`
3. Klikni **OK** — IntelliJ stáhne Gradle závislosti (progress bar dole, ~1 min)
4. Otevři `src/main/kotlin/workshop/Main.kt`
5. Klikni na zelený ▶ vedle `fun main()`
6. V konzoli dole uvidíš výstup

✅ **Prostředí je připraveno!**

---

## 🍎 macOS

### Krok 1 — JDK 21

**Možnost A — Homebrew (doporučeno):**
```bash
brew install --cask temurin@21
```

**Možnost B — ruční instalace:**
1. Jdi na https://adoptium.net/
2. Stáhni **Temurin 21** → macOS → `.pkg`
3. Spusť `.pkg` a projdi instalací

Ověř:
```bash
java -version
```

---

### Krok 2 — IntelliJ IDEA Community

**Možnost A — Homebrew:**
```bash
brew install --cask intellij-idea-ce
```

**Možnost B — ruční:**
1. Jdi na https://www.jetbrains.com/idea/download/
2. Stáhni **Community Edition** → macOS
3. Otevři `.dmg` → přetáhni do Applications

> ❓ Nevíš jaký máš procesor? Apple menu → "About This Mac" → Chip  
> Apple Silicon (M1/M2/M3) → stáhni "Apple Silicon" verzi  
> Intel → stáhni "Intel" verzi

---

### Krok 3 — Git

Git je na macOS často předinstalovaný:
```bash
git --version
```
Pokud ne, macOS nabídne instalaci Xcode Command Line Tools — potvrď.

---

### Krok 4 — Klonování a otevření

```bash
git clone https://github.com/YOUR_ORG/expense-tracker-workshop.git
```

V IntelliJ: **File → Open** → `session-01/lesson-01-variables/start/`

✅ **Prostředí je připraveno!**

---

## 🐧 Linux (Ubuntu / Debian)

```bash
# JDK 21
sudo apt-get update
sudo apt-get install temurin-21-jdk

# Git
sudo apt-get install git

# IntelliJ přes Snap
sudo snap install intellij-idea-community --classic

# Ověření
java -version
git --version
```

Klonování:
```bash
git clone https://github.com/YOUR_ORG/expense-tracker-workshop.git
```

---

## ✅ Checklist před workshopem

```
[ ] java -version  →  openjdk version "21.x.x"
[ ] git --version  →  git version 2.x.x
[ ] IntelliJ IDEA Community spuštěna
[ ] Repozitář naklonován
[ ] lesson-01-variables/start/ otevřena v IntelliJ
[ ] Main.kt nalezena a spustitelná (zelené ▶ tlačítko)
```

---

## 🛠 Časté problémy / Common Issues

### "java is not recognized" (Windows)

Java se nepřidala do PATH. Řešení:
1. Start menu → hledej "Environment Variables"
2. System Variables → `Path` → Edit → New
3. Přidej: `C:\Program Files\Eclipse Adoptium\jdk-21.x.x\bin`
4. Restartuj Command Prompt

📖 https://www.baeldung.com/java-home-on-windows-7-8-10-mac-os-x-linux

---

### IntelliJ nezná JDK — "No JDK configured"

1. **File → Project Structure** (Ctrl+Alt+Shift+S)
2. **SDK → + → Add JDK**
3. Naviguj do složky JDK:
   - Windows: `C:\Program Files\Eclipse Adoptium\jdk-21.x.x`
   - macOS: `/Library/Java/JavaVirtualMachines/temurin-21.jdk/Contents/Home`
   - Linux: `/usr/lib/jvm/temurin-21`

📖 https://www.jetbrains.com/help/idea/sdk.html

---

### Gradle sync selže

```bash
# Ve složce projektu spusť:
./gradlew build
```

Pokud selže kvůli proxy/firewallu — napiš nám před workshopem.

---

## 📚 Užitečné odkazy

| | URL |
|---|---|
| Eclipse Temurin JDK 21 | https://adoptium.net/ |
| IntelliJ IDEA Community | https://www.jetbrains.com/idea/download/ |
| Git | https://git-scm.com/downloads |
| Kotlin Playground (záloha bez instalace) | https://play.kotlinlang.org |
| Repozitář workshopu | https://github.com/YOUR_ORG/expense-tracker-workshop |

> 💬 Problém s instalací? Napiš nám na [email] nebo otevři issue v repozitáři.
