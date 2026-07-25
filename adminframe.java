package ui;

import dao.FoodDAO;
import model.Food;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;


public class AdminFrame extends JFrame implements ActionListener {


    JTextField nameField;
    JTextField categoryField;
    JTextField priceField;


    JButton addButton;
    JButton deleteButton;
    JButton refreshButton;


    JTable table;

    DefaultTableModel model;


    ArrayList<Food> foodList;



    public AdminFrame(){


        setTitle("Admin Dashboard");


        setSize(750,500);


        setLocationRelativeTo(null);


        setLayout(null);



        JLabel name =
                new JLabel("Food Name");

        name.setBounds(40,40,100,25);

        add(name);



        nameField =
                new JTextField();

        nameField.setBounds(150,40,180,30);

        add(nameField);




        JLabel category =
                new JLabel("Category");

        category.setBounds(40,90,100,25);

        add(category);



        categoryField =
                new JTextField();

        categoryField.setBounds(150,90,180,30);

        add(categoryField);




        JLabel price =
                new JLabel("Price");

        price.setBounds(40,140,100,25);

        add(price);



        priceField =
                new JTextField();

        priceField.setBounds(150,140,180,30);

        add(priceField);




        addButton =
                new JButton("Add Food");


        addButton.setBounds(380,60,120,35);

        add(addButton);




        deleteButton =
                new JButton("Delete");


        deleteButton.setBounds(520,60,120,35);

        add(deleteButton);




        refreshButton =
                new JButton("Refresh");


        refreshButton.setBounds(450,110,120,35);

        add(refreshButton);




        model =
                new DefaultTableModel();



        model.addColumn("ID");

        model.addColumn("Name");

        model.addColumn("Category");

        model.addColumn("Price");



        table =
                new JTable(model);



        JScrollPane scroll =
                new JScrollPane(table);


        scroll.setBounds(40,220,650,180);


        add(scroll);



        addButton.addActionListener(this);

        deleteButton.addActionListener(this);

        refreshButton.addActionListener(this);



        loadFood();



        setVisible(true);

    }





    void loadFood(){


        model.setRowCount(0);



        FoodDAO dao = new FoodDAO();


        foodList = dao.getAllFood();



        for(Food f : foodList){


            model.addRow(new Object[]{

                    f.getId(),

                    f.getName(),

                    f.getCategory(),

                    f.getPrice()

            });


        }

    }





    @Override
    public void actionPerformed(ActionEvent e){



        FoodDAO dao =
                new FoodDAO();



        if(e.getSource()==addButton){



            Food food =
                    new Food();



            food.setName(
                    nameField.getText()
            );


            food.setCategory(
                    categoryField.getText()
            );


            food.setPrice(
                    Double.parseDouble(
                            priceField.getText()
                    )
            );



            if(dao.addFood(food)){


                JOptionPane.showMessageDialog(this,
                        "Food Added");


                loadFood();

            }


        }





        if(e.getSource()==deleteButton){



            int row =
                    table.getSelectedRow();



            if(row!=-1){


                int id =
                        (int) model.getValueAt(row,0);



                dao.deleteFood(id);



                loadFood();


                JOptionPane.showMessageDialog(this,
                        "Deleted");

            }

        }





        if(e.getSource()==refreshButton){


            loadFood();

        }


    }

}
JButton orderButton;

orderButton = new JButton("View Orders");

orderButton.setBounds(450,160,120,35);

add(orderButton);

orderButton.addActionListener(this);
