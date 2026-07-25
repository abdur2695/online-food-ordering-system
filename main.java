package main;

import dao.OrderDAO;
import model.Order;

import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {

        OrderDAO dao = new OrderDAO();

        Order order = new Order();

        order.setUserId(1);
        order.setTotal(450);
        order.setOrderDate(LocalDateTime.now());

        int orderId = dao.placeOrder(order);

        if(orderId != -1){

            System.out.println("Order Placed Successfully");
            System.out.println("Order ID : " + orderId);

        }else{

            System.out.println("Order Failed");

        }

    }
}
