package model;

import java.time.LocalDateTime;

public class Order {

    private int id;
    private int userId;
    private double total;
    private LocalDateTime orderDate;

    public Order() {
    }

    public Order(int id, int userId, double total, LocalDateTime orderDate) {
        this.id = id;
        this.userId = userId;
        this.total = total;
        this.orderDate = orderDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }
}
