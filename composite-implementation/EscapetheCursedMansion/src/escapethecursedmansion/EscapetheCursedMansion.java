/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package escapethecursedmansion;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Student
 */
public class EscapetheCursedMansion {

       static Scanner input = new Scanner(System.in);
    static Random random = new Random();

    static Player player = new Player();

    public static void main(String[] args) {

        intro();

        Enemy[] enemies = {

                new Enemy("Shadow Rat", 45, 10),

                new Enemy("Dark Zombie", 85, 16),

                new Enemy("Cursed Knight", 140, 23),

                new Enemy("Shadow King - Final Boss", 230, 32)
        };

        for (int level = 0; level < enemies.length; level++) {

            Enemy enemy = enemies[level];

            System.out.println(
                    Colors.PURPLE +
                    "\n====================================" +
                    Colors.RESET
            );

            System.out.println(
                    Colors.RED +
                    "LEVEL " + (level + 1) +
                    ": " + enemy.getName() +
                    Colors.RESET
            );

            System.out.println(
                    Colors.PURPLE +
                    "====================================" +
                    Colors.RESET
            );

            fight(enemy, level + 1);

            if (!player.isAlive()) {

                System.out.println(
                        Colors.RED +
                        "\nGAME OVER! The mansion consumed you..." +
                        Colors.RESET
                );

                return;
            }

            if (level < enemies.length - 1) {

                giveReward(level + 1);
            }
        }

        ending();
    }

    static void intro() {

        System.out.println(
                Colors.PURPLE +
                "====================================" +
                Colors.RESET
        );

        System.out.println(
                Colors.CYAN +
                "       SHADOW ESCAPE - SEASON 1      " +
                Colors.RESET
        );

        System.out.println(
                Colors.PURPLE +
                "====================================" +
                Colors.RESET
        );

        System.out.println("You are trapped inside a cursed mansion.");
        System.out.println("Defeat all monsters and survive.");
        System.out.println("Use your weapons wisely.");
        System.out.println("Strong weapons break faster.");
        System.out.println();
    }

    static void fight(Enemy enemy, int level) {

        while (enemy.isAlive() && player.isAlive()) {

            System.out.println();

            player.showStatus();

            System.out.println(
                    Colors.RED +
                    "\nEnemy: " + enemy.getName() +
                    " | HP: " + enemy.getHealth() +
                    Colors.RESET
            );

            System.out.println("\n1- Attack");
            System.out.println("2- Check Inventory");
            System.out.println("3- Rest (+10 HP)");
            System.out.print("Choose action: ");

            int action = readInt();

            if (action == 1) {

                player.showWeapons();

                System.out.print("Choose weapon: ");

                int weaponChoice = readInt();

                Weapon weapon = player.getWeapon(weaponChoice);

                if (weapon == null) {

                    System.out.println(
                            Colors.RED +
                            "Invalid weapon." +
                            Colors.RESET
                    );

                    continue;
                }

                if (weapon.isBroken()) {

                    System.out.println(
                            Colors.RED +
                            "This weapon is broken!" +
                            Colors.RESET
                    );

                    continue;
                }

                int damage = weapon.attack();

                if (random.nextInt(100) < 18) {

                    damage += 15;

                    System.out.println(
                            Colors.YELLOW +
                            "CRITICAL HIT!" +
                            Colors.RESET
                    );
                }

                enemy.takeDamage(damage);

                System.out.println(
                        Colors.GREEN +
                        "You used " + weapon.getName() +
                        " and dealt " + damage + " damage!" +
                        Colors.RESET
                );

                if (enemy.isAlive()) {

                    enemyAttack(enemy, level);
                }

            }

            else if (action == 2) {

                player.showInventory();
            }

            else if (action == 3) {

                player.heal(10);

                System.out.println(
                        Colors.BLUE +
                        "You recovered 10 HP." +
                        Colors.RESET
                );

                enemyAttack(enemy, level);
            }

            else {

                System.out.println(
                        Colors.RED +
                        "Invalid choice." +
                        Colors.RESET
                );
            }
        }

        if (player.isAlive()) {

            System.out.println(
                    Colors.GREEN +
                    "\nYou defeated " + enemy.getName() + "!" +
                    Colors.RESET
            );
        }
    }

    static void enemyAttack(Enemy enemy, int level) {

        int damage =
                enemy.getAttackPower()
                + random.nextInt(level * 5 + 1);

        if (random.nextInt(100) < 15) {

            damage += 10;

            System.out.println(
                    Colors.RED +
                    "Heavy enemy attack!" +
                    Colors.RESET
            );
        }

        player.takeDamage(damage);

        System.out.println(
                Colors.RED +
                enemy.getName() +
                " attacked you for " +
                damage + " damage." +
                Colors.RESET
        );
    }

    static void giveReward(int level) {

        System.out.println(
                Colors.BLUE +
                "\nYou found a reward chest!" +
                Colors.RESET
        );

        if (level == 1) {

            ItemContainer woodenChest =
                    new ItemContainer("Wooden Chest");

            woodenChest.addItem(
                    new SimpleItem("Gold Coins", 0, 50)
            );

            woodenChest.addItem(
                    new SimpleItem("Healing Crystal", 0, 30)
            );

            ItemContainer miniBox =
                    new ItemContainer("Mini Box");

            miniBox.addItem(
                    new SimpleItem("Silver Ring", 5, 80)
            );

            woodenChest.addItem(miniBox);

            player.addItem(woodenChest);

            player.heal(15);

            System.out.println(
                    Colors.GREEN +
                    "Reward: Wooden Chest + 15 HP" +
                    Colors.RESET
            );
        }

        else if (level == 2) {

            ItemContainer armorBag =
                    new ItemContainer("Armor Bag");

            armorBag.addItem(
                    new SimpleItem("Steel Helmet", 10, 100)
            );

            armorBag.addItem(
                    new SimpleItem("Old Shield", 8, 90)
            );

            player.addItem(armorBag);

            player.addArmor(25);

            System.out.println(
                    Colors.GREEN +
                    "Reward: Armor Bag + 25 Armor" +
                    Colors.RESET
            );
        }

        else if (level == 3) {

            ItemContainer rareChest =
                    new ItemContainer("Rare Chest");

            rareChest.addItem(
                    new SimpleItem("Diamond", 10, 150)
            );

            ItemContainer magicPouch =
                    new ItemContainer("Magic Pouch");

            magicPouch.addItem(
                    new SimpleItem("Red Gem", 15, 120)
            );

            magicPouch.addItem(
                    new SimpleItem("Ancient Coin", 5, 100)
            );

            ItemContainer secretBox =
                    new ItemContainer("Secret Box");

            secretBox.addItem(
                    new SimpleItem("Boss Scroll", 20, 200)
            );

            magicPouch.addItem(secretBox);

            rareChest.addItem(magicPouch);

            player.addItem(rareChest);

            player.heal(25);

            player.addArmor(20);

            System.out.println(
                    Colors.GREEN +
                    "Reward: Rare Chest + 25 HP + 20 Armor" +
                    Colors.RESET
            );
        }

        player.showInventory();
    }

    static void ending() {

        System.out.println(
                Colors.PURPLE +
                "\n====================================" +
                Colors.RESET
        );

        System.out.println(
                Colors.GREEN +
                "CONGRATULATIONS!" +
                Colors.RESET
        );

        System.out.println("You defeated the Shadow King.");
        System.out.println("The mansion starts collapsing...");
        System.out.println("You escaped successfully.");

        System.out.println();

        System.out.println(
                Colors.YELLOW +
                "TO BE CONTINUED..." +
                Colors.RESET
        );

        System.out.println(
                Colors.CYAN +
                "SEASON 2 COMING SOON" +
                Colors.RESET
        );

        System.out.println(
                Colors.PURPLE +
                "====================================" +
                Colors.RESET
        );

        player.showInventory();

        explainComposite();
    }

    static void explainComposite() {

        System.out.println(
                Colors.YELLOW +
                "\n===== Composite Pattern =====" +
                Colors.RESET
        );

        System.out.println(
                "SimpleItem = Leaf"
        );

        System.out.println(
                "Examples: Diamond, Coin, Ring"
        );

        System.out.println();

        System.out.println(
                "ItemContainer = Composite"
        );

        System.out.println(
                "Examples: Chest, Bag, Box"
        );

        System.out.println();

        System.out.println(
                "Both implement GameItem."
        );

        System.out.println(
                "So the system treats"
        );

        System.out.println(
                "single items and containers"
        );

        System.out.println(
                "the same way."
        );

        System.out.println(
                "================================"
        );
    }

    static int readInt() {

        while (!input.hasNextInt()) {

            input.next();

            System.out.print("Enter a number: ");
        }

        return input.nextInt();
    }
}
