import java.util.Calendar;

public class Customer {
    private int ID;
    private String Name;
    private Calendar DateOfBirth;
    private String CitizenID;

    public Customer() {
    }

    public Customer(int ID, String name, Calendar dateOfBirth, String citizenID) {
        this.ID = ID;
        Name = name;
        DateOfBirth = dateOfBirth;
        CitizenID = citizenID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Calendar getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(Calendar dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public String getCitizenID() {
        return CitizenID;
    }

    public void setCitizenID(String citizenID) {
        CitizenID = citizenID;
    }
}
