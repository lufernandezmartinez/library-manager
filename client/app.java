package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Scanner;

public class app {
    static Scanner keyboard = new Scanner(System.in);
    public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException, InterruptedException{
        String port="";
        String ipaddr="";
        Socket socket = null;
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        boolean continueLoop = true;
        boolean continueAsking = true;
        String message="0";
        InetAddress host;
        System.out.println("Give me the ip to connect (leave empty for localhost)");
        ipaddr = keyboard.nextLine();
        if(ipaddr == "" | ipaddr == "\n"){
            host = InetAddress.getLocalHost();
        }else{
            host = InetAddress.getByName(ipaddr);
        }
        System.out.println("Give me the port to listen (leave empty for 1234)");
        port = keyboard.nextLine();
        if (port == "" | port == "\n"){
            port = "1234";
        }
        try {
        do{
            socket = new Socket(host.getHostName(),Integer.parseInt(port));
            oos = new ObjectOutputStream(socket.getOutputStream());            
            oos.writeObject(message);
            ois = new ObjectInputStream(socket.getInputStream());
            message = (String) ois.readObject();
            System.out.println(message);
            ois.close();
            oos.close();
            System.out.println("Select an option or type 0 to show menu again.:");
            continueAsking = true;
            do{
                message = keyboard.nextLine();
                if(message.length() > 0){
                    continueAsking = false;
                }
            }while(continueAsking);

            switch (message) {
                case "2": // ADDBOOK
                    System.out.println("Adding book.\nGive me the book name\n");
                    String name = keyboard.nextLine();
                    System.out.println("Give me the book author\n");
                    String author = keyboard.nextLine();
                    message=message+name+"|"+author;
                    break;
                case "3": // DELETE BOOK
                    System.out.println("Deleting book.\nGive me the book id");
                    String index = keyboard.nextLine();
                    message=message+index;
                    break;
                case "8":
                    continueLoop = false;
                    break;
                default:
                    break;
            }
            Thread.sleep(100);
        }while(continueLoop);
        System.out.println("Closing connection...");
        try {
            socket.close();
            System.out.println("Succesfully closed connection");
        } catch (Exception e) {
            System.out.println("Error while closing connection -> "+ e.toString());
        }} catch (Exception e) {
            System.err.println("Error: Could not connect to host");
        }
    }
    }
