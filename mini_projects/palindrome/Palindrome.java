package palindrome;

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter String: ");
            String input = sc.nextLine();
            
            Palindrome str = new Palindrome();
            String newStr = str.reverseString(input);
            boolean isPalindrome = str.compareStr(input, newStr);

            if (isPalindrome)
                System.out.println(input + ":" + newStr + ". Hence is a palindrome");
            else System.out.println(input + "not equal " + newStr + ". Hence is not a palindrome");
        }
    }

    String reverseString(String str) {
        int strLen = str.length();
        String reversed = "";

        for (int i = strLen - 1; i >= 0; i--){
            reversed += str.charAt(i);
        }
        return reversed;
    }

    boolean compareStr(String oldStr, String newStr) {
        return oldStr.equals(newStr);
    }
}
