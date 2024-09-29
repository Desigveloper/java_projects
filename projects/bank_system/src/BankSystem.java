

public abstract class BankSystem implements BankManagementSystem {
    
    static {
        System.out.println("ABC BANK LIMITED");
    }

    /**
    * Starts the application or process.
    * This method should be implemented to initialize and begin the main
    * functionality of the application or process.
    */
    public void start() {
         System.out.println("Welcome to ABC Bank Management System");
        System.out.println("Select Option from the menu");
    }

    /**
    * Displays the menu options to the user.
    * This method should be implemented to show the available choices
    * or actions that the user can take within the application.
    */
    public void menu() {
        System.out.println("1. Create Account");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Check Balance");
        System.out.println("5. Exit");
    }

    /**
    * Exits the current process or application.
    * This method should be called to perform any necessary cleanup before termination.
    */
    public void exit() {
        System.out.println("Thank you for using ABC Bank Management System");
        System.exit(0);        
    } 
}