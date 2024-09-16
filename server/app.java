package server;
import server.modules.Book;
import server.modules.Bookshelf;
public class app{
    public static void main(String[] args){
        Book b1 = new Book(1, "El ingenioso hidalgo de la mancha", "Miguel de Cervantes Saavedra");
        Book b2 = new Book(2,"La metamorfosis", "Franz Kafka");
        Book b3 = new Book(3,"Libro de ejemplo", "John Doe");
        Bookshelf bookshelf = new Bookshelf();
        bookshelf.addBook(b1);
        bookshelf.addBook(b2);
        bookshelf.addBook(b3);

        System.out.print(bookshelf.listBooks());
        System.out.println("Remove Book at index 2: "+bookshelf.removeBook(2)+"\n");
        System.out.print(bookshelf.listBooks()+"\n");
    }
}