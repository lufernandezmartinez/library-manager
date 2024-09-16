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
        InetAddress host = InetAddress.getLocalHost(); // Local as temp example
        Socket socket = null;
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        Boolean continueLoop = true;
        String opc= "menu";

        socket = new Socket(host.getHostName(), 1234);
        oos = new ObjectOutputStream(socket.getOutputStream());
        oos.writeObject(opc);
        ois = new ObjectInputStream(socket.getInputStream());
        String message = (String) ois.readObject();
        ois.close();
        oos.close();
        Thread.sleep(100);
        System.out.println(message);
        do {
            System.out.println("Select an option: ");
            opc = keyboard.nextLine();
            oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(opc);
            ois = new ObjectInputStream(socket.getInputStream());
            message = (String) ois.readObject();
            System.out.println(message);
        } while (continueLoop);
            //close resources
            ois.close();
            oos.close();
            socket.close();
        }
    }
