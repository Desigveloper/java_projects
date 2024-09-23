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

    /**
     * Retrieves the expiry date of the passport by adding 10 years to the start date.
     *
     * @return The expiry date of the passport as a string.
     */
    public static String getExpiryDate() {
        // Get the start date as a LocalDate object
        LocalDate passportStartDate = LocalDate.parse(getStartDate());
        
        // Calculate the expiry date by adding 10 years to the start date
        LocalDate passportExpiryDate = passportStartDate.plusYears(10);
        
        // Return the expiry date as a string
        return  passportExpiryDate.toString();
    }


    /**
     * Generates a unique passport ID by combining a given country code with a random 9-digit number.
     *
     * @param countryCode The country code to be prefixed to the passport ID.
     * @return A string representing the unique passport ID.
     */
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
   

    @Override
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
   
    

    /**
     * Prints the passport details to the console.
     * The passport details include the full name, date of birth, country,
     * passport ID, start date, expiry date, and status.
     */
    public void printPassport() {
        String personFullName = getFullName();
        String pDateOfBirth = getDateOfBirth();
        String countryName = getCountry();
        String passportId = getPassportID();
        String startDate = getStartDate();
        String expiryDate = getExpiryDate();
        String passportStatus = getStatus();

        // Print the passport details
        System.out.println("Fullname: " + personFullName);
        System.out.println("D.O.B: " + pDateOfBirth);
        System.out.println("Country: " + countryName.toUpperCase());
        System.out.println("PassportID: " + passportId.toUpperCase());
        System.out.println("Start date: " + startDate);
        System.out.println("Expiry date: " + expiryDate);
        System.out.println("Status: " + passportStatus.toUpperCase());
    }

    /**
    * Prints a formatted introduction for passport information summary.
    * The introduction includes a header, the current date, and time.
    */
    public void intro() {
        System.out.println("------------------------------------------------------------------");
        System.out.println("\t\tPASSPORT INFORMATION SUMMERY");
        System.out.println("\tPassport created: " + LocalDate.now() + " @ " + LocalTime.now());
        System.out.println("------------------------------------------------------------------\n");
    }   

}
