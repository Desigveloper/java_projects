package statisticCalculator;

/*
 * A program that calculates the standard deviation, mean, and median of a given set of numbers.
 * The program should take input from the user for the array of numbers and display the calculated statistics
*/

import java.util.ArrayList;
import java.util.Scanner;


public class StatisticCalcTestDrive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<Integer>();
        int el;
        StatisticCalc calc = new StatisticCalc();


        System.out.println("Enter number of elements");
        int numOfelements = sc.nextInt();

        do {
            if (arr.size() > 0) {
                System.out.println("Enetr next element (number): ");
            }
            else {
                System.out.println("Enter first (number): ");
            }
            el = sc.nextInt();
            arr.add(el);
            numOfelements--;
        } while (numOfelements > 0);

        double mean = calc.calcMean(arr);
        System.out.println("Mean: " + mean);
        
        double standard_deviation = calc.calcStandardDeviation(arr, mean);
        System.out.println("Standard deviation: " + standard_deviation);

        double median = calc.calcMedian(arr);
        System.out.println("Median: " + median);

        sc.close();
    }
}

