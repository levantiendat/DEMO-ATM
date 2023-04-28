package Models;

public class PinChangeModel {
    public void changePassword(Card s){
        ConnectData db=new ConnectData();
        db.changePassword(s);
    }
}
