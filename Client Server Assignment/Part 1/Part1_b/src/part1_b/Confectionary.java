
package part1_b;

/**
 *
 * @author Ben Morrison
 */
public class Confectionary implements Stock {

    private final int id;
    private final String description;
    private int number;
    private String expire;
    
    public Confectionary(int id, String description, int number, String expire) {
        this.id = id;
        this.description = description;
        this.number = number;
        this.expire = expire;
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
    
}
