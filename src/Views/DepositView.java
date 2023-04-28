package Views;

import Controllers.DepositController;
import Controllers.WithDrawController;
import Models.Card;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

public class DepositView extends JFrame implements ActionListener {

    private JLabel lb1;
    private JTextField txtNum;
    private JButton btnOK,btnCancel;
    private JPanel pn,pn0,pn1,pn3;
    Card card ;

    public DepositView(String s,Card s1)  {
        super(s);
        card =new Card(s1);
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
        btnCancel=new JButton("CANCEL");
        btnCancel.setBackground(Color.black);
        btnCancel.setForeground(Color.white);
        btnOK.addActionListener(this);
        btnCancel.addActionListener(this);

        pn=new JPanel(new GridLayout(5,1));
        pn0=new JPanel(new FlowLayout());
        pn0.add(lb1);

        pn1=new JPanel(new GridLayout(1,3));
        pn1.add(new JLabel());
        pn1.add(txtNum);
        pn1.add(new JLabel());

        pn3=new JPanel(new FlowLayout());
        pn3.add(btnOK);
        pn3.add(btnCancel);

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
        if(e.getSource()==btnOK){
            int input= JOptionPane.showConfirmDialog(this,"Do you confirm to withdraw these money");
            if(input==0){
                try {
                    double amount = Double.parseDouble(txtNum.getText());
                    if(amount<=0){
                        JOptionPane.showMessageDialog(this,"Your information is not valid");
                    }
                    else{

                            try{
                                card.setAmount(card.getAmount()+amount);
                                DepositController controller=new DepositController();
                                controller.deposit(card);
                                JOptionPane.showMessageDialog(this,String.format("Deposit successfully, your new amount is %.2f",card.getAmount()));
                                MainView view=new MainView("Main View",card);
                                dispose();
                            }
                            catch(Exception t){
                                System.out.println(t);
                            }


                        }


                }
                catch(Exception p){
                    JOptionPane.showMessageDialog(this,"Your input information is not valid");
                }

            }
        }
        if(e.getSource()==btnCancel){
            try {
                MainView view=new MainView("Main View",card);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            dispose();

        }
    }
}
