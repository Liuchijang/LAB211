/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1.S.P0059;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author E5450
 */
public class Management {

    ArrayList<User> a;

    public Management() {
        a = new ArrayList<>();
    }

    void readFile() throws IOException {
        FileReader f = new FileReader(Validation.fileValidation("Enter path:"));
        BufferedReader br = new BufferedReader(f);
        String line = null;
        while ((line = br.readLine()) != null) {
            String[] s = line.split(";");
            if(s.length == 0){
                System.out.println("Have a data wrong fomat");
                continue;
            }
            User u;
            String username = s[0];
            if(!Validation.checkFileData(s[0], "[a-zA-Z]+(\\s*[a-zA-Z]+)+")){
                System.out.println("Have a data wrong fomat");
                continue;
            }
            String addr = "";
            try {
                addr = s[1];
                if(!Validation.checkFileData(s[1], "[a-zA-Z0-9]+(\\s{1}[a-zA-Z]+)+")){
                    System.out.println("Have a data wrong fomat");
                    continue;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
            }
            double money = 0;
            try {
                if(Validation.checkFileData(s[2], "[0-9]+\\.{0,1}[0-9]+")){ // *: appear or not; + :appear at leat 1
                   money = Double.parseDouble(s[2]);
                }    
            } catch (ArrayIndexOutOfBoundsException e) {
            }
            u = new User(username, addr, money);
            a.add(u);
        }
        f.close();
        br.close();
    }

    void copyFile() throws IOException {
        System.out.println("=====Copy text=====");
        ArrayList<String> b = new ArrayList<>();
        FileReader f1 = new FileReader(Validation.fileValidation("Enter source:"));
        BufferedReader br = new BufferedReader(f1);
        String line = null;
        while ((line = br.readLine()) != null) {
            line = line.replaceAll(";", " ");
            String[] s = line.split("\\s+");
            for (String i : s) {
                if (!b.contains(i)) {
                    b.add(i);
                }
            }
        }
        f1.close();
        br.close();
        FileWriter f2 = new FileWriter(Validation.fileValidation("Enter new filename:"));
        BufferedWriter bw = new BufferedWriter(f2);
        for (String i : b) {
            bw.write(i);
            bw.write(" ");
        }
        f2.close();
        System.out.println("Copy done......");
    }

    void findPeople() throws IOException {
        System.out.println("----------Personal infor-----------");
        Double money = Validation.doubleValidation("Enter money:", 0, Integer.MAX_VALUE);
        readFile();
        System.out.println("-----------Result----------");
        System.out.printf("%15s%15s%15s\n", "Name", "Address", "Money");
        int max = 0, min = 0;
        sort();
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).getMoney() >= money) {
                System.out.printf("%15s", a.get(i).getName());
                System.out.printf("%15s", a.get(i).getAddr());
                System.out.printf("%15.1f", a.get(i).getMoney());
                System.out.println("");
            }
        }
        System.out.println("Max:" + a.get(a.size() - 1).getName());
        System.out.print("Min:");
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).getMoney() >= money) {
                System.out.print(a.get(i).getName() + "\n");
                break;
            }
        }

    }

    void sort() {
        Collections.sort(a, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return (int) (o1.getMoney() - o2.getMoney());
            }
        });
    }

    void menu() {
        System.out.println("=====File processing=====\n"
                + "1. Find personal infor\n"
                + "2. Copy text to new file\n"
                + "3. Exit");
    }
}
