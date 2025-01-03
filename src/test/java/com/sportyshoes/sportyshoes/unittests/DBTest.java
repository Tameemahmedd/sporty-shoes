package com.sportyshoes.sportyshoes.unittests;


import com.sportyshoes.sportyshoes.db.DB;
import com.sportyshoes.sportyshoes.model.Order;
import com.sportyshoes.sportyshoes.model.Shoe;
import com.sportyshoes.sportyshoes.model.User;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DBTest {

    @Test
    public void testGetInstance() {
        DB dbInstance = DB.getInstance();
        assertNotNull(dbInstance);
    }

    @Test
    public void testSetUpUsers() {
        DB dbInstance = DB.getInstance();
        LinkedHashMap<String, User> users = dbInstance.users;
        ArrayList<User> usersList = dbInstance.usersList;

        assertEquals(3, users.size());
        assertEquals(3, usersList.size());

        User user = users.get("john@example.com");
        assertNotNull(user);
        assertEquals("John Watson", user.getName());
        assertEquals("john@example.com", user.getEmail());
        assertEquals("john123", user.getPassword());
    }

    @Test
    public void testSetUpShoes() {
        DB dbInstance = DB.getInstance();
        LinkedHashMap<Integer, Shoe> shoes = dbInstance.shoes;
        ArrayList<Shoe> shoesList = dbInstance.shoesList;

        assertEquals(12, shoes.size());
        assertEquals(12, shoesList.size());

        Shoe shoe = shoes.get(101);
        assertNotNull(shoe);
        assertEquals("BlueWave Running Shoes", shoe.getName());
        assertEquals("1.png", shoe.getImage());
        assertEquals("Sports", shoe.getCategory());
        assertEquals("7, 8, 9", shoe.getSizes());
        assertEquals(2000, shoe.getPrice());
    }
}