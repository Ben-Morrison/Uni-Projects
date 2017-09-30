package part1_a;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author Ben Morrison
 */
public class Part1_a {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Creates a bufferedreader to read keyboard input
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        // Counts the numbers entered
        int count = 0;
        
        // The keyboard input
        String input = "";
        
        // The array for entered numbers
        int[] numbers = new int[10];
        
        // Max 10 numbers, stops when nothing is entered
        do
        {            
            int num1;
            int num2;
            
            try {
                System.out.println("Enter two numbers seperated by a space");
                input = reader.readLine();
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
            
            if(!input.contains(" ")) {
                System.out.println("Error");
            }
            else {
                try {
                    // Splits the 2 numbers in the string and puts them into seperate integers
                    num1 = Integer.parseInt(input.substring(0, input.indexOf(" ")));
                    num2 = Integer.parseInt(input.substring(input.indexOf(" ") +1, input.length()).trim());

                    // Adds the integers to the array
                    numbers[count] = num1;
                    count++;
                    numbers[count] = num2;
                    count++;
                }
                catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }            
        } while(count < 10 && !input.trim().equals(""));
        
        System.out.println("There were " + count + " numbers entered");
        
        int max = 0;
        int min = numbers[0];
        
        // Finds the max number
        for(int i = 0; i < count; i++) {
            if(numbers[i] > max)
                max = numbers[i];
        }

        // Finds the min number
        for(int i = 0; i < count; i++) {
            if(numbers[i] < min)
                min = numbers[i];
        }

        // Prints the results
        System.out.println("Maximum = " + max);
        System.out.println("Minimum = " + min);
    }
    
}
