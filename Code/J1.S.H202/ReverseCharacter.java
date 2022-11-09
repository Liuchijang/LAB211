/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1.S.H202;

import java.util.Scanner;

/**
 *
 * @author E5450
 */
public class ReverseCharacter {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        if (s.trim().isEmpty()) {
            return;
        }
        System.out.println(printReverse(s));
    }
    
    public static String printReverse(String s) {
        String t = "";
        for(int i = s.length()-1; i >= 0; i--)
            t += s.charAt(i);
        return t;
    }
}
