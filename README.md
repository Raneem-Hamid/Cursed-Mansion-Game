# 🏚️ Cursed Mansion Game

# 📦 Submission Files

## 📄 Documentation Files

| Document | Link |
|---|---|
| Scenario | [scenario.md](docs/scenario.md) |
| Problem Analysis | [problem-analysis.md](docs/problem-analysis.md) |
| Trade-offs | [trade-offs.md](docs/trade-offs.md) |
| Pattern Justification | [pattern-justification.md](docs/pattern-justification.md) |
| Code Implementation Explanation | [composite-pattern-code-implementation.md](docs/composite-pattern-code-implementation.md) |
| UML Description | [uml-description.md](docs/uml-description.md) |
| Contribution Log | [contribution-log.md](docs/ContributionLog.md) |

---

## 📊 UML Diagram

[Open UML Diagram](uml/UML.drawio.png)

---

## 🎞️ Presentation Slides

[Open Presentation](presentation/presentation.pdf)

---

## 🎥 Project Demo Video

[Watch Demo Video](presentation/video.md)

---

## 📋 GitHub Project Board

[Open GitHub Project Board](https://github.com/users/Raneem-Hamid/projects/5)

This board includes:

- Task management
- Workflow tracking
- Timeline organization
- Team progress monitoring

---

## 💻 Source Code

### Main Source Folder

[Open Source Code Folder](composite-implementation/EscapeTheCursedMansion/src/)


# 📌 Overview

**Escape the Cursed Mansion** is a Java-based horror survival adventure game.

The player explores a haunted mansion, fights enemies, collects loot, opens containers, and tries to survive until reaching the final boss.

The project demonstrates the use of the **Composite Design Pattern** to manage a flexible inventory system that can contain both simple items and nested containers.

---

# 🎯 Project Objective

The main objective of this project is to demonstrate the use of the **Composite Design Pattern** to:

- Manage simple items and containers uniformly
- Support nested inventory structures
- Improve code readability and maintainability
- Reduce duplicated inventory handling logic
- Make the system easier to extend in the future

---

# 🧠 Design Pattern Used

## ✅ Composite Pattern

This project applies the Composite Pattern in the inventory system.

### 🔹 Component

`GameItem`

Represents the common interface for all inventory elements.

### 🔹 Leaf

`SimpleItem`

Represents individual items that cannot contain other items.

#### Examples:

- Diamond
- Flashlight
- Hammer
- Ancient Coin

### 🔹 Composite

`ItemContainer`

Represents containers that can hold multiple `GameItem` objects.

#### Examples:

- Wooden Chest
- Armor Bag
- Magic Pouch
- Secret Box

---

# 🏗️ Project Structure

```text
Cursed-Mansion-Game/
│
├── composite-implementation/
│   └── EscapeTheCursedMansion/
│       ├── src/
│       │   ├── Colors.java
│       │   ├── Enemy.java
│       │   ├── EscapeTheCursedMansion.java
│       │   ├── GameItem.java
│       │   ├── GameRooms.java
│       │   ├── GameState.java
│       │   ├── ItemContainer.java
│       │   ├── Player.java
│       │   ├── SimpleItem.java
│       │   └── Weapon.java
│
├── docs/
│   ├── scenario.md
│   ├── problem-analysis.md
│   ├── trade-offs.md
│   ├── pattern-justification.md
│   ├── composite-pattern-code-implementation.md
│   ├── uml-description.md
│   └── contribution-log.md
│
├── uml/
│   └── escape-the-cursed-mansion-uml.png
│
├── presentation/
│   ├── final-presentation.pptx
│   └── demo-video.mp4
│
├── README.md
└── .gitignore
```

---

# ⚙️ Project Management

The project was organized and tracked using GitHub Project tools:

- Project Board

These tools were used to:

- Track progress
- Manage tasks
- Organize team workflow
- Ensure project completion

---

# 🚀 How to Run

1. Open the project in your IDE:
   - NetBeans
   - IntelliJ IDEA
   - Eclipse

2. Navigate to:

```text
composite-implementation/EscapeTheCursedMansion/src
```

3. Run:

```text
EscapeTheCursedMansion.java
```

---

# 👥 Team Members

- Raneem Hamid
- Rahaf Atmah
- Sidra Wali

---

# 🏁 Conclusion

This project demonstrates how the **Composite Pattern** can be applied in a game inventory system to improve:

- Code clarity
- Flexibility
- Scalability
- Maintainability

By treating simple items and containers through the same interface, the system becomes cleaner, more organized, and easier to expand.