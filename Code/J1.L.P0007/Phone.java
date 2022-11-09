/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1.l.p0007;

/**
 *
 * @author E5450
 */
public class Phone implements Comparable<Phone>{
    private String model, CPU, color, brand;
    private double RAM, priCam, screenSize, price;

    public Phone() {
    }

    public Phone(String model, String CPU, String color, String brand, double RAM,
            double priCam, double screenSize, double price) {
        this.model = model;
        this.CPU = CPU;
        this.color = color;
        this.brand = brand;
        this.RAM = RAM;
        this.priCam = priCam;
        this.screenSize = screenSize;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public String getCPU() {
        return CPU;
    }

    public String getColor() {
        return color;
    }

    public String getBrand() {
        return brand;
    }

    public double getRAM() {
        return RAM;
    }

    public double getPriCam() {
        return priCam;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public double getPrice() {
        return price;
    }

    public void setCPU(String CPU) {
        this.CPU = CPU;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setRAM(int RAM) {
        this.RAM = RAM;
    }

    public void setPriCam(int priCam) {
        this.priCam = priCam;
    }

    public void setScreenSize(int screenSize) {
        this.screenSize = screenSize;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public int compareTo(Phone o) {
        return this.getModel().compareTo(o.getModel());
    }
    
    @Override
    public String toString(){
        return String.format("%s|%s|%.1f|%.1f|%.1f|%s|%s|%.1f\n", model, CPU, RAM, priCam, screenSize, color, brand, price);
    }
}
