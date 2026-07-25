package dao;

import database.DBConnection;
import model.Order;
import model.OrderItem;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class OrderDAO {

    private Connection con;

    public OrderDAO() {
        con = DBConnection.getConnection();
    }

    // Place Order
    public int placeOrder(Order order) {

        String sql = "INSERT INTO orders(userId,total,orderDate) VALUES(?,?,?)";

        try {

            PreparedStatement ps = con.prepareStatement(sql,
                    Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, order.getUserId());
            ps.setDouble(2, order.getTotal());
            ps.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));

            int rows = ps.executeUpdate();

            if(rows > 0){

                ResultSet rs = ps.getGeneratedKeys();

                if(rs.next()){

                    return rs.getInt(1);

                }
            }

        } catch(Exception e){

            e.printStackTrace();

        }

        return -1;
    }

    // Add Order Item
    public boolean addOrderItem(OrderItem item){

        String sql = "INSERT INTO order_items(orderId,foodId,quantity) VALUES(?,?,?)";

        try{

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1,item.getOrderId());
            ps.setInt(2,item.getFoodId());
            ps.setInt(3,item.getQuantity());

            return ps.executeUpdate() > 0;

        }catch(Exception e){

            e.printStackTrace();

        }

        return false;
    }

    // Order History
    public ArrayList<Order> getOrdersByUser(int userId){

        ArrayList<Order> list = new ArrayList<>();

        String sql = "SELECT * FROM orders WHERE userId=? ORDER BY orderDate DESC";

        try{

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1,userId);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){

                Order order = new Order();

                order.setId(rs.getInt("id"));
                order.setUserId(rs.getInt("userId"));
                order.setTotal(rs.getDouble("total"));
                order.setOrderDate(
                        rs.getTimestamp("orderDate").toLocalDateTime());

                list.add(order);

            }

        }catch(Exception e){

            e.printStackTrace();

        }
        // Get all orders for Admin

public ArrayList<Order> getAllOrders(){

    ArrayList<Order> list = new ArrayList<>();

    String sql = "SELECT * FROM orders ORDER BY orderDate DESC";


    try{

        Statement st = con.createStatement();

        ResultSet rs = st.executeQuery(sql);


        while(rs.next()){


            Order order = new Order();


            order.setId(
                    rs.getInt("id")
            );


            order.setUserId(
                    rs.getInt("userId")
            );


            order.setTotal(
                    rs.getDouble("total")
            );


            order.setOrderDate(
                    rs.getTimestamp("orderDate")
                    .toLocalDateTime()
            );


            list.add(order);

        }


    }catch(Exception e){

        e.printStackTrace();

    }


    return list;

}

        return list;
    }

}
