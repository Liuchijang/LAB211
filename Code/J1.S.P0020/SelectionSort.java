/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1.S.P0020;

import java.util.Scanner;

/**
 *
 * @author E5450
 */
public class SelectionSort {

    public static void main(String[] args) {
        int n = checkInputArray("Enter number of array:", 1, Integer.MAX_VALUE);
        int[] a = new int[n];
        a = input(a);
        System.out.print("Unsorted array: ");
        display(a, n);
        sort(a);
        System.out.print("Sorted array: ");
        display(a, n);
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

    static int[] input(int[] a) {
        for (int i = 0; i < a.length; i++) {
            a[i] = checkInputArray("[" + i + "]:", Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        return a;
    }

    static void sort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[min_idx]) {
                    min_idx = j;
                }
            }
            if(min_idx == i) continue;
            int temp = a[min_idx];
            a[min_idx] = a[i];
            a[i] = temp;
        }
    }

    static int checkInputArray(String title, int min, int max) {
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
