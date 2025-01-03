package com.sportyshoes.sportyshoes.seleniumtests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomePageTest {
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
    public void homePageTest() {
        driver.get("http://localhost:8080/home");
        assertTrue(driver.findElement(By.xpath("//div[@class='mt-4 p-5 bg-primary text-white rounded']")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("//div/h1[text()='Sporty Shoes']")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("//img[@alt='Banner Image']")).isDisplayed());
    }
}
