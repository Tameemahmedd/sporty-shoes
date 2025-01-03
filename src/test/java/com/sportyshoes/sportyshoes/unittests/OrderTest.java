package com.sportyshoes.sportyshoes.unittests;


import com.sportyshoes.sportyshoes.model.Order;
import com.sportyshoes.sportyshoes.model.Shoe;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class OrderTest {

    @Test
    public void testOrderConstructor() {
        ArrayList<Shoe> shoes = new ArrayList<>();
        shoes.add(new Shoe(101, "1.png", "BlueWave Running Shoes", "Sports", "7, 8, 9", 2000));
        Date createdOn = new Date();
        Order order = new Order(1, shoes, createdOn);

        assertEquals(1, order.getOrderId());
        assertEquals(shoes, order.getShoes());
        assertEquals(createdOn, order.getCreatedOn());
    }

    @Test
    public void testOrderToString() {
        ArrayList<Shoe> shoes = new ArrayList<>();
        shoes.add(new Shoe(101, "1.png", "BlueWave Running Shoes", "Sports", "7, 8, 9", 2000));
        Date createdOn = new Date();
        Order order = new Order(1, shoes, createdOn);

        String expected = "Order [orderId=1, shoes=" + shoes + ", createdOn=" + createdOn + "]";
        assertEquals(expected, order.toString());
    }

    @Test
    public void testOrderSettersAndGetters() {
        Order order = new Order();
        order.setOrderId(1);
        order.setProductImage("1.png");
        order.setUserEmail("john@example.com");
        order.setOrderPrice(2000);
        Date createdOn = new Date();
        order.setCreatedOn(createdOn);

        assertEquals(1, order.getOrderId());
        assertEquals("1.png", order.getProductImage());
        assertEquals("john@example.com", order.getUserEmail());
        assertEquals(2000, order.getOrderPrice());
        assertEquals(createdOn, order.getCreatedOn());
    }
}