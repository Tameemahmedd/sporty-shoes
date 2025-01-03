package com.sportyshoes.sportyshoes.seleniumtests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LogoutPageTest {
    private WebDriver driver;

    @BeforeTest
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("http://localhost:8080");
        driver.findElement(By.xpath("//input[@placeholder='Enter email']")).sendKeys("john@example.com");
        driver.findElement(By.xpath("//input[@placeholder='Enter password']")).sendKeys("john123");
        driver.findElement(By.xpath("//button[normalize-space(text())='Login']")).click();
}
    @Test
    public void logoutTest(){
        driver.get("http://localhost:8080/home");
        driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();
        assertTrue(driver.findElement(By.xpath("//h2[normalize-space()='Login Yourself']")).isDisplayed());
    }
}
