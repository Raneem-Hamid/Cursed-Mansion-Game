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
public class ItemContainer implements GameItem {
     private String name;
    private List<GameItem> items = new ArrayList<>();

    public ItemContainer(String name) {
        this.name = name;
    }

    public void addItem(GameItem item) {
        items.add(item);
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        int total = 0;

        for (GameItem item : items) {
            total += item.getValue();
        }

        return total;
    }

    public void showDetails(String indent) {
        System.out.println(indent + Colors.BLUE + "+ " + name
                + " | Total Value: " + getValue() + Colors.RESET);

        for (GameItem item : items) {
            item.showDetails(indent + "   ");
        }
    }
    
    @Override
public int getPower() {

    int total = 0;

    for (GameItem item : items) {
        total += item.getPower();
    }

    return total;
}
}
