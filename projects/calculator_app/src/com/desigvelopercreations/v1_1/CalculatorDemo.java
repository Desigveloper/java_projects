package com.desigvelopercreations.v1_1;

import java.util.Scanner;

class CalculatorDemo {
    static {
        System.out.println("Calculator loaded");
        menu();
        System.out.println("Select Option from the menu");
    }


    private static void menu() {
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.println("5. Modulo");
        System.out.println("6. Exit");
    }

    public static void main(String[] args) {
        String[] operator = {"+", "-", "*", "/", "%"};

        BasicCalculator calculator = new BasicCalculator();
        try (Scanner sc = new Scanner(System.in)) {
            int op;
            
            do {
                op = sc.nextInt();
            } while (op < 1 || op > 6);
            
            sc.nextLine(); // Consumes newline leftover to avoid been read by nextLine() call.

            System.out.println("You selected " + op + ". " + Operations.values()[op - 1]);

            System.out.println("Enter first number");
            double num1 = calculator.parseNumber(sc.nextLine());
            
            System.out.println("Enter second number");
            double num2 = calculator.parseNumber(sc.nextLine());
            
            double result = calculator.doCalculation(op, num1, num2);
            
            if (result == (int) result) {
                var fmtResult = (int) result;
                System.out.println((int) num1 + " " + operator[op - 1] + " " + 
                    (int) num2 + " = " + fmtResult);
            }
            else {
                System.out.println(num1 + " " + operator[op - 1] + " " + num2 + " = " + result);
            }
        }
    }
}