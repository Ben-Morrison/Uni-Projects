
package part1_c;

/**
 *
 * @author Ben Morrison
 */
public interface Stock {
    public int getID(); // Get stock ID
    public String getDescription(); // Get stock description
    public int number(); // Get number of items
    public void setNumber(int num); // Update number in stock
}
