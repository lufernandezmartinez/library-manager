package server.modules;

import java.util.ArrayList;

public class Bookshelf {
    ArrayList<Book> bookshelf;
    int idCont;
    public Bookshelf(){
        this.bookshelf = new ArrayList<Book>();
        this.idCont = 1;
    }

    // BOOKSHELF METHODS
    public boolean addBook(Book book){
        try {
            this.bookshelf.add(book);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean removeBook(int id){
        try {
            int index = 0;
            for (Book book : bookshelf) {
                if (book.getId() == id){
                    bookshelf.remove(index);
                }else{
                    index++;
                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public String listBooks(){
        String booklist ="Index | Name | Author ";
        if (this.bookshelf.isEmpty()){
            return "This bookshelf is empty!";
        }else{
            for (Book b : this.bookshelf) {
                booklist = booklist + "\n"+b.getId() + " " + b.getName() +" "+b.getAuthor();
            }
            return booklist;
        }
    }
}
