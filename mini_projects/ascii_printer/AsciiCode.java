package ascii_printer;

import java.util.Scanner;

class AsciiTestDrive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char min;
        char max;
        AsciiCode codes;

        System.out.println("Enter the beginning Character");
        min = sc.next().charAt(0);
        System.out.println("Enter the ending Character");
        max = sc.next().charAt(0);


        codes = new AsciiCode(min, max);
        codes.printCodes();

        sc.close();
    }
}

public class AsciiCode {
    private char minBoundChar;
    private final char maxBoundChar;

    AsciiCode(char minChar, char maxChar) {
        this.minBoundChar = minChar;
        this.maxBoundChar = maxChar;
    }

    
    public void printCodes() {

        if (minBoundChar <= maxBoundChar) {
            printDownToTop();
        } else {
            printTopToDown();
        }
        

    }

    private void printTopToDown() {
        int i = 1; 
        while(minBoundChar >= maxBoundChar) {
            if (i % 10 == 0)
                System.out.println();
            
            int ascCode = minBoundChar;
            System.out.print(minBoundChar + " = " + ascCode + "\t");
            ++i;
            --minBoundChar;
        }
        System.out.println();
    }

    private void printDownToTop() {
        int i = 1;

        while(minBoundChar <= maxBoundChar) {
            if (i % 10 == 0)    
                System.out.println();
                
            int ascCode = minBoundChar;
            System.out.print(minBoundChar + " = " + ascCode + "\t");
            ++i;
            ++minBoundChar;
        }
        System.out.println();
    }
    
}