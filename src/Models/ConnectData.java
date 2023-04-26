package Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ConnectData {
    public ConnectData(){
        Connection();
    }
    public void Connection(){
        try {

            Class.forName("com.mysql.jdbc.Driver");
            //url: jdbc:mysql://127.0.0.1:3306/data
            //sql: Select * from table1
            String url1="jdbc:mysql://127.0.0.1:3306/data";
            Connection con= DriverManager.getConnection(url1,"root","");
            Statement stmt =con.createStatement();

        }
        catch(Exception e){
            System.out.println(e);
        }
    }

}
