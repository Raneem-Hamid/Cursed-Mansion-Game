/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package escapethecursedmansion;

/**
 *
 * @author Student
 */
public class GameState {
    public static int health = 100;

    public static int fear = 0;

    public static boolean hasFlashlight = false;

    public static boolean hasRustyKey = false;

    public static boolean hasSilverKey = false;

    public static boolean hasSecretCode = false;

    public static boolean hasGoldenKey = false;

    public static ItemContainer inventory =
            new ItemContainer("Player Inventory");
}
