# ✔️ Design Pattern Justification

# Why Composite Pattern Was Selected

The Composite Pattern was selected because the system needs to manage both individual game items and groups of items using the same structure and behavior.

In the **Escape the Cursed Mansion** game, the inventory system contains:

### Single items such as:

- Diamond
- Hammer
- Flashlight
- Ancient Coin

### Containers that can hold other items such as:

- Wooden Chest
- Magic Pouch
- Metal Chest
- Secret Box

Some containers also contain other containers, creating a hierarchical tree structure.

### Example Structure

- Rare Chest
  - Magic Pouch
    - Secret Box
      - Boss Scroll

This structure perfectly matches the intent of the **Composite Pattern**:

> Treating individual objects and groups of objects uniformly.

---

# 🧩 How the Pattern Appears in the System

## 1. GameItem Interface (Component)

The `GameItem` interface represents the common abstraction shared by all inventory elements.

It defines shared operations such as:

- `getName()`
- `getPower()`
- `getValue()`
- `showDetails()`

Both simple items and containers implement this interface.

This allows the system to treat all game elements consistently.

---

## 2. SimpleItem Class (Leaf)

The `SimpleItem` class represents individual objects that do not contain child elements.

### Examples

- Diamond
- Hammer
- Flashlight
- Silver Ring

Leaf objects provide direct implementations for all operations defined in `GameItem`.

---

## 3. ItemContainer Class (Composite)

The `ItemContainer` class represents containers capable of storing multiple `GameItem` objects.

### Examples

- Wooden Chest
- Armor Bag
- Magic Pouch
- Secret Box

A container may hold:

- Simple items
- Other containers

The composite object recursively calculates:

- Total value
- Total power
- Inventory display hierarchy

This creates a flexible recursive inventory structure.

---

# ✔️ Why Composite Fits This Problem

The main design challenge was managing nested inventory structures without creating separate handling logic for each type.

The system needed:

- Support for single items and grouped items
- Recursive nested containers
- Unified inventory operations
- Expandable inventory hierarchy

Using Composite solved these challenges by:

- Providing a common interface
- Simplifying recursive structures
- Reducing duplicated logic
- Making inventory traversal easier

---

# ❌ Why Other Patterns Were Not Suitable

## Builder Pattern

Builder focuses on constructing complex objects step-by-step.

The problem here is not object construction, but hierarchical object organization.

---

## Factory Pattern

Factory is used to decide which object to create.

It does not solve recursive tree structures or nested containers.

---

## Singleton Pattern

Singleton ensures only one instance exists.

This is unrelated to inventory hierarchy management.

---

## Strategy Pattern

Strategy changes behavior dynamically.

The issue here is structural composition, not behavior variation.

---

# 🎯 Design Decision Insight

The key system challenge was representing game inventory in a flexible tree-like structure.

The inventory needed to support:

- Items inside containers
- Containers inside containers
- Uniform processing for all elements

The Composite Pattern provided a clean recursive solution where:

- `SimpleItem` acts as a **Leaf**
- `ItemContainer` acts as a **Composite**
- `GameItem` acts as the **Component**

This keeps the design scalable and easy to extend.

---

# ✅ Conclusion

The Composite Pattern was selected because it provides:

- A hierarchical tree structure
- Uniform treatment of objects and groups
- Recursive inventory management
- High flexibility for future extensions

By applying Composite, the system achieves:

- Better maintainability
- Cleaner inventory logic
- Reduced code duplication
- Scalable game item organization

---
