package Controllers;

import Models.Card;
import Models.LoginModel;

import java.sql.SQLException;

public class LoginController {
    public Card CheckAccount(String CardNumber,String Password) throws SQLException {
        LoginModel model=new LoginModel();
        Card s=model.CheckAccount(CardNumber,Password);
        return s;
    }
}
