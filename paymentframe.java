package ui;

import model.User;
import service.CartService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class PaymentFrame extends JFrame implements ActionListener {


    JLabel totalLabel;

    JButton payButton;


    User user;

    double total;



    public PaymentFrame(User user,double total){


        this.user=user;

        this.total=total;



        setTitle("Payment");


        setSize(400,300);


        setLocationRelativeTo(null);


        setLayout(null);



        totalLabel =
                new JLabel(
                "Total Amount : ₹ " + total
                );


        totalLabel.setFont(
                new Font("Arial",Font.BOLD,18)
        );


        totalLabel.setBounds(80,70,250,40);


        add(totalLabel);




        payButton =
                new JButton("Confirm Payment");


        payButton.setBounds(100,150,180,40);


        add(payButton);



        payButton.addActionListener(this);



        setVisible(true);


    }





    @Override
    public void actionPerformed(ActionEvent e){



        if(e.getSource()==payButton){


            JOptionPane.showMessageDialog(this,
                    "Payment Successful\nOrder Placed!");



            CartService.clearCart();



            dispose();


        }


    }


}
