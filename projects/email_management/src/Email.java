
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Email {
    private final String firstName;
    private final String lastName;
    private String password;
    private final String email;
    private final String department;
    private int mailBoxCapacity;
    private String alternateEmail;
    private String companySuffix = "company.com";

    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName  = lastName;
        this.department = setDepartment();
        this.password = generateRandomPassword(8);
        this.email = setEmail(this.firstName, this.lastName, this.department, this.companySuffix).toLowerCase();
    }

    private String setDepartment() {
        System.out.println("DEPARTMENT CODES");
        System.out.println("1 for Sales\n2 for Development\n3 for accounting\n0 for none");
        System.out.println("Enter department code");
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        
        try {
        int depChoice = sc.nextInt();
             
        return switch (depChoice) {
                case 1 -> "Sales";
                case 2 -> "Development";
                case 3 -> "Accounting";
                default -> "";
            };
        } catch(NoSuchElementException e) {
            System.out.println("Invalid input. Defaulting to no department.");
            return "";
        }
    }

    private String generateRandomPassword(int length) {
        String passwordCharSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ@!#$%abcdefghijklmnopqrstuvwxyz";
        char[] passWrd = new char[length];

        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random()* passwordCharSet.length());
            passWrd[i] = passwordCharSet.charAt(rand);
        }
        return new String(passWrd);
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    private String setEmail(String fname, String lName, String department, String companySuffix) {
        if (department.length() == 0)
            return fname + lName + "@" + companySuffix;
        else 
            return fname + lName + "@" + department + "." + companySuffix;
    }

    public String getEmail() {
        return this.email;
    }


    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getDepartment() {
        return this.department;
    }


    public int getMailBoxCapacity() {
        return this.mailBoxCapacity;
    }

    public void setMailBoxCapacity(int mailBoxCapacity) {
        this.mailBoxCapacity = mailBoxCapacity;
    }

    /**
     * Retrieves the alternate email address for the user.
     *
     * @return the alternate email address as a string
     */
    public String getAlternateEmail() {
        return this.alternateEmail;
    }

    public void setAlternateEmail(String alternateEmail) {
        this.alternateEmail = alternateEmail;
    }

    public void setCompanySuffix(String companySuffix) {
        this.companySuffix = companySuffix;
    }

    public void showDetails() {
        String name = getFirstName() + " " + getLastName();
        String emailAddress = getEmail();
        int capacity = getMailBoxCapacity();
        System.out.println("Fullname: " + name + "\nEmail address: " + emailAddress + "\nMailbox Capacity: " + capacity);
    }
}
