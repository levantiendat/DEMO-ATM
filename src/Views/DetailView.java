package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class DetailView  extends JFrame implements ActionListener {
    private JLabel lb1,lb2,lb3,lb4;
    private JTextField txtName,txtDate,txtCCCD,txtBank;
    private JButton btnBack;
    private JPanel pn,pn1,pn2,pn3,pn4,pn5;
    public DetailView(String s){
        super(s);
        GUI();
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
    public void windowClosing(WindowEvent we) {
        dispose();
        System.exit(0);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
