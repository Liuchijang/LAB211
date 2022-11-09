/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1.l.P0009;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author E5450
 */
public class Management implements Funtions {

    private ArrayList<Book> books;
    private HashMap<Integer, String> authors;

    public Management() {
        books = new ArrayList<>();
        authors = new HashMap<>();
    }

    void readBook() {
        FileInputStream f = null;
        while(true) {
            String s = Validation.stringValidation("File:", null);
            try {
                f = new FileInputStream(s);
                ObjectInputStream o = new ObjectInputStream(f);
                books = (ArrayList<Book>) o.readObject();
                break;
            } catch (Exception e) {
                System.out.println("===== Error =====\nBook list have error\n" + e.getMessage());
                continue;
            } finally {
                try {
                    if (f != null) {
                        f.close();
                    }
                } catch (IOException ex) {
                }
            }
        }
        
    }

    void readAuthor() {
        FileInputStream f = null;
        try {
            f = new FileInputStream("author.dat");
            ObjectInputStream o = new ObjectInputStream(f);
            authors = (HashMap<Integer, String>) o.readObject();
        } catch (Exception e) {
            System.out.println("===== Error =====\nAuthor list have error\n" + e.getMessage());
            System.exit(0);
        } finally {
            try {
                if(f != null) {
                    f.close();
                }
            } catch (IOException ex) {
            }
        }
    }

    void menu() {
        System.out.println("===================\n"
                + "1. Show the book list\n"
                + "2. Add new book\n"
                + "3. Update book\n"
                + "4. Delete book\n"
                + "5. Delete author\n"
                + "6. Search book\n"
                + "7. Quit");
    }

    @Override
    public void displayBook(ArrayList<Book> a) {
        for (Book i : a) {
            System.out.println(i);
        }
    }

    void displayAuthor(HashMap<Integer, String> a) {
        for(Map.Entry<Integer, String> i: a.entrySet()) {
            System.out.println(i.getKey() + ";"+ i.getValue());
        }
    }
    
    @Override
    public void addBook() {
        while (true) {
            String ISBN = Validation.stringValidation("ISBN: ", null);
            if (!ISBN.matches("\\d{3}(\\-\\d+){4}") ||ISBN.length() != 14) {
                System.out.println("Wrong format. Please try again!!");
                continue;
            }
            if (searchBook(ISBN) != null) {
                System.out.println("===== ISBN exited =====");
                continue;
            }
            String title = Validation.stringValidation("Title: ", null);           
            int authorID = getAuthorID();
            double price = Validation.doubleValidation("Price: ", 0, Double.MAX_VALUE, null);
            Book a = new Book(ISBN, title, authorID, price);
            books.add(a);
            if (!Validation.checkValidation("Continue? (y/n): ")) {
                save("book.dat", books);
                break;
            }
        }
    }    
    
    Integer getAuthorID() {
        ArrayList<Integer> id_list;
        while(true) {
        String authorName = Validation.stringValidation("Author: ", null);
            id_list = new ArrayList<>();
            for (Map.Entry<Integer, String> i : authors.entrySet()) {
                if (i.getValue().contains(authorName)) {
                    id_list.add(i.getKey());
                }
            }
            if(!id_list.isEmpty()) break;
        }
        for (int i = 0; i < id_list.size(); i++) {
            System.out.println((i + 1) + "|" + id_list.get(i) + "|" + authors.get(id_list.get(i)));
        }
        int index = Validation.intergerValidation("Index: ", 1, id_list.size(), null);
        return id_list.get(index-1);
    }
    
    @Override
    public void updateBook() {
        String ISBN = Validation.stringValidation("ISBN: ", null);
        Book a = searchBook(ISBN);
        if (a == null) {
            System.out.println("Book does not existed");
        } else {
            String title = Validation.stringValidation("New title: ", a.getTitle());
            int authorID = getAuthorID();
            double price = Validation.doubleValidation("New price: ", 0, Double.MAX_VALUE, String.valueOf(a.getPrice()));
            if(title.equals(a.getTitle())&&authorID==a.getAuthorID()&&price==a.getPrice()) {
                System.out.println("No change have done");
                return;
            }
            
            if(!title.equals(a.getTitle())) {
                a.setTitle(title);
            }
            if(authorID!=a.getAuthorID()) {
                a.setAuthorID(authorID);
            }
            if(price!=a.getPrice()) {
                a.setPrice(price);
            }
            System.out.println("\n" + a);
            save("book.dat", books);
        }
    }

    @Override
    public void deleteBook() {
        displayBook(books);
        String ISBN = Validation.stringValidation("ISBN: ", null);
        if (searchBook(ISBN) == null) {
            System.out.println("Book does not exited");
        } else {
            if (Validation.checkValidation("Confirm to delete (y/n): ")) {
                books.remove(searchBook(ISBN));
                System.out.println("Success");
                save("book.dat", books);
            } else System.out.println("Fail");
        }
    }
    
    @Override
    public void deleteAuthor() {
        int authorID = getAuthorID();
        Book a = searchBook(authorID);
        if(a!=null) 
            System.out.println("This author has a book in the store, you cannot delete this author\n"
                             + "Fail");
        else {
            authors.remove(authorID);
            System.out.println("success");
            save("author.dat", authors);
        }       
    }

    @Override
    public void searchBook() {
        System.out.println("1.Search by title\n"
                         + "2.Search by author's name");
        if(Validation.intergerValidation("Selection: ", 1, 2, null)==1) {
            String title = Validation.stringValidation("Title: ", null);
            for(Book i:books) {
                if(i.getTitle().toLowerCase().contains(title.toLowerCase())) {                
                    System.out.println(i);
                }
            }
        } else {
            String authorName = Validation.stringValidation("AuthorName: ", null);
            for(Book i: books) {
                if(authors.get(i.getAuthorID()).equalsIgnoreCase(authorName))
                    System.out.println(i);
            }
        }      
    }

    void save(String file, Object obj) {
        FileOutputStream f = null;
        try {
            f = new FileOutputStream(file);
            ObjectOutputStream o = new ObjectOutputStream(f);
            o.writeObject(obj);
        } catch (IOException ex) {
            System.out.println("===== Error =====\n" + ex.getMessage());
        } finally {
            try {
                if(f!=null)
                    f.close();
            } catch (IOException ex) {
            }
        }
    }   
    
//    public void save1() {
//        ArrayList<Author> a = new ArrayList<>();
//        a.add(new Author(1, "A"));
//        a.add(new Author(2, "B"));
//        a.add(new Author(3, "C"));
//        FileOutputStream f = null;
//        try {
//            f = new FileOutputStream("author.dat");
//            ObjectOutputStream o = new ObjectOutputStream(f);
//            o.writeObject(a);
//        } catch (IOException ex) {
//            System.out.println("===== Error =====\n" + ex.getMessage());
//        } finally {
//            try {
//                f.close();
//            } catch (IOException ex) {
//            }
//        }
//
//    }

    Book searchBook(String ISBN) {
        for (Book i : books) {
            if (i.getISBN().equals(ISBN)) {
                return i;
            }
        }
        return null;
    }
    
    Book searchBook(int authorID) {
        for(Book i:books) {
            if(i.getAuthorID()==authorID) {                
                return i;
            }
        }
        return null;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public HashMap<Integer, String> getAuthors() {
        return authors;
    }
       
}//end
