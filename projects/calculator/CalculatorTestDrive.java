package projects.calculator;

import java.util.Scanner;

public class CalculatorTestDrive {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator calc;

        System.out.println("Enter Operator +, -, *, /, %:");
        char op = sc.next().charAt(0);

        System.out.println("Enter the first number:");
        double num1 = sc.nextDouble();
        
        System.out.println("Enter the second number:");
        double num2 = sc.nextDouble();

        calc = new Calculator(num1 , op, num2);

        double doubleValue = calc.getResult();
        boolean checkResult = calc.checkDecimal(doubleValue);
        
        if (checkResult) {
            System.out.println(num1 + " " + op + " " + num2 + " = " + doubleValue);
        }
        else {
            long intResult = Math.round(doubleValue);
            long intNum1 = Math.round(num1);
            long intNum2 = Math.round(num2);
            System.out.println(intNum1 + " " + op + " " + intNum2 + " = " + intResult);
        }

        sc.close();
    }
}