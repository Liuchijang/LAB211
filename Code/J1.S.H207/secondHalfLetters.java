/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1.S.H207;

import java.util.Scanner;

/**
 *
 * @author E5450
 */
public class secondHalfLetters {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s;
        while (true) {
            s = sc.nextLine();
            if (!s.trim().isEmpty()) {
                break;
            }
        }
        System.out.println(secondHalfLetters(s.toLowerCase()));

    }

    public static int secondHalfLetters(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 'n' && s.charAt(i) <= 'z') {
                count++;
            }
        }
        return count;
    }
}
