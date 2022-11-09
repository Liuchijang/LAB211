/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1.S.H203;

import java.util.Scanner;

/**
 *
 * @author E5450
 */
public class ReverseWord {

    public static void main(String[] args) {
        String s = stringValidation("Enter string:", "\\w+(\\s{0,1}\\w+[!|?|.|,]?)*");
        System.out.println("After reverse:\n" + reverseSentence(s));
    }

    static String stringValidation(String title, String regex) {
        System.out.println(title);
        while (true) {
            Scanner sc = new Scanner(System.in);
            String s;
            s = sc.nextLine();
            if (!s.matches(regex)) {
                System.out.println("=====Invalid Input=====");
                continue;
            }
            return s;
        }
    }

    static String reverseSentence(String s) {
        String[] a = s.split("[\\.!?,]");
        String[] b = s.split("[\\w+\\s+]");
        
        String s1 = "";
        int j = 0;         
        for (int i = a.length - 1; i >= 1; i--) {
            if(j > b.length){
                s1 += reverseWord(a[i]);
                continue;
            }
            s1 += reverseWord(a[i]) + b[j];
            j++;
        }
        return s1;
    }

    static String reverseWord(String s) {
        String[] a = s.split("\\s+");
        for (int i = 0; i < a.length; i++) {
            if (i == a.length - 1) {
                a[i] = String.valueOf(a[i].charAt(0)).toUpperCase()
                        + String.valueOf(a[i].substring(1));
            } else {
                a[i] = String.valueOf(a[i].charAt(0)).toLowerCase()
                        + String.valueOf(a[i].substring(1));
            }
        }
        String s1 = "";
        for (int i = a.length - 1; i >= 1; i--) {
            s1 += a[i] + " ";
        }
        return s1 + a[0];
    }
}
