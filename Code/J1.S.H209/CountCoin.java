/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1.S.H209;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author E5450
 */
public class CountCoin {
    public static void main(String[] args) {
        ArrayList<Integer> value = new ArrayList<>();
        ArrayList<String> key = new ArrayList<>();
        System.out.printf("Total money: %.2f$\n", readFile()*0.01);
    }
    
    static int readFile() {
        FileReader f = null;
        try {
            f = new FileReader("Coin.txt");
            Scanner sc = new Scanner(f);
            String s = "";
            int i = 0;
            int sum = 0;
            while (sc.hasNext()) {
                i = sc.nextInt();
                s = sc.next().toLowerCase();
                sum += calculation(i, s);
            }
            return sum;
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                f.close();
            } catch (IOException ex) {
            }
        }
        return 0;
    }

    static int calculation(int value, String key) {
        int sum = 0;
        if(key.equalsIgnoreCase("coke")) sum += 1*value;
        else if(key.equalsIgnoreCase("adidas")) sum += 5*value;
        else if(key.equalsIgnoreCase("dimes")) sum += 10*value;
        else if(key.equalsIgnoreCase("quarters")) sum += 25*value;
        return sum;
    }
}
