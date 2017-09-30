
package part3_a_client;

import java.net.*;
import java.io.*;

/**
 *
 * @author Ben Morrison
 */
public class Part3_a_client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Enter \"yes\" or \"no\"");
        
        try {
            // Create the socket for sending packets
            DatagramSocket socket = new DatagramSocket(2014);
            
            // Get input from the user and convert to bytes
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            byte[] bytes = reader.readLine().getBytes();
                        
            // Creatr the packet to send to server
            DatagramPacket packet = new DatagramPacket(bytes, bytes.length, InetAddress.getByName(args[0]), 2015);
            
            // Send packet to server
            socket.send(packet);
            socket.close();
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
