package com.desigvelopercreations.v1_0;
import java.util.Scanner;

public class Calculator {
    private double result;
    private double firstNum;
    private double secondNum;
    private char op;

    Calculator() {
    
    }

    private void doCalculation(double firstNum, char op, double secondNum) {
        switch (op) {
            case '+':
                setResult(firstNum + secondNum);
                break;
            case '-':
                setResult(firstNum - secondNum);
                break;
            case '*':
                setResult(firstNum * secondNum);
                break;
            case '/':
                setResult(firstNum / secondNum);
                break;
            case '%':
                setResult(firstNum % secondNum);
                break;
            default:
                break;
        }
    }

    public void getInputs() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Operator +, -, *, /, %:");
        setOp(sc.next().charAt(0));

        System.out.println("Enter the first number:");
        setFirstNum(sc.nextDouble());
        
        System.out.println("Enter the second number:");
        setSecondNum(sc.nextDouble());


        sc.close();

    }

    private void setFirstNum(double num) {
        this.firstNum = num;
    }
    private double getFirstNum() {
        return firstNum;
    }

    
    private void setSecondNum(double num) {
        this.secondNum = num;
    }
    private double getSecondNum() {
        return secondNum;
    }

    private void setOp(char op) {
        this.op = op;
    }
    private char getOp() {
        return op;
    }

    private void setResult(double result) {
        this.result = result;
    }

    private double getResult() {
        return result;
    }

    private boolean checkDecimal(double result) {
        return result != Math.floor(result);
    }

    private int checkNumbers() {
        double num1 = getFirstNum();
        double num2 = getSecondNum();
        long intNum1 = Math.round(num1);
        long intNum2 = Math.round(num2);

        
        if (intNum1 == num1 && intNum2 == num2)
            return 0;
        else if (intNum1 == num1 && intNum2 != num2)
            return 1;
        else if (intNum1 != num1 && intNum2 == num2)
            return 2;
        else
            return 100;
    }

    public void printResult() {
        double num1 = getFirstNum();
        double num2 = getSecondNum();
        char operator = getOp();

        doCalculation(num1, operator, num2);

        double doubleValue = getResult();
        boolean checkResult = checkDecimal(doubleValue);
        
        if (checkResult) {
            switch (checkNumbers()) {
                case 0:
                    System.out.println(Math.round(num1) + " " + operator + " " + Math.round(num2) + " = " + doubleValue);
                    break;
                case 1:
                    System.out.println(Math.round(num1) + " " + operator + " " + num2 + " = " + doubleValue);
                    break;
                case 2:
                    System.out.println(num1 + " " + operator + " " + Math.round(num2) + " = " + doubleValue);
                    break;
                default:
                    System.out.println(num1 + " " + operator + " " + num2 + " = " + doubleValue);
                    break;
            }
        }
        else {
            long intResult = Math.round(doubleValue);
            long intNum1 = Math.round(num1);
            long intNum2 = Math.round(num2);
            System.out.println(intNum1 + " " + op + " " + intNum2 + " = " + intResult);
        }
    }
}
