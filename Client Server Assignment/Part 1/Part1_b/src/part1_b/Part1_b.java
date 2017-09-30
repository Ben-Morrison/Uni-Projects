
package part1_b;

/**
 *
 * @author Ben Morrison
 */
public class Part1_b {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Confectionary[] con = new Confectionary[3];

        con[0] = new Confectionary(1, "Snakes", 6, "2/7/2016");
        con[1] = new Confectionary(2, "Chocolate", 3, "8/12/2015");
        con[2] = new Confectionary(3, "Licorice", 5, "3/1/2018");

        for (Stock c : con) {
            System.out.println(c.getID());
            System.out.println(c.getDescription());
        }
    }
}
