package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class DepositView extends JFrame implements ActionListener {

    private JLabel lb1;
    private JTextField txtNum;
    private JButton btnOK,btnReset;
    private JPanel pn,pn0,pn1,pn3;

    public DepositView(String s)  {
        super(s);
        GUI();
    }

    public void GUI(){
        lb1=new JLabel("INPUT AMOUNT TO DEPOSIT");

        txtNum=new JTextField(5);
        txtNum.setBounds(0,0,200,15);
        txtNum.setForeground(Color.BLUE);
        txtNum.setFont(new Font("Arial", Font.PLAIN, 16));
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

        pn1=new JPanel(new GridLayout(1,3));
        pn1.add(new JLabel());
        pn1.add(txtNum);
        pn1.add(new JLabel());

        pn3=new JPanel(new FlowLayout());
        pn3.add(btnOK);
        pn3.add(btnReset);

        pn.add(new Label());
        pn.add(pn0);
        pn.add(pn1);

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

    }
}
