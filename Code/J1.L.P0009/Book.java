/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1.l.P0009;

import java.io.Serializable;

/**
 *
 * @author E5450
 */
public class Book implements Serializable{
    private String ISBN;
    private String title;
    private int authorID;
    private double price;

    public Book() {
    }

    public Book(String ISBN, String title, int authorID, double price) {
        this.ISBN = ISBN;
        this.title = title;
        this.authorID = authorID;
        this.price = price;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAuthorID() {
        return authorID;
    }

    public void setAuthorID(int authorID) {
        this.authorID = authorID;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return ISBN + ";" + title + ";" + authorID + ";" + price;
    }
    
    
}
