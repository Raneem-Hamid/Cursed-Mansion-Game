/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package escapethecursedmansion;

/**
 *
 * @author Student
 */
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

    public int getPower() {
        return power;
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public void showDetails(String indent) {

        System.out.println(indent + "- " + name
                + " | Power: " + power
                + " | Value: " + value);
    }
}
