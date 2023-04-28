package Controllers;

import Models.Card;
import Models.DepositModel;
import Models.WithDrawModel;

public class DepositController {
    public void deposit(Card s){
        DepositModel model=new DepositModel();
        model.deposit(s);
    }
}
