
package part1_d;

import java.util.ArrayList;
import java.io.*;

/**
 *
 * @author Ben Morrison
 */
public class Part1_d {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Stock> stock = new ArrayList<Stock>();
        
        System.out.println(args[0]);
        
        try {
            File file = new File(args[0]);
            FileReader reader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(reader);
            
            String newline = bufferedReader.readLine();
            
            while(newline != null) {
                if(newline.equals("c")) {
                    Confectionary c;
                    
                    int id = Integer.parseInt(bufferedReader.readLine());
                    String description = bufferedReader.readLine();
                    int number = Integer.parseInt(bufferedReader.readLine());
                    String expire = bufferedReader.readLine();
                    
                    c = new Confectionary(id, description, number, expire);
                    
                    stock.add(c);
                }
                if(newline.equals("s")) {
                    SoftDrink s;
                    
                    int id = Integer.parseInt(bufferedReader.readLine());
                    String description = bufferedReader.readLine();
                    int number = Integer.parseInt(bufferedReader.readLine());
                    int packageNumber = Integer.parseInt(bufferedReader.readLine());
                    
                    s = new SoftDrink(id, description, number, packageNumber);
                    
                    stock.add(s);
                }
                
                newline = bufferedReader.readLine();
            }
        }
        catch(FileNotFoundException fnfe) {
            System.out.println(fnfe.getMessage());
        }
        catch(IOException ioe) {
            System.out.println(ioe.getMessage());
        }

        System.out.println("Confectionary:");
        for(Stock s : stock) {
            if(s instanceof Confectionary) {
                System.out.print(s.getID() + ", ");
                System.out.print(s.getDescription() + ", ");
                System.out.print(s.number() + ", ");
                System.out.println(((Confectionary)s).getExpiryDate());
                
            }
        }
        
        System.out.println();
        
        System.out.println("Confectionary:");
        for(Stock s : stock) {
            if(s instanceof SoftDrink) {
                System.out.print(s.getID() + ", ");
                System.out.print(s.getDescription() + ", ");
                System.out.print(s.number() + ", ");
                System.out.println(((SoftDrink)s).getPackageNumber());
                
            }
        }
    }
}
