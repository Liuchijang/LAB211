/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1.l.P0023;

/**
 *
 * @author E5450
 */
public class Fruit {
    private int id;
    private double price;
    private String name;
    private int quantity;
    private String origin;

    public Fruit() {
    }

    public Fruit(int id, double price, String name, int quatity, String origin) {
        this.id = id;
        this.price = price;
        this.name = name;
        this.quantity = quatity;
        this.origin = origin;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
    
}
