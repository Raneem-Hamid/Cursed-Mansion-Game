# Escape the Cursed Mansion — Composite Pattern Documentation

## 1. Overview

This project represents a Java-based game called **Escape the Cursed Mansion**.

The system uses multiple object-oriented concepts and applies the **Composite Design Pattern** to manage game items in a hierarchical structure.

The design allows the player inventory to contain both simple items and nested containers (chests, boxes, bags), forming a tree structure.

---

# 2. Main Classes in the System

## 2.1 GameItem (Interface)

Acts as the **Component** in the Composite Design Pattern.

It defines the common behavior for all items in the system, whether simple or composite.

### Methods

- `getName()`
- `getPower()`
- `getValue()`
- `showDetails(String indent)`

---

## 2.2 SimpleItem (Leaf)

Represents basic items that cannot contain other items.

These are individual collectible objects in the game.

### Examples

- Diamond
- Coin
- Ring
- Flashlight
- Hammer
- Keys (Rusty Key, Silver Key, Golden Key)
- Gems and other loot items

Implements `GameItem`.

---

## 2.3 ItemContainer (Composite)

Represents complex items that can hold multiple `GameItem` objects.

It supports nesting (a container inside another container), forming a tree structure.

### Examples

- Chest
- Bag
- Box
- Inventory
- Wooden Chest
- Metal Chest
- Magic Pouch

### Can contain

- `SimpleItem` (Leaf)
- `ItemContainer` (Composite)

Implements `GameItem`.

---

## 2.4 Player

Represents the user-controlled character in the game.

### Manages

- Health and armor system
- Weapons inventory
- Item inventory (Composite structure)

### Key Features

- Weapon selection and attack system
- Inventory display using tree structure
- Damage and healing system

---

## 2.5 Enemy

Represents enemies in the game with different difficulty levels.

### Attributes

- `name`
- `health`
- `attackPower`

### Behavior

- Can take damage
- Can attack player
- Has alive/dead state

---

## 2.6 Weapon

Represents combat tools used by the player.

### Features

- Damage-based attack system
- Durability system (breakable weapons)
- Different weapon types (Knife, Sword, Axe, Wand)

---

## 2.7 GameRooms

Represents interactive game locations.

### Rooms

- Dark Hall
- Library Room
- Storage Room
- Secret Room

### Each room

- Gives items using Composite structure
- Changes game state
- Unlocks progression

---

## 2.8 GameState

Stores global game progress.

### Contains

- Player health & fear
- Collected keys (flags)
- Global inventory (Composite root)

---

# 3. Relationships

- `SimpleItem` implements `GameItem` (**Leaf**)
- `ItemContainer` implements `GameItem` (**Composite**)
- `ItemContainer` contains a `List<GameItem>` (composition relationship)
- `Player` uses `ItemContainer` as inventory root
- `GameRooms` generate and add items into inventory
- `Enemy` interacts with `Player` during combat
- `Weapon` is used by `Player` for attacks

---

# 4. Design Pattern Used

## Composite Design Pattern

The system applies the Composite Pattern to manage game items.

### Structure

- **Component:** `GameItem`
- **Leaf:** `SimpleItem`
- **Composite:** `ItemContainer`

### Purpose

- Treats individual items and containers uniformly
- Supports nested inventory structure (tree)
- Makes the system scalable and flexible

---

# 5. Additional Design Concepts

- **Encapsulation:** used in all classes via private fields and getters
- **State Management:** handled by `GameState`
- **Randomized Combat:** implemented in enemy attack logic
- **Recursive Structure:** used in `ItemContainer.showDetails()`

---
