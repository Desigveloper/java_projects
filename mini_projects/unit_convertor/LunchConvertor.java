package unit_convertor;

/*
 * Program: Convertor.java
 * DESC: Takes a foot value as input and displays the resulting inch value

 */

import javax.swing.JOptionPane;

public class LunchConvertor {
    public static void main(String[] args) {
        // Display menu option
        Menu.displayMenu();

        JOptionPane.showMessageDialog(null, 
                "\nSelect Option from 1-" + (Menu.menuOptions.length - 1) + ": ");
         int option = Menu.selectOption();
        
         String numString = JOptionPane.showInputDialog(null, "Enter value");
         double number = Double.parseDouble(numString);
        
         double value = Convertor.convert(option, number);
         JOptionPane.showMessageDialog(null,
                    Menu.menuOptions[option] + "\n" + number + " = " + value);
    }    
}

/*
 * Menu class for displaying the starter menu
 * 
 */

 class Menu {

    /* //To be add/implemented later 
             "", // An offset
             "1. Length",
             "2. Width",
             "3. Capacity",
             "4. Temperature"
     */
    private Menu() {
        throw new IllegalStateException("Utility class");
    }
        
        static String[] menuOptions = {
            "", // A offset
            "Feet to Inches", // 1f * 12
            "Inches to Feet", // inc / 12
            "Meters to Kilometers", // m / 1000
            "Kilometers to Meters", // km * 1000
            "Celcius to Fahrenheit", // 1.8 * cel + 32
            "Fahrenheit to Celcius", // cel / 1.8 - 32
            "Mile to Meter", // mile * 1609.344
            "Meter to Mile" // meter / 1609.344
        };

        protected static final String PRINT_MESSAGE = "%s Converting from %s";

        protected static String printMessage(int option) {
            return String.format(PRINT_MESSAGE, menuOptions[option]);
        }

    static int selectOption(){
        String optionStr = JOptionPane.showInputDialog(null,
                "Select Option from 1-" + (menuOptions.length - 1) + ": ");
        int option = Integer.parseInt(optionStr);
        
        switch(option) {
            case 1:
                JOptionPane.showMessageDialog(null,
                    "1. " + printMessage(option));
                break;
            case 2:
                JOptionPane.showMessageDialog(null,
                        "2. " + printMessage(option));
                break;
            case 3:
                JOptionPane.showMessageDialog(null,
                        "3. " + printMessage(option));
                break;
            case 4:
                JOptionPane.showMessageDialog(null,
                        "4. " + printMessage(option));
                break;
            case 5:
                JOptionPane.showMessageDialog(null,
                        "5. " + printMessage(option));
                break;
            case 6:
                JOptionPane.showMessageDialog(null,
                        "6. " + printMessage(option));
                break;
            case 7:
                JOptionPane.showMessageDialog(null,
                        "7. " + printMessage(option));
                break;
            case 8:
                JOptionPane.showMessageDialog(null,
                        "8. " + printMessage(option));
                break;
            default:
                JOptionPane.showMessageDialog(null,
                        "Invalid Option");
                break;
        }
        
        return option;
    }
        
        static void displayMenu() {
            //System.out.println("Unit Conversion. Select Parametter"); // To implemented later
            JOptionPane.showMessageDialog(null, "UNIT CONVERSION - Options");
            
            for(int i = 1; i < menuOptions.length; i++){
                System.out.println(i + ". " + menuOptions[i]);
                }
        }
            
    }

class Convertor {
    private Convertor() {
        throw new IllegalStateException("Utility class");
    }
    static double convert(int option, double input) {
        double result = 0;

        switch (option) {
            case 1:
                result = input * 12;
                break;
            case 2:
                result = input / 12;
                break;
            case 3:
                result = input / 1000;
                break;
            case 4:
                result = input * 1000;
                break;
            case 5:
                result = input * 1.8 + 32;
                break;
            case 6:
                result = (input - 32) / 1.8;
                break;
            case 7:
                result = input * 1609.344;
                break;
            case 8:
                result = input / 1609.344;
                break;
            default:
                break;
        }

        return result;
    }
}
