/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1.S.P0059;

import java.io.File;
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
            try {
                String i = sc.nextLine();
                if (i.trim().equals("")) {
                    System.out.println("=====Input invalid=====");
                    continue;
                }
                return i;
            } catch (Exception e) {
                System.out.println("=====Input invalid=====");
            }
        }
    }
    
    static int integerValidation(String title, int MIN, int MAX) {
        while (true) {
            try {
                int i = Integer.parseInt(stringValidation(title));
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
    
    static double doubleValidation(String title, int MIN, int MAX) {
        while (true) {
            try {
                double i = Double.parseDouble(stringValidation(title));
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
    
    static String fileValidation(String title) {
        while (true) {
            try {
                String i = stringValidation(title);
                File f = new File(i);
                if(!f.exists()){
                    System.out.println("=====Can't found=====");
                    continue;
                }
                if(f.length() == 0){
                    System.out.println("=====Empty file=====");
                    continue;
                }
                if(!f.canRead()){
                    System.out.println("=====Can't read file=====");
                }
                return i;
            } catch (Exception e) {
                System.out.println("=====Input invalid=====");
            }
        }
    }
    
        
    static boolean checkFileData(String data, String regex){
        if(!data.matches(regex) || data.trim().isEmpty()) {
            System.out.println("Invalid");
            return false;
        }
        return true;
    }
}
