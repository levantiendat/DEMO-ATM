package Models;

public class CardType {
    private int ID;
    private String Typename;

    public CardType() {
    }

    public CardType(int ID, String typename) {
        this.ID = ID;
        Typename = typename;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTypename() {
        return Typename;
    }

    public void setTypename(String typename) {
        Typename = typename;
    }
}
