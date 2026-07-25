package ui;

import model.User;

import javax.swing.*;

public class DashboardFrame extends JFrame {

    public DashboardFrame(User user){

        setTitle("Dashboard");

        setSize(600,400);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label=new JLabel("Welcome "+user.getName(),SwingConstants.CENTER);

        add(label);

        setVisible(true);

    }

}
