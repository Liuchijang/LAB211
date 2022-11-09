/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1.S.P0001;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author E5450
 */

// Bubble sort
public class BubbleSort {

    public static void main(String[] args) {
        int n = checkInputArray("Enter number of array:", 0, Integer.MAX_VALUE);
        int a[] = new int[n];
        int min = checkInputArray("Enter min value of array:", Integer.MIN_VALUE, Integer.MAX_VALUE);
        int max = checkInputArray("Enter max value of array:" ,min, Integer.MAX_VALUE);
        random(a, n, min, max);
        System.out.print("Unsorted array: ");
        display(a, n);
        sort(a, n);
        System.out.print("Sorted array: ");
        display(a, n);
    }

    static void random(int[] a, int n, int min, int max) {
        Random generator;
        for (int i = 0; i < n; i++) {
            generator = new Random();
            a[i] = generator.nextInt((max - min) + 1) + min;
        }
    }

    static void display(int[] a, int n) {
        System.out.print("[");
        for (int i = 0; i < n; i++) {
            if (i == n - 1) {
                System.out.print(a[i]);
            } else {
                System.out.print(a[i] + ", ");
            }
        }
        System.out.println("]");
    }

    static void sort(int[] a, int n) {
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-1-i; j++) {
                if (a[j] > a[j+1]) {
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
    }
    //6 5 7 1
    //i=0
    //5 6 1 7
    //i=1
    //5 1 6 7
    //i=2
    //1 5 6 7
    
    static int checkInputArray(String title ,int min, int max) {
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
