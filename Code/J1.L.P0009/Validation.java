/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1.l.P0009;

import java.util.Scanner;

/**
 *
 * @author E5450
 */
public class Validation {

    private static Scanner sc = new Scanner(System.in);

    static String stringValidation(String title, String old) {
        while (true) {
            System.out.print(title);
            String i = sc.nextLine();
            if (old == null) {
                if (i.trim().isEmpty()) {
                    System.out.println("=====Input invalid=====");
                    continue;
                }
            } else {
                if (i.trim().isEmpty()) {
                    return old;
                }
            }
            return i;
        }
    }

    static int intergerValidation(String title, int MIN, int MAX, String old) {
        while (true) {
            try {
                int i = Integer.parseInt(stringValidation(title, old));
                if (i >= MIN && i <= MAX) {
                    return i;
                } else System.out.println("=====Input invalid=====");
            } catch (Exception e) {
                System.out.println("=====Input invalid=====");
            }
        }
    }
    
    static double doubleValidation(String title, double MIN, double MAX, String old) {
        while (true) {
            try {
                double i = Double.parseDouble(stringValidation(title, old));
                if (i >= MIN && i <= MAX) {
                    return i;
                }
            } catch (Exception e) {
                System.out.println("=====Input invalid=====");
            }
        }
    }
    
    static boolean checkValidation(String title) {
        while (true) {
            System.out.print(title);
            String i = sc.nextLine();
            if (i.equalsIgnoreCase("y")) {
                return true;
            } else if (i.equalsIgnoreCase("n")) {
                return false;
            } else {
                System.out.println("=====Input invalid=====");
            }
        }
    }

}
