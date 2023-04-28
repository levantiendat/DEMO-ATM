package Controllers;

import Models.Card;
import Models.WithDrawModel;

public class WithDrawController {
    public void withdraw(Card s){
        WithDrawModel model=new WithDrawModel();
        model.withdraw(s);
    }
}
