package Views;

import Controllers.PinChangeController;
import Models.Card;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

public class PinChangeView  extends JFrame implements ActionListener {
    JLabel lb1,lb2;
    JPasswordField txtOld,txtNew;
    JButton btnOK,btnCancel;
    Card card;
    public PinChangeView(String st, Card s1){
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
        lb1=new JLabel("Old Password");
        lb2=new JLabel("New Password");
        lb1.setHorizontalAlignment(SwingConstants.RIGHT);
        lb2.setHorizontalAlignment(SwingConstants.RIGHT);
        txtOld=new JPasswordField(5);
        txtNew=new JPasswordField(5);

        txtOld.setEchoChar('*');
        txtNew.setEchoChar('*');

        btnOK=new JButton("OK");
        btnOK.setBackground(Color.black);
        btnOK.setForeground(Color.white);
        btnOK.addActionListener(this);

        btnCancel=new JButton("Cancel");
        btnCancel.setBackground(Color.black);
        btnCancel.setForeground(Color.white);
        btnCancel.addActionListener(this);


        lb1.setBounds(0,50,150,50);
        lb2.setBounds(0,120,150,50);
        txtOld.setBounds(200,50,200,40);
        txtNew.setBounds(200,120,200,40);
        btnOK.setBounds(120,200,100,30);
        btnCancel.setBounds(250,200,100,30);

        add(lb1);
        add(lb2);
        add(txtOld);
        add(txtNew);
        add(btnOK);
        add(btnCancel);
        show();
    }
    public void windowClosing(WindowEvent we) {
        dispose();
        System.exit(0);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnOK){
            int input= JOptionPane.showConfirmDialog(this,"Do you confirm to change this password");
            if(input==0){
                if(txtNew.getText().length()==0 ){
                    JOptionPane.showMessageDialog(this,"Your old password or new password is empty");
                }
                else{
                    try {
                        if (txtOld.getText() .compareTo(card.getPassword()) ==0) {
                            if (txtOld.getText().compareTo(txtNew.getText()) == 0) {
                                JOptionPane.showMessageDialog(this, "Your old password and new password is compare together");
                            } else {
                                card.setPassword(txtNew.getText());
                                PinChangeController controller = new PinChangeController();
                                controller.changePassword(card);
                                JOptionPane.showMessageDialog(this, "Change Password Successfully");
                                MainView mv=new MainView("Main View",card);
                                dispose();
                            }
                        } else {
                            JOptionPane.showMessageDialog(this, "Your old password is not correct");
                        }
                    }
                    catch(Exception qq){
                        System.out.println(qq);
                    }
                }

            }
        }
        if(e.getSource()==btnCancel){
            try {
                MainView mv=new MainView("Main View",card);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            dispose();
        }
    }
}
