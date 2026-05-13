# Composite Pattern Code Implementation

## Introduction
In this document, we will explain the code implementation of the Composite pattern used in the game "Escape the Cursed Mansion." The Composite pattern is designed to allow treating individual objects and compositions of objects uniformly. This document highlights the improvements in code structure, readability, and flexibility after applying the Composite pattern.

## Code Explanation

### Composite Pattern Overview
The Composite pattern allows objects to be composed into tree-like structures to represent part-whole hierarchies. In this game, the pattern is used to handle different game items (such as weapons, containers, enemies) in a uniform way.

### Structure of the Composite Pattern

1. **Component Interface**: 
   - `GameItem` is the base interface that declares the common methods like `getName()`, `getPower()`, `getValue()`, and `showDetails()`.
   - All game items (whether simple or composite) implement this interface.

2. **Leaf Class**:
   - `SimpleItem` is the class that represents individual items in the game. These are non-composite elements such as individual weapons or items.
   - `SimpleItem` implements the `GameItem` interface, providing methods for item details.

3. **Composite Class**:
   - `ItemContainer` is the composite class that can hold a collection of `GameItem` objects, which could either be `SimpleItem` or other `ItemContainer` instances.
   - `ItemContainer` implements the `GameItem` interface and provides methods to add items and retrieve item values.

### Code Implementation

- **GameItem Interface**:
    ```java
    public interface GameItem {
        String getName();
        int getPower();
        int getValue();
        void showDetails(String indent);
    }
    ```

- **SimpleItem Class**:
    ```java
    public class SimpleItem implements GameItem {
        private String name;
        private int power;
        private int value;
    
        public SimpleItem(String name, int power, int value) {
            this.name = name;
            this.power = power;
            this.value = value;
        }
    
        @Override
        public String getName() {
            return name;
        }
    
        @Override
        public int getPower() {
            return power;
        }
    
        @Override
        public int getValue() {
            return value;
        }
    
        @Override
        public void showDetails(String indent) {
            System.out.println(indent + "Item: " + name + ", Power: " + power + ", Value: " + value);
        }
    }
    ```

- **ItemContainer Class**:
    ```java
    public class ItemContainer implements GameItem {
        private String name;
        private List<GameItem> items = new ArrayList<>();
    
        public ItemContainer(String name) {
            this.name = name;
        }
    
        public void addItem(GameItem item) {
            items.add(item);
        }
    
        @Override
        public String getName() {
            return name;
        }
    
        @Override
        public int getPower() {
            int totalPower = 0;
            for (GameItem item : items) {
                totalPower += item.getPower();
            }
            return totalPower;
        }
    
        @Override
        public int getValue() {
            int totalValue = 0;
            for (GameItem item : items) {
                totalValue += item.getValue();
            }
            return totalValue;
        }
    
        @Override
        public void showDetails(String indent) {
            System.out.println(indent + "Container: " + name);
            for (GameItem item : items) {
                item.showDetails(indent + "  ");
            }
        }
    }
    ```

### Improvements After Applying the Composite Pattern

1. **Code Structure**:
   - The Composite pattern helps organize complex game items (such as weapons, containers, and enemies) into a clean hierarchical structure.
   - This makes the game logic easier to maintain and extend, especially when adding new types of game items.

2. **Readability**:
   - By treating individual and composite objects uniformly, the code becomes more readable and less error-prone.
   - Developers can now work with collections of game items without worrying about whether the item is simple or composite.

3. **Flexibility**:
   - The Composite pattern allows for flexible expansion. New types of game items (such as new containers or special weapons) can be added easily without modifying the existing codebase.

4. **Maintainability**:
   - As all objects (whether leaf or composite) implement the same `GameItem` interface, the system is easier to maintain, with changes in one part of the system not affecting others.

## Conclusion
The Composite pattern significantly improves the design and maintainability of the "Escape the Cursed Mansion" game by allowing for easy management of both simple and complex game items. It enhances the flexibility and scalability of the game by promoting uniform treatment of objects within part-whole hierarchies.
