
package part3_a_server;

import java.net.*;

/**
 *
 * @author Ben Morrison
 */
public class Part3_a_server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Receiving packet");
          
        int yes = 0;
        int no = 0;
        
        try {
            // Create socket to receive packets from client
            DatagramSocket socket = new DatagramSocket(2015);
            
            System.out.println("Voting Server " + InetAddress.getLocalHost() + " active on 2015.");

            while(true) {
                // Create array of bytes to hold data from packet
                byte[] bytes = new byte[100];
            
                // Create packet to hold data from client
                DatagramPacket packet = new DatagramPacket(bytes, bytes.length);
                
                // Receive data from client
                socket.receive(packet);
                bytes = packet.getData();
                
                String data = new String(bytes);
                
                if(data.toLowerCase().trim().equals("yes")) {
                    System.out.println("[" + packet.getAddress() + "] \"Yes\" vote received");
                    yes++;
                    System.out.println("So far Yes = " + yes + ", No = " + no);
                }
                else if(data.toLowerCase().trim().equals("no")) {
                    System.out.println("[" + packet.getAddress() + "] \"No\" vote received");
                    
                    no++;
                    System.out.println("So far Yes = " + yes + ", No = " + no);
                }
                else {
                    System.out.println(data);
                    System.out.println("[" + packet.getAddress() + "] **Error** Bad vote String received");    
                }
            }
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}
