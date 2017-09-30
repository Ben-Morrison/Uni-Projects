
package part1_c;

/**
 *
 * @author Ben Morrison
 */
public class SoftDrink implements Stock {
    private final int id;
    private final String description;
    private int number;
    private final int packageNumber;
    
    public SoftDrink(int id, String description, int number, int packageNumber) {
        this.id = id;
        this.description = description;
        this.number = number;
        this.packageNumber = packageNumber;
    }
    
    public int getID() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public int number() {
        return number;
    }

    public void setNumber(int num) {
        this.number = num;
    }
    
    public int getPackageNumber() {
        return packageNumber;
    }
}
