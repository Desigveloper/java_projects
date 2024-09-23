package passport;

public class PassportTestDrive{
    /**
    * Static block to print the header for the Passport Registration Form.
    * This block executes when the class is loaded and prints the form's title and instructions.
    */
    static {
        System.out.println("------------------------------------------------------------------");
        System.out.println("\t\tPASSPORT REGISTRATION FORM");
        System.out.println("\t\tEnter person's details as stated below");
        System.out.println("------------------------------------------------------------------\n");
    }
    public static void main(String[] args) {
        Passport passport = new Passport();
        passport.getInput();
        passport.intro();
        passport.printPassport();
    }
}