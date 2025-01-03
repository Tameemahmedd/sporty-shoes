package com.sportyshoes.sportyshoes.unittests;

import com.sportyshoes.sportyshoes.model.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {

    @Test
    public void testUserConstructor() {
        User user = new User("John Doe", "john@example.com", "password123");

        assertEquals("John Doe", user.getName());
        assertEquals("john@example.com", user.getEmail());
        assertEquals("password123", user.getPassword());
    }

    @Test
    public void testUserSettersAndGetters() {
        User user = new User();
        user.setName("John Doe");
        user.setEmail("john@example.com");
        user.setPassword("password123");

        assertEquals("John Doe", user.getName());
        assertEquals("john@example.com", user.getEmail());
        assertEquals("password123", user.getPassword());
    }

    @Test
    public void testUserToString() {
        User user = new User("John Doe", "john@example.com", "password123");

        String expected = "User [email=john@example.com, password=password123]";
        assertEquals(expected, user.toString());
    }
}