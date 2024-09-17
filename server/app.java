package server;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

// Author       -> Luis Fernandez Martinez
// Last update  -> 17/09/2024

import server.modules.Book;
import server.modules.Bookshelf;
public class app{
    private static ServerSocket server;
    private static int port = 1234;
    public static void main(String[] args) throws IOException{
        Book b1 = new Book(1, "El ingenioso hidalgo de la mancha", "Miguel de Cervantes Saavedra");
        Book b2 = new Book(2,"La metamorfosis", "Franz Kafka");
        Book b3 = new Book(3,"Libro de ejemplo", "John Doe");
        Bookshelf bookshelf = new Bookshelf();
        bookshelf.addBook(b1);
        bookshelf.addBook(b2);
        bookshelf.addBook(b3);

        server = new ServerSocket(port);
        while(true){
            System.out.println("Waiting for the client request");
            Socket socket = server.accept();
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            String message="";
            try {
                message = (String) ois.readObject();//convert ObjectInputStream object to String

            } catch (Exception e) {
                System.out.println("Error "+ e.getMessage() + " when recieving message");
            }
            System.out.println("We recieved a message!: " + message);
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());//create ObjectOutputStream object
            switch (message.charAt(0)+"") {
                case "0": // SHOW MENU
                System.out.println("Returning menu...");
                    message=
                        "\n-- DIGITAL LIBRARY --"+
                        "\n 0.- Show menu (again)"+
                        "\n 1.- List all books"+
                        "\n 2.- Add a book"+
                        "\n 3.- Delete a book"+
                        "\n 4.- Load data from file"+
                        "\n 5.- Save data to file"+                        
                        "\n 6.- Clear loaded data"+
                        "\n 7.- Clear data file"+
                        "\n 8.- Quit"
                    ;
                    break;
                case "1": // LIST BOOKS
                    message = bookshelf.listBooks();
                    break;
                case "2": // ADD BOOKS
                    Book b = Bookshelf.validateBook(message);
                    if(b.getName().length() != 0){
                        b.setId(Bookshelf.getLastID(bookshelf));
                        bookshelf.addBook(b);
                        message="Book "+b.getName()+" added succesfully";
                    }else{
                        message="Error while adding the book. Check any spell error.";
                    }
                    break;
                case "3":
                try {
                    if(bookshelf.removeBook(Integer.parseInt(message.substring(1,message.length())))){
                        message = "Book removed succesfully";}
                } catch (Exception e) {
                    message = "Error while deleting book " +e;
                }
                    break;
                case "4":

                    break;
                case "5":

                    break;
                case "6":

                    break;
                case "7":

                    break;
                case ("8"):
                    //TBH you shouldnt get here at any point
                    message = "Exit option";
                default:
                    message = "Invalid option";
                    break;
            }
            oos.writeObject(message);//write object to Socket


            //close resources
            ois.close();
            oos.close();
            socket.close();
            //terminate the server if client sends exit request
            if(message.equalsIgnoreCase("8")) break;
        }
        System.out.println("Shutting down Socket server!!");
        //close the ServerSocket object
        server.close();
    }
}