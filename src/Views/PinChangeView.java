package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class PinChangeView  extends JFrame implements ActionListener {
    JLabel lb1,lb2;
    JTextField txtOld,txtNew;
    JButton btnOK;
    public PinChangeView(String st){
        super(st);
        GUI();
    }
    public void GUI(){
        setDefaultCloseOperation(3);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
        setSize(500,300);
        lb1=new JLabel("Old Password");
        lb2=new JLabel("New Password");
        lb1.setHorizontalAlignment(SwingConstants.RIGHT);
        lb2.setHorizontalAlignment(SwingConstants.RIGHT);
        txtOld=new JTextField(5);
        txtNew=new JTextField(5);

        btnOK=new JButton("OK");
        btnOK.setBackground(Color.black);
        btnOK.setForeground(Color.white);
        btnOK.addActionListener(this);

        lb1.setBounds(0,50,150,50);
        lb2.setBounds(0,120,150,50);
        txtOld.setBounds(200,50,200,40);
        txtNew.setBounds(200,120,200,40);
        btnOK.setBounds(200,200,70,30);
        add(lb1);
        add(lb2);
        add(txtOld);
        add(txtNew);
        add(btnOK);
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
