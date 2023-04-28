package Models;

import java.sql.SQLException;

public class LoginModel {
    public Card CheckAccount(String CardNumber,String Password) throws SQLException {

        ConnectData db=new ConnectData();
        Card s=db.checkAccount(CardNumber,Password);
        return s;

    }
}
