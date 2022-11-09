/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1.S.H210;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author E5450
 */

//flipLines
public class flipLines {
    public static void main(String[] args) throws IOException {
        ArrayList<String> data = new ArrayList<>();
        read(data);
        display(data);
        System.out.println("===============================");
        flipLine(data);
    }
    
    static void read(ArrayList<String> data) throws IOException{
        FileReader f = new FileReader(fileValidation("File:"));
        Scanner sc = new Scanner(f);
        while(sc.hasNextLine()){
            data.add(sc.nextLine());
        }
        sc.close();
        f.close();
    }
    
    static void display(ArrayList<String> data){
        for(int i = 0; i < data.size(); i++)
            System.out.println(data.get(i));
    }
    
    static void flipLine(ArrayList<String> data){
        for(int i = 0, j = i + 1; i < data.size(); i+=2){
            if(j == data.size()) System.out.println(data.get(i));
            else{
                System.out.println(data.get(j));
                System.out.println(data.get(i));
            }
        }
    }
    
    static String fileValidation(String title) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print(title);
            try {
                String i = sc.nextLine();
                if (i.trim().equals("")) {
                    System.out.println("=====Input invalid=====");
                    continue;
                }
                File f = new File(i);
                if(!f.exists()){
                    System.out.println("=====Can't found=====");
                    continue;
                }
                if(!f.canRead()){
                    System.out.println("=====Can't read=====");
                    continue;
                }
                FileReader f1 = new FileReader(f);
                sc = new Scanner(f1);
                if(!sc.hasNext()){
                    System.out.println("=====Can't read=====");
                    continue;
                }
                return i;
            } catch (Exception e) {
                System.out.println("=====Input invalid=====");
            }
        }
    }
}
