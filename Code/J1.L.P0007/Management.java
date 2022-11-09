/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1.l.p0007;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author E5450
 */
public class Management implements Functions {

    private ArrayList<Phone> list;

    public Management() {
        list = new ArrayList<>();
    }

    void menu() {
        System.out.println("1. Add a phone\n"
                + "2. Search a phone by model\n"
                + "3. Remove the phone by model\n"
                + "4. Print the phone list in descending order of Model\n"
                + "5. Quit\n"
                + "6. Save");
    }

    void display() {
        Collections.sort(list);
        System.out.printf("%15s%20s%10s%20s%15s%10s%10s%15s\n", "Model", "CPU",
                "RAM", "Primary camera", "Screen size", "Color", "Brand", "Prize");
        for (Phone i : list) {
            System.out.printf("%15s", i.getModel());
            System.out.printf("%20s", i.getCPU());
            System.out.printf("%7.0f Gb", i.getRAM());
            System.out.printf("%10.1f Megapixel", i.getPriCam());
            System.out.printf("%10.1f inch", i.getScreenSize());
            System.out.printf("%10s", i.getColor());
            System.out.printf("%10s", i.getBrand());
            System.out.printf("%15.1f", i.getPrice());
            System.out.println("");
        }
    }

    @Override
    public void add() {
        while (true) {
            String model = Validation.stringValidation("Model: ", "[a-zA-Z]+\\s{1}\\d+(\\s{1}a-zA-Z])*");
            if (checkModel(model) != null) {
                System.out.println("Model existed");
                continue;
            }
            String CPU = Validation.stringValidation("CPU: ", "[a-zA-Z]+\\s{1}\\d+");
            double RAM = Validation.doubleValidation("RAM(Gb): ", 0, Double.MAX_VALUE);
            double priCam = Validation.doubleValidation("Prime camera(Megapixel): ", 0, Double.MAX_VALUE);
            double screenSize = Validation.doubleValidation("Screen Size(inches): ", 0, Double.MAX_VALUE);
            String color = Validation.stringValidation("Color: ", "[a-zA-Z]+");
            String brand = Validation.stringValidation("Brand: ", "[a-zA-Z]+");
            double price = Validation.doubleValidation("Price: ", 0, Double.MAX_VALUE);
            Phone a = new Phone(model, CPU, color, brand, RAM, priCam, screenSize, price);
            list.add(a);
            if (!Validation.checkValidation("You want to continue adding another phone? (y/n)")) {
                break;
            }
        }
    }

    Phone checkModel(String model) {
        for (Phone i : list) {
            if (i.getModel().equals(model)) {
                return i;
            }
        }
        return null;
    }

    @Override
    public void searchModel() {
        while (true) {
            String model = Validation.stringValidation("Model: ", "\\S+");
            boolean check = false;
            for (Phone i : list) {
                if (i.getModel().contains(model)) {
                    System.out.println(i);
                    check = true;
                }
            }
            if (!check) {
                System.out.println("This phone Model does not exist");
            }
            if (!Validation.checkValidation("You want to continue? (y/n)")) {
                break;
            }
        }
    }

    @Override
    public void remove() {
        display();
        String model = Validation.stringValidation("Model: ", "\\S+");
        Phone p = checkModel(model);
        if (p == null) {
            System.out.println("=====Model doesn't exit=====");
        } else {
            if (Validation.checkValidation("Do you want to remove this model?(y/n): ")) {
                System.out.println("=====Done=====");
                list.remove(p);
            }
        }
    }

    @Override
    public void save() {
        ArrayList<String> model = new ArrayList<>();
        File f = null;
        FileWriter fw = null;
        FileReader fr = null;
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            f = new File(Validation.stringValidation("File: ", "\\S+"));
            if (!f.exists()) {
                System.out.println("File can't not found");
                return;
            }
            if (!f.canWrite()) {
                System.out.println("File can't write");
                return;
            }
            if (!f.canRead()) {
                System.out.println("File can't read");
                return;
            }
            fr = new FileReader(f.getAbsolutePath());
            br = new BufferedReader(fr);
            String s = "";
            while ( (s=br.readLine()) != null) {
                String[] ss = s.split("\\|");
                model.add(ss[0]);
            }
                
            fw = new FileWriter(f.getAbsolutePath(),true);
            bw = new BufferedWriter(fw);
            for (Phone i : list) {
                if(!model.contains(i.getModel()))
                    bw.write(i.toString());
            }
        } catch (IOException ex) {
            System.out.println("===Invalid===");
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException ex) {
                System.out.println("===Invalid===");
            }
        }
    }
}
