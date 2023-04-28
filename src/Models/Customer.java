package Models;

import java.sql.Date;
import java.util.Calendar;

public class Customer {
    private int ID;
    private String Name;
    private Date DateOfBirth;
    private String CitizenID;

    public Customer() {
    }

    public Customer(int ID, String name, Date dateOfBirth, String citizenID) {
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

    public Date getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public String getCitizenID() {
        return CitizenID;
    }

    public void setCitizenID(String citizenID) {
        CitizenID = citizenID;
    }
}
