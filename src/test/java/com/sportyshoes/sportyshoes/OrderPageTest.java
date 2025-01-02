package com.sportyshoes.sportyshoes;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class OrderPageTest {
    private WebDriver driver;

    @BeforeTest
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("http://localhost:8080");
        driver.findElement(By.xpath("//input[@placeholder='Enter email']")).sendKeys("john@example.com");
        driver.findElement(By.xpath("//input[@placeholder='Enter password']")).sendKeys("john123");
        driver.findElement(By.xpath("//button[normalize-space(text())='Login']")).click();
        assertEquals("Logout",driver.findElement(By.xpath("//a[normalize-space(text())='Logout']")).getText());
    }

    @Test
    public void openOrdersPage(){
        driver.get("http://localhost:8080/home");
        driver.findElement(By.xpath("//a[normalize-space()='Orders']")).click();
        assertEquals("http://localhost:8080/orders",driver.getCurrentUrl());
        assertTrue(driver.findElement(By.xpath("//div/h5[@class='card-title']")).isDisplayed());

    }
}
