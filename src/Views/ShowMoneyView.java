package Views;

import Models.Card;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

public class ShowMoneyView extends JFrame implements ActionListener {
    JLabel lb1;
    JTextField txtMoney;
    JButton btnBack;
    Card card;
    public ShowMoneyView(String st,Card s1){
        super(st);
        card=new Card(s1);
        GUI();
    }
    public void GUI(){
        setDefaultCloseOperation(3);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
        setSize(500,300);
        lb1=new JLabel("Your account balance is: ");

        lb1.setHorizontalAlignment(SwingConstants.RIGHT);

        txtMoney=new JTextField(5);
        txtMoney.setText(String.format("%.2f",card.getAmount()));
        txtMoney.setFont(new Font("Arial",Font.BOLD,20));
        txtMoney.setEnabled(false);
        btnBack=new JButton("BACK");
        btnBack.setBackground(Color.black);
        btnBack.setForeground(Color.white);
        btnBack.addActionListener(this);
        lb1.setBounds(0,100,200,50);
        txtMoney.setBounds(250,100,150,40);
        btnBack.setBounds(220,200,70,30);
        add(lb1);
        add(txtMoney);
        add(btnBack);
        show();
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
