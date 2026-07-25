package ui;

import dao.UserDAO;
import model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginFrame extends JFrame implements ActionListener {

    JLabel titleLabel, emailLabel, passwordLabel;

    JTextField emailField;

    JPasswordField passwordField;

    JButton loginButton, registerButton;

    public LoginFrame() {

        setTitle("Online Food Ordering System");

        setSize(450,350);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(null);

        titleLabel = new JLabel("ONLINE FOOD ORDERING SYSTEM");

        titleLabel.setFont(new Font("Arial",Font.BOLD,18));

        titleLabel.setBounds(50,20,350,30);

        add(titleLabel);

        emailLabel = new JLabel("Email");

        emailLabel.setBounds(50,80,100,25);

        add(emailLabel);

        emailField = new JTextField();

        emailField.setBounds(150,80,220,30);

        add(emailField);

        passwordLabel = new JLabel("Password");

        passwordLabel.setBounds(50,130,100,25);

        add(passwordLabel);

        passwordField = new JPasswordField();

        passwordField.setBounds(150,130,220,30);

        add(passwordField);

        loginButton = new JButton("Login");

        loginButton.setBounds(80,210,120,35);

        add(loginButton);

        registerButton = new JButton("Register");

        registerButton.setBounds(220,210,120,35);

        add(registerButton);

        loginButton.addActionListener(this);

        registerButton.addActionListener(this);

        setVisible(true);

    }

    @Override

    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==loginButton){

            String email=emailField.getText();

            String password=new String(passwordField.getPassword());

            UserDAO dao=new UserDAO();

            User user=dao.login(email,password);

            if(user!=null){

                JOptionPane.showMessageDialog(this,
                        "Welcome "+user.getName());

                dispose();

                new DashboardFrame(user);

            }

            else{

                JOptionPane.showMessageDialog(this,
                        "Invalid Email or Password");

            }

        }

        if(e.getSource()==registerButton){

            dispose();

            new RegisterFrame();

        }

    }

}
