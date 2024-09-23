package passport;

/**
 * Passport information class that encapsulates passport details.
 * 
 * @author Desigveloper
 * @version 1.0
 */
public abstract class PassportInfo {
    /**
     * Full name of the passport holder
     */
    protected String fullName;
    /**
     * Passport id of the passport holder
     */
    protected String passportID;
    /**
     * Country of the passport holder
     */
    protected String country;
    /**
     * Country code of the passport holder
     */
    protected String countryCode;
    /**
     * Passport status of the passport holder
     */
    protected String status;
    /**
     * Date of birth of the passport holder
     */
    protected String dateOfBirth;
    
    /**
     * Abstract method to get the input from the user
     */
    public abstract void getInput();
    
    /**
     * Sets the full name of the passport holder
     * @param name the full name of the passport holder
     */
    public void setFullName(String name) {
        this.fullName = name;
    }
    
    /**
     * Sets the passport id of the passport holder
     * @param passportID the passport id of the passport holder
     */
    public void setPassportID(String passportID) {
        this.passportID = passportID;
    }
    
    /**
     * Sets the date of birth of the passport holder
     * @param dateOfBirth the date of birth of the passport holder
     */
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    
    /**
     * Sets the passport status of the passport holder
     * @param status the passport status of the passport holder
     */
    public void setStatus(String status) {
        this.status = status;
    }
    
    /**
     * Sets the country code of the passport holder
     * @param countryCode the country code of the passport holder
     */
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
    
    /**
     * Sets the country of the passport holder
     * @param country the country of the passport holder
     */
    public void setCountry(String country) {
        this.country = country;
    }
}
