⚠️ Problem Analysis: Traditional Inventory Structure Issues

📌 Overview  
Before applying the Composite Pattern, the inventory system relied on traditional object handling approaches.  
This created several structural and maintainability problems when managing game items and containers.

❌ Separate Handling Logic  
The system contains:  
- Simple items  
- Containers  
- Nested containers  

Without Composite, each type requires different processing logic.  
For example:  
- Simple items need direct display  
- Containers need loops for child items  
- Nested containers require recursive traversal  
This increases system complexity.

❌ Poor Scalability  
As the game grows, more container levels may be added.  
For example:  
Chest → Pouch → Box → Secret Container  
Traditional approaches become difficult to manage because each nesting level introduces additional logic complexity.

❌ Code Duplication  
Without a unified structure, inventory operations such as:  
- Showing details  
- Calculating total value  
- Calculating total power  
must be repeated for different object types.  
This leads to duplicated code and poor maintainability.

❌ Difficult Recursive Traversal  
The inventory behaves naturally as a tree structure.  
Traditional flat structures cannot efficiently support:  
- Recursive searching  
- Nested inventory traversal  
- Uniform processing  
This makes the system harder to extend.

❌ Inconsistent Inventory Management  
Without a shared abstraction, the system cannot treat:  
- Single items  
- Groups of items  
the same way.  
Different methods and conditions become necessary for each object type.  
This reduces design clarity.

🎯 Summary  
The traditional inventory management approach results in:  
- High structural complexity  
- Difficult recursive handling  
- Poor scalability  
- Code duplication  
- Reduced maintainability  

These limitations highlight the need for a recursive hierarchical design solution, which is solved using the Composite Pattern.