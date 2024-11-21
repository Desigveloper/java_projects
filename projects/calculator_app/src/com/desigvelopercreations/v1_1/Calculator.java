package com.desigvelopercreations.v1_1;

public abstract class Calculator implements CalculatorInterface{
    @Override
    public double add(double num1, double  num2) {
        return num1 + num2;
    }

    @Override
    public double  subtract(double  num1, double  num2) {
        return num1 - num2;
    }

    @Override
    public double multiply(double  num1, double  num2) {
        return num1 * num2;
    }

    @Override
    public double divide(double num1, double num2) {
        return num1 / num2;
    }


    @Override
    public double  modulo(double  num1, double  num2) {
        return num1 % num2;
    }
}