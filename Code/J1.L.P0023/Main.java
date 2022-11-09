/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1.l.P0023;

import java.util.ArrayList;

/**
 *
 * @author E5450
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<Fruit> a = new ArrayList<>();
        Management m = new Management();
        while(true) {
            m.menu();
            switch(Validation.integerValidation("Sellection:", 1, 5)) {
                case 1:
                    m.creatFruit(0);
                    break;
                case 2:
                    m.updateFruit();
                    break;
                case 3:
                    m.displayOrderList();
                    break;
                case 4:
                    m.shopping();
                    break;
                case 5:
                    return;
            }
        }
    }
}
