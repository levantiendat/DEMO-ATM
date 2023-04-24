package Models;

public class Card {
    private String CardID;
    private String Password;
    private String AccountID;
    private double Amount;

    public Card() {
    }

    public Card(String cardID, String password, String accountID, double amount) {
        CardID = cardID;
        Password = password;
        AccountID = accountID;
        Amount = amount;
    }

    public String getCardID() {
        return CardID;
    }

    public void setCardID(String cardID) {
        CardID = cardID;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getAccountID() {
        return AccountID;
    }

    public void setAccountID(String accountID) {
        AccountID = accountID;
    }


    public double getAmount() {
        return Amount;
    }

    public void setAmount(double amount) {
        Amount = amount;
    }
}
