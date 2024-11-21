package com.desigvelopercreations.v1_1;

import static java.lang.System.exit;

public class BasicCalculator extends Calculator {    
    @Override
    public double divide(double num1, double num2) {
        if (num2 != 0) {
            double result = num1 / num2;
            if (result == (int) result) {
                return (int) result;
            }
            else {
                return result;
            }
        }
        else {
            throw new ArithmeticException("Cannot divide by zero");
        }
    }

    public double parseNumber(String input) {
        try {
             return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException ex) {
                System.out.println("Invalid input");
                return 0;
            }
        }
    }


    public double doCalculation(int op, double num1, double num2)  {
        double result;
        result = switch (op) {
            case 1 -> add(num1, num2);
            case 2 -> subtract(num1, num2);
            case 3 -> multiply(num1, num2);
            case 4 -> divide(num1, num2);
            case 5 -> modulo(num1, num2);
            default -> 0;
        };
        
        if (result == 0)
            exit(0);

        return result;
    }
}
