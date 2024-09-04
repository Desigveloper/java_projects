package passport;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Random;
import java.util.Scanner;

public class Passport extends PassportInfo {
    Scanner sc = new Scanner(System.in);

    static Random rand = new Random();

    public static String getStartDate() {
         return LocalDate.now().toString();
    }

    public static String getExpiryDate() {
        LocalDate strtDate = LocalDate.parse(getStartDate());
        LocalDate expDate = strtDate.plusYears(10);
        return  expDate.toString();
    }


    private static String createPassportID(String countryCode) {
        var digits = rand.nextLong(99999999, 1000000000);
        return countryCode + digits;
    }


    public String getPassportID() {
        return passportID;
    }

    

    public String getFullName() {
        return this.fullName;
    }


    public String getDateOfBirth() {
        return this.dateOfBirth;
    }

    public String getStatus() {
        return this.status;
    }

    
    public String getCountry() {
        return this.country;
    }
   

    public void getInput() {
        System.out.println("Enter fullname:");
        setFullName(sc.nextLine());

        System.out.println("Enter date of birth ie 10/1/2000 0r 10-1-2000:");
        setDateOfBirth(sc.nextLine());

        System.out.println("Enter country");
        setCountry(sc.nextLine());

        System.out.println("Enter country initials");
        setCountryCode(sc.nextLine());

        System.out.println("Enter validity:");
        setStatus(sc.nextLine());

        setPassportID(createPassportID(countryCode));

    }
   
    

    public void printPassport() {
        String name = getFullName();
        String dOBirth = getDateOfBirth();
        String country = getCountry();
        String passportID = getPassportID();
        String startDate = getStartDate();
        String expiryDate = getExpiryDate();
        String status = getStatus();

        System.out.println("Fullname: " + name);
        System.out.println("D.O.B: " + dOBirth);
        System.out.println("Country: " + country.toUpperCase());
        System.out.println("PassportID: " + passportID.toUpperCase());
        System.out.println("Start date: " + startDate);
        System.out.println("Expiry date: " + expiryDate);
        System.out.println("Status: " + status.toUpperCase());

    }

    void intro() {
        System.out.println("------------------------------------------------------------------");
        System.out.println("\t\tPASSPORT INFORMATION SUMMERY");
        System.out.println("\tPassport created: " + LocalDate.now() + " @ " + LocalTime.now());
        System.out.println("------------------------------------------------------------------\n");
    }

}
