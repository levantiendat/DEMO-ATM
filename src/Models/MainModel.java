package Models;

import java.sql.SQLException;

public class MainModel {
    public Customer getCustomer(Card s) throws SQLException {
        ConnectData db=new ConnectData();
        Customer cus=db.GetCustomer(s);
        return cus;
    }
}
