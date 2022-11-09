/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1.l.P0023;

import java.util.Scanner;

/**
 *
 * @author E5450
 */
public class Validation {

    private static Scanner sc = new Scanner(System.in);

    static String stringValidation(String title) {
        while (true) {
            System.out.print(title);
            String s = sc.nextLine();
            if (s.trim().isEmpty()) {
                System.out.println("=====Invalid Input=====");
                continue;
            }
            return s;
        }
    }
    
    static Integer integerValidation(String title, int min, int max) {
        while (true) {
            try {
                int i = Integer.parseInt(stringValidation(title));
                if (i >= min && i <= max) {
                    return i;
                } else System.out.println("=====Invalid Input=====");
            } catch (Exception e) {
                System.out.println("=====Invalid Input=====");
            }

        }
    }
    
    static double doubleValidation(String title, double min, double max) {
        while (true) {
            try {
                double i = Double.parseDouble(stringValidation(title));
                if (i >= min && i <= max) {
                    return i;
                } else System.out.println("=====Invalid Input=====");
            } catch (Exception e) {
                System.out.println("=====Invalid Input=====");
            }

        }
    }
    
    static boolean checkValidation(String title) {
        while(true) {
            String s = stringValidation(title);
            if(s.equalsIgnoreCase("y")) return true;
            else if(s.equalsIgnoreCase("n")) return false;
        }
    }
}
