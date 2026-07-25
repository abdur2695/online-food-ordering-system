package dao;

import database.DBConnection;
import model.Food;

import java.sql.*;
import java.util.ArrayList;

public class FoodDAO {

    private Connection con;

    public FoodDAO() {
        con = DBConnection.getConnection();
    }

    // Add Food
    public boolean addFood(Food food) {

        String sql = "INSERT INTO food(name,category,price) VALUES(?,?,?)";

        try {

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, food.getName());
            ps.setString(2, food.getCategory());
            ps.setDouble(3, food.getPrice());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    // View All Food
    public ArrayList<Food> getAllFood() {

        ArrayList<Food> list = new ArrayList<>();

        String sql = "SELECT * FROM food";

        try {

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                Food food = new Food();

                food.setId(rs.getInt("id"));
                food.setName(rs.getString("name"));
                food.setCategory(rs.getString("category"));
                food.setPrice(rs.getDouble("price"));

                list.add(food);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    // Update Food
    public boolean updateFood(Food food) {

        String sql = "UPDATE food SET name=?, category=?, price=? WHERE id=?";

        try {

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, food.getName());
            ps.setString(2, food.getCategory());
            ps.setDouble(3, food.getPrice());
            ps.setInt(4, food.getId());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    // Delete Food
    public boolean deleteFood(int id) {

        String sql = "DELETE FROM food WHERE id=?";

        try {

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    // Search Food by Name
    public ArrayList<Food> searchFood(String keyword) {

        ArrayList<Food> list = new ArrayList<>();

        String sql = "SELECT * FROM food WHERE name LIKE ?";

        try {

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, "%" + keyword + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Food food = new Food();

                food.setId(rs.getInt("id"));
                food.setName(rs.getString("name"));
                food.setCategory(rs.getString("category"));
                food.setPrice(rs.getDouble("price"));

                list.add(food);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
// Search Food

public ArrayList<Food> searchFood(String keyword){

    ArrayList<Food> list = new ArrayList<>();

    String sql =
    "SELECT * FROM food WHERE name LIKE ? OR category LIKE ?";


    try{


        PreparedStatement ps =
                con.prepareStatement(sql);


        ps.setString(1,"%"+keyword+"%");

        ps.setString(2,"%"+keyword+"%");


        ResultSet rs =
                ps.executeQuery();



        while(rs.next()){


            Food food = new Food();


            food.setId(
                    rs.getInt("id")
            );


            food.setName(
                    rs.getString("name")
            );


            food.setCategory(
                    rs.getString("category")
            );


            food.setPrice(
                    rs.getDouble("price")
            );


            list.add(food);

        }


    }
    catch(Exception e){

        e.printStackTrace();

    }


    return list;

}
