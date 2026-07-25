package ui;


import dao.OrderDAO;
import model.Order;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.util.ArrayList;


public class AdminOrderFrame extends JFrame {


    JTable table;

    DefaultTableModel model;



    public AdminOrderFrame(){


        setTitle("Customer Orders");


        setSize(700,400);


        setLocationRelativeTo(null);


        setLayout(null);



        model =
                new DefaultTableModel();



        model.addColumn("Order ID");

        model.addColumn("User ID");

        model.addColumn("Total Amount");

        model.addColumn("Order Date");



        table =
                new JTable(model);



        JScrollPane scroll =
                new JScrollPane(table);


        scroll.setBounds(
                40,50,620,250
        );


        add(scroll);



        loadOrders();



        setVisible(true);

    }




    private void loadOrders(){


        OrderDAO dao =
                new OrderDAO();


        ArrayList<Order> orders =
                dao.getAllOrders();



        for(Order o : orders){


            model.addRow(new Object[]{


                    o.getId(),

                    o.getUserId(),

                    "₹ "+o.getTotal(),

                    o.getOrderDate()


            });


        }


    }


}
