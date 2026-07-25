package ui;


import dao.FoodDAO;
import model.Food;
import model.Cart;
import model.User;
import service.CartService;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;


public class FoodMenuFrame extends JFrame implements ActionListener {


    JTable table;

    JButton addButton;
    JButton cartButton;


    DefaultTableModel model;


    ArrayList<Food> foods;


    User user;



    public FoodMenuFrame(User user){


        this.user=user;


        setTitle("Food Menu");


        setSize(700,450);


        setLocationRelativeTo(null);


        setLayout(null);



        model = new DefaultTableModel();


        model.addColumn("ID");

        model.addColumn("Food Name");

        model.addColumn("Category");

        model.addColumn("Price");



        table = new JTable(model);



        JScrollPane scroll =
                new JScrollPane(table);



        scroll.setBounds(50,50,600,220);


        add(scroll);



        loadFood();



        addButton =
                new JButton("Add To Cart");


        addButton.setBounds(150,320,150,40);


        add(addButton);



        cartButton =
                new JButton("View Cart");


        cartButton.setBounds(350,320,150,40);


        add(cartButton);



        addButton.addActionListener(this);

        cartButton.addActionListener(this);



        setVisible(true);

    }




    private void loadFood(){


        FoodDAO dao = new FoodDAO();


        foods = dao.getAllFood();



        for(Food f : foods){


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



        if(e.getSource()==addButton){


            int row =
                    table.getSelectedRow();



            if(row==-1){


                JOptionPane.showMessageDialog(this,
                        "Select a food item");


                return;

            }



            Food food =
                    foods.get(row);



            Cart cart =
                    new Cart(
                            food.getId(),
                            food.getName(),
                            food.getPrice(),
                            1
                    );



            CartService.addCart(cart);



            JOptionPane.showMessageDialog(this,
                    "Added to Cart");


        }



        if(e.getSource()==cartButton){


            new CartFrame(user);


        }



    }

}
