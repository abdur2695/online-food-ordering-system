package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdminLoginFrame extends JFrame implements ActionListener {


    JTextField usernameField;

    JPasswordField passwordField;

    JButton loginButton;


    public AdminLoginFrame(){


        setTitle("Admin Login");

        setSize(400,300);

        setLocationRelativeTo(null);

        setLayout(null);



        JLabel title =
                new JLabel("ADMIN LOGIN");

        title.setFont(
                new Font("Arial",Font.BOLD,20)
        );

        title.setBounds(120,30,200,30);

        add(title);



        JLabel userLabel =
                new JLabel("Username");

        userLabel.setBounds(50,90,100,25);

        add(userLabel);



        usernameField =
                new JTextField();

        usernameField.setBounds(150,90,180,30);

        add(usernameField);



        JLabel passLabel =
                new JLabel("Password");

        passLabel.setBounds(50,140,100,25);

        add(passLabel);



        passwordField =
                new JPasswordField();

        passwordField.setBounds(150,140,180,30);

        add(passwordField);



        loginButton =
                new JButton("Login");

        loginButton.setBounds(130,200,120,35);

        add(loginButton);



        loginButton.addActionListener(this);



        setVisible(true);

    }



    @Override
    public void actionPerformed(ActionEvent e){


        String username =
                usernameField.getText();


        String password =
                new String(passwordField.getPassword());



        if(username.equals("admin")
                && password.equals("admin123")){


            JOptionPane.showMessageDialog(this,
                    "Login Successful");


            dispose();


            new AdminFrame();


        }
        else{


            JOptionPane.showMessageDialog(this,
                    "Invalid Admin Login");


        }


    }

}
