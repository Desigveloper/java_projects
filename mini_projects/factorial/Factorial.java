package mini_projects.factorial;

import java.util.Scanner;
/**
 * Class: Factorial
 * 
 * Description: This class calculates the factorial of a given number input by the user.
 *              It takes an integer input from the user, checks if it's negative, zero, or one,
 *              and then calculates the factorial using a loop for numbers greater than one.
 *              The result is then printed to the console.
 * 
 * Methods:
 *  - main(String[] args): The main method of the class that takes user input, calculates the factorial,
 *                        and prints the result to the console.
 */
public class Factorial {
    public static void main(String[] args) {
        int fact = 1;
        Scanner sc = new Scanner(System.in);
        int nthNumber = sc.nextInt();

        if (nthNumber < 0) {
            System.out.println(-1);
        }
        
        else if (nthNumber == 0 || nthNumber == 1) {
            System.out.println(fact);
        }
        else {
             for (int i = 1; i <= nthNumber; i++) {
                fact = fact * i;
            }

            System.out.println(fact);
        }
        sc.close();
    }
}