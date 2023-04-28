package Models;

import Views.LoginView;
import com.mysql.jdbc.log.Log;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class ConnectData {
    Statement stmt;


    public ConnectData(){
        Connection();
    }
    public void Connection(){
        try {

            Class.forName("com.mysql.jdbc.Driver");

            String url1="jdbc:mysql://127.0.0.1:3306/data";
            Connection con= DriverManager.getConnection(url1,"root","");
            stmt =con.createStatement();

        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    public Card checkAccount(String cardNumber,String Password) throws SQLException {
        Card s=new Card();
        //query
        String query=String.format("Select * from card where Card_ID='%s' and Pin='%s'",cardNumber,Password);
        ResultSet res=stmt.executeQuery(query);

        if(res.next()){

                s.setCardID(res.getString("Card_ID"));
                s.setPassword(res.getString("Pin"));
                s.setAccountID(res.getString("Account_ID"));
                s.setAmount(res.getDouble("Amount"));


            res.close();
            stmt.close();
            return s;
        }
        else{


            res.close();
            stmt.close();
            return null;
        }
    }
    public Customer GetCustomer(Card p) throws SQLException {
        Customer s=new Customer();
        //query
        String query=String.format("Select * from customer join account on account.Customer_ID=customer.Customer_ID where account.Account_ID='%s'",p.getAccountID());
        ResultSet res=stmt.executeQuery(query);

        if(res.next()){

            s.setID(res.getInt("Customer_ID"));
            s.setName(res.getString("Name"));
            s.setDateOfBirth(res.getDate("DateOfBirth"));
            s.setCitizenID(res.getString("Citizen"));

            res.close();
            stmt.close();
            return s;
        }
        else{
            res.close();
            stmt.close();
            return null;
        }
    }
    public Account showAccount(Card p) throws SQLException {
        Account s=new Account();
        //query
        String query=String.format("Select * from account where Account_ID='%s'",p.getAccountID());
        ResultSet res=stmt.executeQuery(query);

        if(res.next()){

            s.setID(res.getString("Account_ID"));
            s.setBankName(res.getString("Bank"));
            s.setCustomerID(res.getInt("Customer_ID"));

            res.close();
            stmt.close();
            return s;
        }
        else{
            res.close();
            stmt.close();
            return null;
        }
    }
    public void changePassword(Card s){
        try {
            String query = String.format("Update card SET Pin='%s' where Card_ID='%s'", s.getPassword(), s.getCardID());
            stmt.executeUpdate(query);
            stmt.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    public void changeAmount(Card s){
        try {
            String query = String.format("Update card SET Amount='%s' where Card_ID='%s'", s.getAmount(), s.getCardID());
            stmt.executeUpdate(query);
            stmt.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

}
