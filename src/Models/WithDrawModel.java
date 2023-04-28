package Models;

public class WithDrawModel {
    public void withdraw(Card s){
        ConnectData db=new ConnectData();
        db.changeAmount(s);
    }
}
