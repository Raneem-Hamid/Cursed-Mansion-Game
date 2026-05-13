/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package escapethecursedmansion;

import java.util.Scanner;

/**
 *
 * @author Student
 */
public class GameRooms {
   static Scanner input = new Scanner(System.in);

    public static void darkHall() {

        System.out.println("\n[Dark Hall]");
        System.out.println("1- Pick up Flashlight");
        System.out.println("2- Open Old Bag");
        System.out.println("3- Walk in darkness");

        int choice = input.nextInt();

        switch (choice) {

            case 1 -> {

                if (!GameState.hasFlashlight) {

                    GameState.hasFlashlight = true;

                    GameState.inventory.addItem(
                            new SimpleItem("Flashlight", 5, 20)
                    );

                    System.out.println("Flashlight added.");
                }
            }

            case 2 -> {

                if (!GameState.hasRustyKey) {

                    ItemContainer oldBag =
                            new ItemContainer("Old Bag");

                    oldBag.addItem(
                            new SimpleItem("Rusty Key", 10, 30)
                    );

                    oldBag.addItem(
                            new SimpleItem("Torn Note", 0, 5)
                    );

                    GameState.inventory.addItem(oldBag);

                    GameState.hasRustyKey = true;

                    System.out.println("You opened the Old Bag.");
                }
            }

            case 3 -> {

                GameState.health -= 15;
                GameState.fear += 20;

                System.out.println("You got hurt in darkness.");
            }
        }
    }

    public static void libraryRoom() {

        System.out.println("\n[Library Room]");

        if (!GameState.hasRustyKey) {

            System.out.println("You need Rusty Key.");
            return;
        }

        System.out.println("1- Open Wooden Chest");
        System.out.println("2- Search books");

        int choice = input.nextInt();

        switch (choice) {

            case 1 -> {

                if (!GameState.hasSilverKey) {

                    ItemContainer woodenChest =
                            new ItemContainer("Wooden Chest");

                    woodenChest.addItem(
                            new SimpleItem("Silver Key", 15, 50)
                    );

                    woodenChest.addItem(
                            new SimpleItem("Candle", 3, 10)
                    );

                    ItemContainer smallBox =
                            new ItemContainer("Small Box");

                    smallBox.addItem(
                            new SimpleItem("Secret Code Paper", 0, 40)
                    );

                    woodenChest.addItem(smallBox);

                    GameState.inventory.addItem(woodenChest);

                    GameState.hasSilverKey = true;
                    GameState.hasSecretCode = true;

                    System.out.println("Wooden Chest opened.");
                }
            }

            case 2 -> {

                GameState.fear += 15;

                System.out.println("You hear whispers...");
            }
        }
    }

    public static void storageRoom() {

        System.out.println("\n[Storage Room]");

        if (!GameState.hasSilverKey) {

            System.out.println("You need Silver Key.");
            return;
        }

        System.out.println("1- Open Metal Chest");
        System.out.println("2- Take Hammer");

        int choice = input.nextInt();

        switch (choice) {

            case 1 -> {

                ItemContainer metalChest =
                        new ItemContainer("Metal Chest");

                metalChest.addItem(
                        new SimpleItem("Diamond", 5, 120)
                );

                metalChest.addItem(
                        new SimpleItem("Map Piece", 0, 45)
                );

                ItemContainer magicPouch =
                        new ItemContainer("Magic Pouch");

                magicPouch.addItem(
                        new SimpleItem("Ancient Coin", 2, 70)
                );

                magicPouch.addItem(
                        new SimpleItem("Red Gem", 8, 100)
                );

                metalChest.addItem(magicPouch);

                GameState.inventory.addItem(metalChest);

                System.out.println("Metal Chest opened.");
            }

            case 2 -> {

                GameState.inventory.addItem(
                        new SimpleItem("Hammer", 20, 35)
                );

                System.out.println("Hammer added.");
            }
        }
    }

    public static boolean secretRoom() {

        System.out.println("\n[Secret Room]");

        if (!GameState.hasSecretCode) {

            System.out.println("You need Secret Code.");
            return true;
        }

        ItemContainer goldenBox =
                new ItemContainer("Golden Key Box");

        goldenBox.addItem(
                new SimpleItem("Golden Key", 50, 200)
        );

        goldenBox.addItem(
                new SimpleItem("Escape Note", 0, 15)
        );

        GameState.inventory.addItem(goldenBox);

        GameState.hasGoldenKey = true;

        System.out.println("You found the Golden Key!");
        System.out.println("You escaped successfully!");

        return false;
    } 
}
