package reverse_string;


import java.util.Scanner;

public class StringReverse {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter String: ");
            String input = sc.nextLine();
            
            StringReverse str = new StringReverse();
            String newStr = str.reverseString(input);
            System.out.println(newStr);
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
}
