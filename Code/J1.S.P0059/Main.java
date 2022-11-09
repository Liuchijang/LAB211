/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1.S.P0059;

import java.io.IOException;

/**
 *
 * @author E5450
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Management m = new Management();
        while(true){
            m.menu();
            switch(Validation.integerValidation("Selection:", 1, 3)){
                case 1:
                    m.findPeople();
                    break;
                case 2:
                    m.copyFile();
                    break;
                case 3:
                    return;
            }
        }
    }
}
