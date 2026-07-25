package ui;

import javax.swing.*;

public class RegisterFrame extends JFrame{

    public RegisterFrame(){

        setTitle("Register");

        setSize(450,400);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label=new JLabel("Registration Page",SwingConstants.CENTER);

        add(label);

        setVisible(true);

    }

}
