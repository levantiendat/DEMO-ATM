package Controllers;

import Models.Card;
import Models.ConnectData;
import Models.Customer;
import Models.MainModel;

import java.sql.SQLException;

public class MainController {
    public Customer getCustomer(Card s) throws SQLException {
        MainModel model=new MainModel();
        Customer cus=model.getCustomer(s);
        return cus;
    }
}
