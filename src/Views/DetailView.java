package Views;

import Controllers.DetailController;
import Models.Account;
import Models.Card;
import Models.Customer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

public class DetailView  extends JFrame implements ActionListener {
    private JLabel lb1,lb2,lb3,lb4;
    private JTextField txtName,txtDate,txtCCCD,txtBank;
    private JButton btnBack;
    private JPanel pn,pn1,pn2,pn3,pn4,pn5;
    Customer customer;
    Card card;
    public DetailView(String s,Customer s1,Card s2) throws SQLException {
        super(s);
        customer=new Customer(s1);
        card=new Card(s2);
        GUI();
        getData();
    }
    public void GUI(){
        lb1=new JLabel("Họ tên khách hàng: ");
        lb2=new JLabel("Ngày sinh: ");
        lb3=new JLabel("CCCD");
        lb4=new JLabel("Ngân hàng mở thẻ: ");
        txtName=new JTextField(5);
        txtName.setBounds(0,0,200,15);
        txtName.enable(false);
        txtDate=new JTextField(5);
        txtDate.setBounds(0,0,200,15);
        txtDate.enable(false);
        txtCCCD=new JTextField(5);
        txtCCCD.setBounds(0,0,200,15);
        txtCCCD.enable(false);
        txtBank=new JTextField(5);
        txtBank.setBounds(0,0,200,15);
        txtBank.enable(false);
        btnBack=new JButton("Back");
        btnBack.setBackground(Color.black);
        btnBack.setForeground(Color.white);
        btnBack.addActionListener(this);

        txtName.setFont(new Font("Arial",Font.BOLD,20));
        txtDate.setFont(new Font("Arial",Font.BOLD,20));
        txtCCCD.setFont(new Font("Arial",Font.BOLD,20));
        txtBank.setFont(new Font("Arial",Font.BOLD,20));





        pn=new JPanel(new GridLayout(5,1));
        pn1=new JPanel(new GridLayout(1,2));
        pn1.add(lb1);
        pn1.add(txtName);

        pn2=new JPanel(new GridLayout(1,2));
        pn2.add(lb2);
        pn2.add(txtDate);

        pn3=new JPanel(new GridLayout(1,2));
        pn3.add(lb3);
        pn3.add(txtCCCD);

        pn4=new JPanel(new GridLayout(1,2));
        pn4.add(lb4);
        pn4.add(txtBank);

        pn5=new JPanel(new FlowLayout());
        pn5.add(btnBack);

        pn.add(pn1);
        pn.add(pn2);
        pn.add(pn3);
        pn.add(pn4);
        pn.add(pn5);

        add(pn);
        setSize(500,300);
        show();

    }
    public void getData() throws SQLException {
        DetailController controller=new DetailController();
        Account acc=controller.getAccount(card);
        txtName.setText(customer.getName());
        txtDate.setText(customer.getDateOfBirth().toString());
        txtCCCD.setText(customer.getCitizenID());
        txtBank.setText(acc.getBankName());

    }
    public void windowClosing(WindowEvent we) {
        dispose();
        System.exit(0);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnBack){
            try {
                MainView mv=new MainView("Main View",card);
                dispose();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
