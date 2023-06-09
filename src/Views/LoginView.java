package Views;

import Controllers.LoginController;
import Models.Card;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

public class LoginView extends JFrame implements ActionListener {
    private JLabel lb1,lb2,lb3;
    private JTextField txtCard;
    private JPasswordField txtPass;
    private JButton btnOK,btnReset;
    private JPanel pn,pn0,pn1,pn2,pn3;

    public LoginView(String s)  {
        super(s);
        GUI();
    }

    public void GUI(){
        lb1=new JLabel("HE THONG NGAN HANG");
        lb2=new JLabel("CARD NUMBER: ");
        lb3=new JLabel("CARD PIN: ");
        txtCard=new JTextField(5);
        txtCard.setBounds(0,0,200,15);
        txtPass=new JPasswordField(5);
        txtPass.setEchoChar('*');
        txtPass.setBounds(0,0,200,15);
        btnOK=new JButton("OK");
        btnOK.setBackground(Color.black);
        btnOK.setForeground(Color.white);
        btnReset=new JButton("RESET");
        btnReset.setBackground(Color.black);
        btnReset.setForeground(Color.white);
        btnOK.addActionListener(this);
        btnReset.addActionListener(this);


        pn=new JPanel(new GridLayout(5,1));
        pn0=new JPanel(new FlowLayout());
        pn0.add(lb1);

        pn1=new JPanel(new GridLayout(1,2));

        pn1.add(lb2);
        pn1.add(txtCard);


        pn2=new JPanel(new GridLayout(1,2));

        pn2.add(lb3);
        pn2.add(txtPass);


        pn3=new JPanel(new FlowLayout());
        pn3.add(btnOK);
        pn3.add(btnReset);

        pn.add(new Label());
        pn.add(pn0);
        pn.add(pn1);
        pn.add(pn2);
        pn.add(pn3);

        setSize(500,300);
        add(pn);
        show();


    }

    public void windowClosing(WindowEvent we) {
        dispose();
        System.exit(0);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnOK){
            String CardNumber=txtCard.getText().toString();
            String Password=txtPass.getText().toString();
            LoginController controller=new LoginController();
            Card s;
            try {
                s = controller.CheckAccount(CardNumber,Password);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            if(s!=null){
                try {
                    MainView mv=new MainView("Main View",s);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                dispose();
            }
            else{
                JOptionPane.showMessageDialog(this,"Invalid account");
            }
        }
        if(e.getSource()==btnReset){
            txtCard.setText("");
            txtPass.setText("");
        }
    }
}
