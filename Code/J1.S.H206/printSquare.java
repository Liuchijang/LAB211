/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1.S.H206;

import java.util.Scanner;

/**
 *
 * @author E5450
 */
public class printSquare {

    public static void main(String[] args) {
        int min = checkInput("Enter min value:", Integer.MIN_VALUE, Integer.MAX_VALUE);
        int max = checkInput("Enter max value:" ,min, Integer.MAX_VALUE);
        printSquare(min, max);
    }

    public static void printSquare(int min, int max) {
        for (int i = min; i <= max; i++) {
            for (int j = i; j <= max; j++) {
                System.out.print(j);
            }
            for (int j = min; j <= i-1; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
    
    //1 5
    //12345
    //23451
    //34512
    //45123
    //51234
    
    static int checkInput(String title ,int min, int max) {
        System.out.print(title);
        while (true) {
            try {
                Scanner sc = new Scanner(System.in);
                String s = sc.nextLine();
                int i = Integer.parseInt(s);
                if (s.trim().equals("")) {
                    System.out.println("=====Invalid=====");
                    continue;
                }
                if (i >= min && i <= max) {
                    return i;
                } else System.out.println("=====Invalid=====");
            } catch (Exception e) {
                System.out.println("=====Invalid=====");
            }
        }
    }
}
