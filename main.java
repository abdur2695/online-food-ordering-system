package main;

import dao.UserDAO;
import model.User;

public class Main {

    public static void main(String[] args) {

        UserDAO dao = new UserDAO();

        User user = dao.login("abdur@gmail.com", "1234");

        if (user != null) {

            System.out.println("Welcome " + user.getName());

        } else {

            System.out.println("Invalid Login");
        }
    }
}
