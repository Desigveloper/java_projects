
public class EmailApp {
    public static void main(String[] args) {
        Email email = new Email("Abraham", "Mensa");
        email.setAlternateEmail("abrahammensah@gmail.com");
        email.setMailBoxCapacity(300);

        email.showDetails();

        Email newEmail = new Email("Ayisi", "Fred");
        newEmail.showDetails();

    }
}
