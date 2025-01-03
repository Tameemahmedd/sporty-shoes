package com.sportyshoes.sportyshoes.unittests;

import com.sportyshoes.sportyshoes.model.Shoe;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ShoeTest {

    @Test
    public void testShoeConstructor() {
        Shoe shoe = new Shoe(101, "1.png", "BlueWave Running Shoes", "Sports", "7, 8, 9", 2000);

        assertEquals(101, shoe.getId());
        assertEquals("1.png", shoe.getImage());
        assertEquals("BlueWave Running Shoes", shoe.getName());
        assertEquals("Sports", shoe.getCategory());
        assertEquals("7, 8, 9", shoe.getSizes());
        assertEquals(2000, shoe.getPrice());
    }

    @Test
    public void testShoeSettersAndGetters() {
        Shoe shoe = new Shoe();
        shoe.setId(101);
        shoe.setImage("1.png");
        shoe.setName("BlueWave Running Shoes");
        shoe.setCategory("Sports");
        shoe.setSizes("7, 8, 9");
        shoe.setPrice(2000);

        assertEquals(101, shoe.getId());
        assertEquals("1.png", shoe.getImage());
        assertEquals("BlueWave Running Shoes", shoe.getName());
        assertEquals("Sports", shoe.getCategory());
        assertEquals("7, 8, 9", shoe.getSizes());
        assertEquals(2000, shoe.getPrice());
    }
}