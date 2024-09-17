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
    private ArrayList<Book> getBookshelf(){
        return this.bookshelf;
    }
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
                booklist = booklist + "\n"+b.getId() + " | " + b.getName() +" | "+b.getAuthor();
            }
            return booklist;
        }
    }
    public static int getLastID(Bookshelf b){
        try {
            Book book = b.bookshelf.get(b.getBookshelf().size()-1);
            return book.getId()+1;
        } catch (Exception e) {
            return 0;
        }
    }
    public static Book validateBook(String message){
        Book b = new Book();
        String name = "";
        String author = "";
        // Book syntax
        // name|author
        message = message.substring(1,message.length()); // remove option number
        for(int i=0;i<message.length();i++){
            if(message.charAt(i)=='|'){
                name = message.substring(0,i);
                author = message.substring(i+1,message.length());
            }
        }
        if(name.length()!=0 && author.length() != 0){
            b.setName(name);
            b.setAuthor(author);
        }
        return b;
    }
}
