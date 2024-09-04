package passport;

public class PassportTestDrive{
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