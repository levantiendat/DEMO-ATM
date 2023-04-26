package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class ShowMoneyView extends JFrame implements ActionListener {
    JLabel lb1;
    JTextField txtMoney;
    JButton btnBack;
    public ShowMoneyView(String st){
        super(st);
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

    }
}
