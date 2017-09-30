
package part3_b_nameserver;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

/**
 *
 * @author Ben Morrison
 */
public class Part3_b_NameServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // ArrayList for names stored by the server
            ArrayList<String> names = new ArrayList<String>();
            
            // Create server
            ServerSocket server = new ServerSocket(2015);
            System.out.println("Server running, waiting for client");
            
            // Get connection from client
            Socket socket = server.accept();
            System.out.println("Client accepted: " + socket.getInetAddress().toString());
            
            // Create readers and writers for communication with client
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream());
            
            String clientResponse;
            
            while(!(clientResponse = reader.readLine()).equals("close")) {
                switch(clientResponse) {
                    case "addname":
                        // Add name to the arraylist
                        names.add(reader.readLine());
                        System.out.println(names.get(names.size() - 1) + " added to the list of names");
                        break;
                    case "removename":
                        // Remove name from the arraylist
                        if(names.remove(reader.readLine())) {
                            writer.println("Successfully deleted");
                        }else {
                            writer.println("Name not found");
                        }
                        writer.flush();
                        break;
                    case "listnames":
                        // List all names
                        System.out.println("Listing names");
                        writer.println(Integer.toString(names.size()));
                        for(String n : names) {
                            writer.println(n);
                        }
                        writer.flush();
                        break;
                    case "checkname":
                        // Check for a name, and how many times
                        System.out.println("Checking name");
                        String search = reader.readLine();
                        int num = 0;
                        for(String s : names) {
                            if(s.equals(search))
                                num++;
                        }
                        writer.println(Integer.toString(num));
                        writer.flush();
                        break; 
                    default:
                        System.out.println("Invalid response from client");
                        break;
                }
            }
            
            System.out.println("Closing");
            
            // Close the server
            socket.close();
            server.close();
        }
        catch(IOException ioe) {
            System.out.println(ioe.getMessage());
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    
}
