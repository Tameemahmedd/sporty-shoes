package com.sportyshoes.sportyshoes.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;

@Builder
@Getter
@Setter
public class Order {
    public int orderId;
    public ArrayList<Shoe> shoes;
    public String productImage;
    public String userEmail;
    public int orderPrice;
    public Date createdOn;

    public Order() {
    }


    public Order(int orderId, ArrayList<Shoe> shoes, String productImage, String userEmail, int orderPrice, Date createdOn) {
        this.orderId = orderId;
        this.shoes = shoes;
        this.productImage = productImage;
        this.userEmail = userEmail;
        this.orderPrice = orderPrice;
        this.createdOn = createdOn;
    }
    public Order(int orderId, ArrayList<Shoe> shoes, Date createdOn) {
        this.orderId = orderId;
        this.shoes = shoes;
        this.createdOn = createdOn;
    }

    public String toString() {
        return "Order [orderId=" + this.orderId + ", shoes=" + this.shoes + ", createdOn=" + this.createdOn + "]";
    }
}