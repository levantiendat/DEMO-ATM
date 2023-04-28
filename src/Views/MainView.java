package Views;

import Controllers.MainController;
import Models.Card;
import Models.Customer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

public class MainView  extends JFrame implements ActionListener {
    private JButton btnWithDraw, btnShow, btnPinChange, btnDeposit, btnView, btnLogOut;
    private JLabel txtName;
    private JPanel pn,pn1,pn2,pn3,pn4;
    Card card;
    Customer customer;

    public MainView(String s, Card card1) throws SQLException {
        super(s);
        card=new Card(card1);
        GUI();

    }
    public void GUI() throws SQLException {
        txtName=new JLabel("");
        btnWithDraw =new JButton("WithDraw");
        btnWithDraw.setPreferredSize(new Dimension(180, 50));
        btnShow=new JButton("Show Account Balance");
        btnShow.setPreferredSize(new Dimension(180, 50));
        btnPinChange=new JButton("Change Card Pin");
        btnPinChange.setPreferredSize(new Dimension(180, 50));
        btnDeposit=new JButton("Deposit");
        btnDeposit.setPreferredSize(new Dimension(180, 50));
        btnView=new JButton("View Information");
        btnView.setPreferredSize(new Dimension(180, 50));
        btnLogOut=new JButton("Log out");
        btnLogOut.setPreferredSize(new Dimension(180, 50));

        btnWithDraw.setBackground(Color.black);
        btnWithDraw.setForeground(Color.white);
        btnShow.setBackground(Color.black);
        btnShow.setForeground(Color.white);
        btnPinChange.setBackground(Color.black);
        btnPinChange.setForeground(Color.white);
        btnDeposit.setBackground(Color.black);
        btnDeposit.setForeground(Color.white);
        btnView.setBackground(Color.black);
        btnView.setForeground(Color.white);
        btnLogOut.setBackground(Color.black);
        btnLogOut.setForeground(Color.white);

        btnWithDraw.addActionListener(this);
        btnShow.addActionListener(this);
        btnPinChange.addActionListener(this);
        btnDeposit.addActionListener(this);
        btnView.addActionListener(this);
        btnLogOut.addActionListener(this);
        setName();



        pn=new JPanel(new GridLayout(5,1));


        pn1=new JPanel(new GridLayout(1,1));
        pn1.add(txtName);

        pn2=new JPanel(new BorderLayout());
        pn2.add(btnWithDraw,BorderLayout.WEST);
        pn2.add(btnDeposit,BorderLayout.EAST);

        pn3=new JPanel(new BorderLayout());
        pn3.add(btnShow,BorderLayout.WEST);
        pn3.add(btnView,BorderLayout.EAST);

        pn4=new JPanel(new BorderLayout());
        pn4.add(btnPinChange,BorderLayout.WEST);
        pn4.add(btnLogOut,BorderLayout.EAST);

        pn.add(pn1);
        pn.add(new JLabel());
        pn.add(pn2);
        pn.add(pn3);
        pn.add(pn4);
        add(pn);
        setSize(500,300);
        show();


    }
    public void setName() throws SQLException {
        MainController controller=new MainController();
        customer=controller.getCustomer(card);
        txtName.setText(String.format("Welcome, %s!",customer.getName()));
    }

    public void windowClosing(WindowEvent we) {
        dispose();
        System.exit(0);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnDeposit){
            DepositView deposit=new DepositView("Deposit Money");
            dispose();
        }
        if(e.getSource()==btnView){
            try {
                DetailView view=new DetailView("Detail View",customer,card);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            dispose();
        }
        if(e.getSource()==btnLogOut){
            LoginView lg=new LoginView("Login View");
            dispose();
        }
        if(e.getSource()==btnWithDraw){
            WithDrawView deposit=new WithDrawView("Withdraw Money");
            dispose();
        }
        if(e.getSource()==btnShow){
            ShowMoneyView show=new ShowMoneyView("Show money",card);
            dispose();
        }
        if(e.getSource()==btnPinChange){
            PinChangeView pin=new PinChangeView("Pin charge");
            dispose();
        }
    }
}
