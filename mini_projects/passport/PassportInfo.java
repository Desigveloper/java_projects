package passport;

public abstract class PassportInfo {
    protected String fullName;
    protected String passportID;
    protected String country;
    protected String countryCode;
    protected String status;
    protected String dateOfBirth;
    
    public abstract void getInput();


    public void setFullName(String name) {
        this.fullName = name;
    }

    public void setPassportID(String passportID) {
        this.passportID = passportID;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    
} 