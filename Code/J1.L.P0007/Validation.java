/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1.l.p0007;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author E5450
 */
public class Validation {

    private static Scanner sc = new Scanner(System.in);

    static String stringValidation(String title, String regex) {
        while (true) {
            System.out.print(title);
            try {
                String i = sc.nextLine();
                if (i.trim().equals("") || !i.matches(regex)) {
                    System.out.println("=====Input invalid=====");
                    continue;
                }
                return i;
            } catch (Exception e) {
                System.out.println("=====Input invalid=====");
            }
        }
    }

    static double doubleValidation(String title, double MIN, double MAX) {
        while (true) {
            try {
                double i = Double.parseDouble(stringValidation(title, "\\S+"));
                if (i < MIN || i > MAX) {
                    System.out.println("=====Input invalid=====");
                    continue;
                }
                return i;
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
