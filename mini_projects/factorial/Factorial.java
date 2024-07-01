package mini_projects.factorial;
/**
 * Program: factorial.java
 * Desc: factorial - calculates the fatorial of agiven number
 */

import java.util.Scanner;

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