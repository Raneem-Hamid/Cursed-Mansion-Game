/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package escapethecursedmansion;

/**
 *
 * @author Student
 */
public class Weapon {
    private String name;
    private int damage;
    private int durability;
    private int maxDurability;

    public Weapon(String name, int damage, int durability) {
        this.name = name;
        this.damage = damage;
        this.durability = durability;
        this.maxDurability = durability;
    }

    public String getName() {
        return name;
    }

    public boolean isBroken() {
        return durability <= 0;
    }

    public int attack() {
        if (isBroken()) {
            return 0;
        }

        durability -= 10;

        if (durability < 0) {
            durability = 0;
        }

        return damage;
    }

    public void showWeapon(int index) {
        String color = isBroken() ? Colors.RED : Colors.CYAN;

        System.out.println(color + index + "- " + name
                + " | Damage: " + damage
                + " | Durability: " + durabilityBar()
                + " " + durability + "/" + maxDurability
                + (isBroken() ? " [BROKEN]" : "")
                + Colors.RESET);
    }

    private String durabilityBar() {
        int bars = durability / 10;
        StringBuilder bar = new StringBuilder("[");

        for (int i = 0; i < 10; i++) {
            if (i < bars) {
                bar.append("#");
            } else {
                bar.append("-");
            }
        }

        bar.append("]");
        return bar.toString();
    }  
}
