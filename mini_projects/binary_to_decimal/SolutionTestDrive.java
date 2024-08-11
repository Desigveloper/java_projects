package binary_to_decimal;

import javax.swing.JOptionPane;



public class SolutionTestDrive {
    /**
     * This is the main function that prompts the user to enter a binary number,
     * converts it to its decimal equivalent, and displays the result in a dialog box.
     *
     * @param  args  the command-line arguments (not used in this function)
     */
    public static void main(String[] args) {
    int binary;
    String binaryStr = JOptionPane.showInputDialog(null,
            "Enter a binary number");

    binary = Integer.parseInt(binaryStr);

    int decimal = IntParameter.binaryToDecimal(binary);
    JOptionPane.showMessageDialog(null, binaryStr + " = " + decimal);       
    }
}
/**
 * Converts a binary number to its decimal equivalent.
 *
 * @param  binary  the binary number to be converted
 * @return         the decimal equivalent of the binary number
 */
class IntParameter {
    private IntParameter() {
        throw new IllegalStateException("Utility class");
    }

    public static int binaryToDecimal(int binary) {
        int decimal = 0;
        int power = 0;

        while (binary != 0) {
            int remainder = binary % 10;
            decimal += remainder * Math.pow(2, power);
            binary = binary / 10; // 
            power++;
        }
        return decimal;
    }
}
