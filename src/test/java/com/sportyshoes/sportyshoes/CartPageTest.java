package com.sportyshoes.sportyshoes;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.Test;
import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CartPageTest {
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
    public void addToCartTest(){
        driver.get("http://localhost:8080/home");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,750)");
        js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[@id='cart101']")));
        assertEquals("http://localhost:8080/add-to-cart?id=101",driver.getCurrentUrl());
    }

    @Test
    public void checkoutCartAndPlaceOrderTest(){
        driver.get("http://localhost:8080/home");
        driver.findElement(By.xpath("//a[normalize-space()='Cart']")).click();
        assertTrue(driver.findElement(By.cssSelector("div[class='mt-4 p-5 bg-primary text-white rounded'] h5[class='card-title']")).isDisplayed());
        driver.findElement(By.xpath("//a[@id='place-order']")).click();
        assertTrue(driver.findElement(By.xpath("//strong[normalize-space()='Success!']")).isDisplayed());
    }
}
