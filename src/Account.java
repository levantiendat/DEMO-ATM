import java.util.Calendar;

public class Account {
    private String CardID;
    private String Password;
    private String Name;
    private Calendar DateOfBirth;
    private String CitizenID;
    private String Type;
    private double Amount;

    public Account() {
    }

    public Account(String cardID, String password, String name, Calendar dateOfBirth, String citizenID, String type, double amount) {
        CardID = cardID;
        Password = password;
        Name = name;
        DateOfBirth = dateOfBirth;
        CitizenID = citizenID;
        Type = type;
        Amount = amount;
    }

    public String getCardID() {
        return CardID;
    }

    public String getPassword() {
        return Password;
    }

    public String getName() {
        return Name;
    }

    public Calendar getDateOfBirth() {
        return DateOfBirth;
    }

    public String getCitizenID() {
        return CitizenID;
    }

    public String getType() {
        return Type;
    }

    public double getAmount() {
        return Amount;
    }

    public void setCardID(String cardID) {
        CardID = cardID;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setDateOfBirth(Calendar dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public void setCitizenID(String citizenID) {
        CitizenID = citizenID;
    }

    public void setType(String type) {
        Type = type;
    }

    public void setAmount(double amount) {
        Amount = amount;
    }
}
