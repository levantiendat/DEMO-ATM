package Controllers;

import Models.Account;
import Models.Card;
import Models.DetailModel;

import java.sql.SQLException;

public class DetailController {
    public Account getAccount(Card s) throws SQLException {
        DetailModel model=new DetailModel();
        return model.getAccount(s);
    }
}
