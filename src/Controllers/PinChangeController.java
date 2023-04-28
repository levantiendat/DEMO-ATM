package Controllers;

import Models.Card;
import Models.PinChangeModel;

public class PinChangeController {
    public void changePassword(Card s){
        PinChangeModel model=new PinChangeModel();
        model.changePassword(s);
    }
}
