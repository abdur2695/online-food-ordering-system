package service;

import model.Cart;
import model.User;

import java.io.FileWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;


public class InvoiceService {


    public static void generateInvoice(User user) {


        try {


            String fileName =
                    "Invoice_" + user.getId() + ".txt";


            FileWriter writer =
                    new FileWriter(fileName);



            writer.write(
                    "=================================\n"
            );

            writer.write(
                    "     ONLINE FOOD ORDERING SYSTEM\n"
            );

            writer.write(
                    "=================================\n\n"
            );



            writer.write(
                    "Customer Name : "
                    + user.getName()
                    + "\n"
            );


            writer.write(
                    "Email : "
                    + user.getEmail()
                    + "\n"
            );


            writer.write(
                    "Date : "
                    + LocalDateTime.now()
                    + "\n\n"
            );



            writer.write(
                    "Food Items\n"
            );


            writer.write(
                    "---------------------------------\n"
            );



            ArrayList<Cart> cartList =
                    CartService.cartList;



            for(Cart c : cartList){


                writer.write(

                        c.getFoodName()
                        + "  Qty: "
                        + c.getQuantity()
                        + "  Price: ₹"
                        + c.getTotal()
                        + "\n"

                );


            }



            writer.write(
                    "\n---------------------------------\n"
            );


            writer.write(
                    "Total Amount : ₹"
                    + CartService.getTotal()
                    + "\n"
            );


            writer.write(
                    "=================================\n"
            );


            writer.write(
                    "Thank you for ordering!\n"
            );


            writer.close();



            System.out.println(
                    "Invoice Generated Successfully"
            );


        }
        catch(Exception e){

            e.printStackTrace();

        }


    }

}
