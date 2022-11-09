/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1.S.P0074;

import java.util.Scanner;

/**
 *
 * @author E5450
 */
public class Management {
    
    int[][] input(int n, int xRow, int xCol) {
        int row, col;
        if (xRow == 0 && xCol == 0) {
            row = integerValidation("Row matrix " + n + ": ", 1, Integer.MAX_VALUE);
            col = integerValidation("Column matrix " + n + ": ", 1, Integer.MAX_VALUE);
        } else if (xRow != 0 && xCol != 0) {
            row = integerValidation("Row matrix " + n + ": ", xRow, xRow);
            col = integerValidation("Column matrix " + n + ": ", xCol, xCol);
        } else {
            row = integerValidation("Row matrix " + n + ": ", xCol, xCol);
            col = integerValidation("Column matrix " + n + ": ", 1, Integer.MAX_VALUE);
        }
        int[][] a = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                a[i][j] = integerValidation("Enter Matrix" + n + "[" + (i + 1) + "]["
                        + (j + 1) + "]: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
            }
        }
        return a;
    }
    
    void display(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print("[" + a[i][j] + "]");
            }
            System.out.println("");
        }
    }
    
    void displayResult(String s, int[][] matrix1, int[][] matrix2, int[][] matrix3) {
        System.out.print("------------------------\n");
        display(matrix1);
        System.out.print(s + "\n");
        display(matrix2);
        System.out.print("=\n");
        display(matrix3);
    }
    
    public int[][] additionMatrix(int[][] matrix1, int[][] matrix2) {
        System.out.println("======= Addition =======");
        matrix1 = input(1, 0, 0);
        int row = matrix1.length, col = matrix1[0].length;
        matrix2 = input(2, row, col);
        int[][] matrix3 = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix3[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        displayResult("+", matrix1, matrix2, matrix3);
        return matrix3;
    }
    
    public int[][] subtractionMatrix(int[][] matrix1, int[][] matrix2) {
        System.out.println("======= Subtraction =======");
        matrix1 = input(1, 0, 0);
        int row = matrix1.length, col = matrix1[0].length;
        matrix2 = input(2, row, col);
        int[][] matrix3 = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix3[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        displayResult("-", matrix1, matrix2, matrix3);
        return matrix3;
    }
    
    public int[][] multiplicationMatrix(int[][] matrix1, int[][] matrix2) {
        System.out.println("======= Multiplication =======");
        matrix1 = input(1, 0, 0);
        int row = matrix1.length, col = matrix1[0].length;
        matrix2 = input(2, 0, col);
        int[][] matrix3 = new int[row][matrix2[0].length];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < matrix2[0].length; j++){
                int temp = 0;
                for(int k = 0; k < col; k++){
                    temp = matrix1[i][k] + matrix2[k][j];
                }
                matrix3[i][j] = temp;
            }
        }
        displayResult("*", matrix1, matrix2, matrix3);
        return matrix3;
    }
//    1 2  * 1  = 3
//    1 2    1    3
    int integerValidation(String title, int min, int max) {
        System.out.print(title);
        Scanner sc = new Scanner(System.in);
        while (true) {
            String s = sc.nextLine();
            if (s.trim().equals("")) {
                System.out.println("Values of matrix must be the number");
                continue;
            }
            int n = 0;
            try {
                n = Integer.parseInt(s);
                if (n < min || n > max) {
                    if (max != min) {
                        System.out.println("Out of range");
                    } else {
                        System.out.println("Row/column of matrix 2 must equal with Row/column of matrix 1");
                    }
                    continue;
                }
                return n;
            } catch (Exception e) {
                System.out.println("Values of matrix must be the number");
            }
        }
    }
    
    void menu() {
        System.out.println("======= Caculator program =======\n"
                + "1. Addition Matrix\n"
                + "2. Subtraction Matrix\n"
                + "3. Mutiplication Matrix\n"
                + "4. Quit");
    }
    
}//end
