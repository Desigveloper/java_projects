package projects.calculator;

public class Calculator {
    private double result;

    Calculator(double num1, char op, double num2) {
        switch (op) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
            case '%':
                result = num1 % num2;
                break;
            default:
                break;
        }
    }

    double getResult() {
        return result;
    }


    boolean checkDecimal(double result) {
        return result != Math.floor(result);
    }
}
