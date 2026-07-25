package service;

import model.Cart;

import java.util.ArrayList;


public class CartService {


    public static ArrayList<Cart> cartList = new ArrayList<>();


    public static void addCart(Cart cart){

        cartList.add(cart);

    }


    public static double getTotal(){

        double total = 0;


        for(Cart c : cartList){

            total += c.getTotal();

        }


        return total;

    }


    public static void clearCart(){

        cartList.clear();

    }

}
