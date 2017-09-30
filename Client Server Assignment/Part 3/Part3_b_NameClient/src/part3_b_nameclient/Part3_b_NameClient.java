
package part3_b_nameclient;

import java.io.*;
import java.net.*;

/**
 *
 * @author Ben Morrison
 */
public class Part3_b_NameClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
            // Make connection to server
            Socket socket = new Socket(InetAddress.getByName(args[0]), 2015);
            System.out.println("Connection to server made");
            
            // Create readers and writers for the server and keyboard
            BufferedReader serverReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedReader keyboardReader = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter writer = new PrintWriter(socket.getOutputStream());
            
            int selection = 0;
            
            // Chooses what to do based on the users menu selection
            while(selection != 5) {

                System.out.println("Name Saver Server Menu \n");

                System.out.println("1. Add a name");
                System.out.println("2. Remove a name");
                System.out.println("3. List all names");
                System.out.println("4. Check if a name recorded");
                System.out.println("5. Exit \n");

                System.out.println("Enter selection [1-5]:");

                try {
                    // Gets the selection from the user
                    selection = Integer.parseInt(keyboardReader.readLine());

                    switch(selection) {
                        case 1:
                            addName(writer, serverReader, keyboardReader);
                            break;
                        case 2:
                            removeName(writer, serverReader, keyboardReader);
                            break;
                        case 3:
                            listNames(writer, serverReader);
                            break;
                        case 4:
                            checkName(writer, serverReader, keyboardReader);
                            break;
                        case 5:
                            System.out.println("Closing...");
                            close(writer);
                            break;
                        default:
                            System.out.println("Invalid selection");
                            break;
                    }
                }
                catch(IOException ioe) {
                    System.out.println(ioe.getMessage());
                }
                catch(NumberFormatException nfe) {
                    System.out.println("Selection not entered correctly");
                }
            }
            
            socket.close();
        }
        catch(IOException ioe) {
            System.out.println(ioe.getMessage());
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    // Adds a name to the server
    public static void addName(PrintWriter writer, BufferedReader serverReader, BufferedReader keyboardReader) throws IOException {
        writer.println("addname");
        
        System.out.println("Enter the name you want to add to the server");
        writer.println(keyboardReader.readLine());
        System.out.println("Name added to server");
        writer.flush();
    }
    
    // Removes a name from the server
    public static void removeName(PrintWriter writer, BufferedReader serverReader, BufferedReader keyboardReader) throws IOException {
        writer.println("removename");
        
        System.out.println("Enter the name you want to remove from the server");
        writer.println(keyboardReader.readLine());
        writer.flush();
        
        // Response from the server (success/fail)
        System.out.println(serverReader.readLine());     
    }
    
    // List all the names on the server
    public static void listNames(PrintWriter writer, BufferedReader reader) throws IOException {
        writer.println("listnames");
        
        writer.flush();
        int count = Integer.parseInt(reader.readLine());
        System.out.println("Printing " + count + " names");
        
        for(int i = 0; i < count; i++) {
            System.out.println(reader.readLine());
        }
    }
    
    // Check is a name exists on the server and how many times
    public static void checkName(PrintWriter writer, BufferedReader serverReader, BufferedReader keyboardReader) throws IOException {
        writer.println("checkname");
        
        System.out.println("Enter the name you want to check on the server");
        
        String name = keyboardReader.readLine();
        
        writer.println(name);
        writer.flush();
        
        System.out.println("The name " + name + " is on the server " + Integer.parseInt(serverReader.readLine()) + " times");
    }
    
    // Tell the server the session is closing
    public static void close(PrintWriter writer) throws IOException {
        writer.println("close");
        writer.flush();
    }
}


    
