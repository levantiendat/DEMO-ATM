package Models;

public class DepositModel {
    public void deposit(Card s){
        ConnectData db=new ConnectData();
        db.changeAmount(s);
    }
}
