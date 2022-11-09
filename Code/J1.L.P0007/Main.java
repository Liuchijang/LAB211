/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1.l.p0007;

import java.io.IOException;

/**
 *
 * @author E5450
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        Management o = new Management();
        System.out.println("=====Welcome to HKT store=====");
        System.out.println("@ 2022 by <HE163176 - Nguyen Truong Giang>");
        while (true) {
            o.menu();
            int choice = Integer.parseInt(Validation.stringValidation("Selection: ", "[1-6]"));
            switch(choice){
                case 1:
                    o.add();
                    break;
                case 2:
                    o.searchModel();
                    break;
                case 3:
                    o.remove();
                    break;
                case 4:
                    o.display();
                    break;
                case 5:
                    return;
                case 6:
                    o.save();
                    break;
            }
        }
    }

}
