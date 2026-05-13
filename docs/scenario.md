# 🏚️ Scenario: Escape the Cursed Mansion

In modern adventure games, inventory systems often contain different types of collectible objects such as weapons, treasures, keys, magical artifacts, and hidden rewards.

**Escape the Cursed Mansion** is a survival adventure game where the player explores dangerous rooms inside a haunted mansion while fighting enemies, collecting treasures, and searching for keys to escape.

Throughout the game, the player discovers many different objects, including:

### 🎮 **Individual Items**:
- Diamond
- Flashlight
- Hammer
- Ancient Coin

### 🎮 **Containers**:
- Wooden Chest
- Armor Bag
- Magic Pouch
- Secret Box

Some containers may also contain additional nested containers with valuable loot.

For example:
- Rare Chest
- Magic Pouch
- Secret Box
- Boss Scroll

The player’s inventory therefore becomes a **hierarchical structure** rather than a simple list.

---

## ⚠️ System Challenge

The system faces an important design challenge.

The inventory must support both:
- Single collectible items
- Containers holding multiple items

Additionally, containers may contain other containers recursively. Using traditional approaches would require separate handling logic for:
- Simple items
- Containers
- Nested containers

This would increase complexity and make inventory management difficult.

---

## 🚨 Key Issues

The problem becomes more noticeable when:
- Inventory depth increases
- Containers become nested
- Recursive item traversal is required
- Total value and power calculations are needed
- Inventory display becomes hierarchical

Without a proper structure, the system becomes difficult to maintain and extend.

---

## 💡 Proposed Solution

To solve these challenges, the system adopts the **Composite Pattern** to:
- Represent inventory as a tree structure
- Treat single items and containers uniformly
- Support recursive nested containers
- Simplify inventory operations

---

## 🏗️ Design Approach

The system applies the **Composite Pattern** using:
- **GameItem** as the Component
- **SimpleItem** as the Leaf
- **ItemContainer** as the Composite

This allows all inventory elements to be processed using the same interface.

---

## ✅ Outcome

Applying the **Composite Pattern** results in:
- Cleaner inventory management
- Flexible nested structures
- Recursive item processing
- Better scalability
- Easier future expansion

The final system becomes more organized, maintainable, and suitable for complex game inventories.