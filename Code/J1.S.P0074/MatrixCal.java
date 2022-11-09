/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1.S.P0074;

/**
 *
 * @author E5450
 */
public class MatrixCal {
    public static void main(String[] args) {
        Management m = new Management();
        int[][] matrix1 = null, matrix2 = null;
        while(true){
            m.menu();
            switch(m.integerValidation("Selection: ", 0, 5)){
                case 1:
                    m.additionMatrix(matrix1, matrix2);
                    break;
                case 2:
                    m.subtractionMatrix(matrix1, matrix2);
                    break;
                case 3:
                    m.multiplicationMatrix(matrix1, matrix2);
                    break;
                case 4:
                    return;
            }
        }
    }
}
