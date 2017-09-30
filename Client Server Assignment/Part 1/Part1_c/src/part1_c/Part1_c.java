
package part1_c;

/**
 *
 * @author Ben Morrison
 */
public class Part1_c {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Confectionary test1 = new Confectionary(1, "Snakes", 6, "2/7/2016");
        SoftDrink test2 = new SoftDrink(12, "Coke", 6, 24);
        
        System.out.println(returnStockDetails(test1));
        System.out.println(returnStockDetails(test2));
    }
    
    public static String returnStockDetails(Stock s) {
        return "Stock ID: " + s.getID() + "\n" +
               "Description: " + s.getDescription();
    }
}
