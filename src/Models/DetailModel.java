package Models;

import java.sql.SQLException;

public class DetailModel {
    public Account getAccount(Card s) throws SQLException {
        ConnectData db=new ConnectData();
        return db.showAccount(s);
    }
}
