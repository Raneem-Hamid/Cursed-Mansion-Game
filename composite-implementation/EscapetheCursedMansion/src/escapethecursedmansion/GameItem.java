/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package escapethecursedmansion;

/**
 *
 * @author Student
 */
public interface GameItem {
    String getName();

    int getPower();

    int getValue();

    void showDetails(String indent);
}
