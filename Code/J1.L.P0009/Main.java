/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1.l.P0009;

/**
 *
 * @author E5450
 */
public class Main {
    public static void main(String[] args) {
        Management m = new Management();
        
        m.readAuthor();
        m.readBook();
        while(true){
            m.menu();
            switch(Validation.intergerValidation("Selection: ", 1, 7, null)){
                case 1:
                    m.displayBook(m.getBooks());
                    break;
                case 2:
                    m.addBook();
                    break;
                case 3:
                    m.updateBook();
                    break;
                case 4:
                    m.deleteBook();
                    break;
                case 5:
                    m.deleteAuthor();
                    break;
                case 6:
                    m.searchBook();
                    break;
                case 7:
                    return;                   
            }
        }
    }
}
