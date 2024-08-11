package statisticCalculator;

import java.util.ArrayList;


public class StatisticCalc {
    public double calcMean(ArrayList<Integer> numbers) {
        double mean;
        int sum = 0;
        for (int el : numbers) {
            sum += el;
        }

        mean = sum / (double) numbers.size();
        return mean;
    }

    public double calcStandardDeviation( ArrayList<Integer> numbers, double mean) {
        double deviation, sumOfDeviations = 0, avgOfDeviations = 0;

        if (numbers.size() < 2) {
            return 0;
        }
        
        for (int el : numbers)
        {
            deviation =  Math.pow((el - mean), 2);
            sumOfDeviations += deviation;
        }

        //divide sum  of deviation by (N)
        avgOfDeviations = sumOfDeviations  / (numbers.size() - 1); 
                   
        return Math.sqrt(avgOfDeviations);
    }

    public double calcMedian(ArrayList<Integer> numbers) {
        double median = 0;

        numbers.sort(null);
        if (numbers.size() % 2 != 0) {
            median = numbers.get(numbers.size() / 2);
        }
       else {
            median = ((double) numbers.get(numbers.size() / 2 - 1) + (double) numbers.get(numbers.size() / 2)) / 2;
        }

        return median;
    }
}