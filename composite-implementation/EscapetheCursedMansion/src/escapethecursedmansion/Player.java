/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package escapethecursedmansion;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Student
 */
public class Player {
    private int health = 120;
    private int armor = 40;

    private List<Weapon> weapons = new ArrayList<>();
    private ItemContainer inventory = new ItemContainer("Player Inventory");

    public Player() {
        weapons.add(new Weapon("Knife", 10, 999));
        weapons.add(new Weapon("Iron Sword", 25, 60));
        weapons.add(new Weapon("Fire Axe", 40, 40));
        weapons.add(new Weapon("Magic Wand", 60, 30));
    }

    public int getHealth() {
        return health;
    }

    public int getArmor() {
        return armor;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public void takeDamage(int damage) {
        if (armor > 0) {
            int absorbed = Math.min(armor, damage);
            armor -= absorbed;
            damage -= absorbed;
        }

        health -= damage;

        if (health < 0) {
            health = 0;
        }
    }

    public void heal(int amount) {
        health += amount;

        if (health > 120) {
            health = 120;
        }
    }

    public void addArmor(int amount) {
        armor += amount;
    }

    public void showStatus() {
        System.out.println(Colors.GREEN + "Player HP: " + health + "/120" + Colors.RESET);
        System.out.println(Colors.BLUE + "Armor: " + armor + Colors.RESET);
    }

    public void showWeapons() {
        System.out.println(Colors.YELLOW + "\nChoose your weapon:" + Colors.RESET);

        for (int i = 0; i < weapons.size(); i++) {
            weapons.get(i).showWeapon(i + 1);
        }
    }

    public Weapon getWeapon(int index) {
        if (index < 1 || index > weapons.size()) {
            return null;
        }

        return weapons.get(index - 1);
    }

    public void addItem(GameItem item) {
        inventory.addItem(item);
    }

    public void showInventory() {
        System.out.println(Colors.PURPLE + "\n===== INVENTORY TREE =====" + Colors.RESET);
        inventory.showDetails("");
        System.out.println(Colors.YELLOW + "Total Loot Value: " +
                inventory.getValue() + " coins" + Colors.RESET);
    }
}
