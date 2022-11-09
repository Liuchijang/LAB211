/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1.l.P0023;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.Map;

/**
 *
 * @author E5450
 */
public class Management {

    private ArrayList<Fruit> fruits;
    private Hashtable<String, ArrayList<Fruit>> orders;

    public Management() {
        fruits = new ArrayList<>();
        orders = new Hashtable<>();
        fruits.add(new Fruit(1, 1, "Banana", 10, "VietNam"));
        fruits.add(new Fruit(2, 2, "Apple", 15, "Korea"));
        fruits.add(new Fruit(5, 1, "Pear", 10, "Japan"));
        fruits.add(new Fruit(4, 3, "Lemon", 10, "China"));
        fruits.add(new Fruit(3, 4, "PineApple", 10, "VietNam"));
    }

    Fruit searchId(ArrayList<Fruit> a, int id) {
        for (Fruit i : a) {
            if (i.getId() == id) {
                return i;
            }
        }
        return null;
    }
    
    public void creatFruit(int x) {
        while (true) {
            int id = 0;
            if (x == 0) {
                id = Validation.integerValidation("Id:", 1, Integer.MAX_VALUE);
                if (searchId(fruits, id) != null) {
                    System.out.println("ID exited");
                    continue;
                }
            } else {
                id = x;
                x = 0;
            }
            
            String name = Validation.stringValidation("Name:");
            double price = Validation.doubleValidation("Price:", 0, Double.MAX_VALUE);
            int quantity = Validation.integerValidation("Quantity:", 1, Integer.MAX_VALUE);
            String origin = Validation.stringValidation("Origin:");
            
            Fruit i = new Fruit(id, price, name, quantity, origin);            
            fruits.add(i);
            if (!Validation.checkValidation("Do you want to continue (Y/N)?")) {
                displayFruitList(fruits);
                break;
            }
        }
    }

    public void updateFruit() {
        int id = Validation.integerValidation("ID:", 1, Integer.MAX_VALUE);
        Fruit a = searchId(fruits, id);
        if (a == null) {
            if (Validation.checkValidation("ID is not exited. Do you want to creat new?(Y/N)")) {
                creatFruit(id);
            }
        } else {
            int quantity = Validation.integerValidation("New quantity:", 1, Integer.MAX_VALUE);
            a.setQuantity(quantity);
        }
    }
    
    
    public void shopping() {
        ArrayList<Fruit> ordering = new ArrayList<>();
        ArrayList<Fruit> showlist = showList(fruits);
        while(true) {
            if(ordering.isEmpty() && showlist.isEmpty()) return; 
            else if(!ordering.isEmpty() && showlist.isEmpty()) break;
            
            displayFruitList(showlist);
            
            int item = Validation.integerValidation("Item:", 1, showlist.size());
            Fruit fr = showlist.get(item-1);
            System.out.println("Selection:" + fr.getName());
            int quantity = Validation.integerValidation("Please input quantity:", 1, fr.getQuantity());
            fr.setQuantity(fr.getQuantity() - quantity);
            
            //remove in showlist if quantity = 0
            if(fr.getQuantity()==0) showlist.remove(fr);
            Fruit a = new Fruit(fr.getId(), fr.getPrice(), fr.getName(), quantity, fr.getOrigin());
            Fruit b = searchId(ordering, a.getId());
            if(b != null) {
                b.setQuantity(b.getQuantity() + quantity);
            } else {
                ordering.add(a);
            }
            if(Validation.checkValidation("Do you want to order now (Y/N):")) break;
        }
        displayOrder(ordering);
        String user = Validation.stringValidation("Input your name:");
        orders.put(checkName(user), ordering);
    }
    
    String checkName(String name) {
        while(orders.containsKey(name))
            name += " ";
        return name;
    }
    
    public void displayOrderList() {
        for(Map.Entry<String, ArrayList<Fruit>> i: orders.entrySet()) {
            System.out.println("Customer: " + i.getKey().trim());
            displayOrder(i.getValue());
            System.out.println("");
        }
    }

    void displayOrder(ArrayList<Fruit> a) {
        double amount = 0;
        double total = 0;
        Collections.sort(a, new Comparator<Fruit>() {
            @Override
            public int compare(Fruit o1, Fruit o2) {
                return o2.getQuantity() - o1.getQuantity();
            }
        });
        System.out.println("Product|Quantity|Price|Amount");
        for (Fruit i : a) {
            amount = 0;
            System.out.printf("%s|%d|%.1f$", i.getName(), i.getQuantity(), i.getPrice());
            total += amount = i.getPrice() * i.getQuantity();
            System.out.println("|" + amount + "$");
        }
        System.out.println("Total: " + total + "$");
    }

    ArrayList<Fruit> showList(ArrayList<Fruit> a) {
        ArrayList<Fruit> b = new ArrayList<>();
        for (Fruit i : a) {
            if (i.getQuantity() == 0) {
                continue;
            }
            b.add(i);
        }
        return b;
    }
    
    void displayFruitList(ArrayList<Fruit> a) {
        int count = 1;
        System.out.println("|++Item++|++Fruit Name++|++Origin++|++Price++|");
            for (Fruit i : a) {
                System.out.printf("%5d%15s%13s%8.1f$\n", count++, i.getName(), i.getOrigin(), i.getPrice());
            }
    }
    
    public void menu() {
        System.out.println("FRUIT SHOP SYSTEM\n" +
                        "	1.Creat Fruit\n" +
                        "	2.Update Fruit\n" +
                        "	3.View orders\n" +
                        "	4.Shopping (for buyer)\n" +
                        "	5.Exit");
    }
}
