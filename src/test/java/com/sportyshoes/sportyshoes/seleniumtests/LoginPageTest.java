package com.sportyshoes.sportyshoes.seleniumtests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.testng.Assert.assertEquals;

public class LoginPageTest {
    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
    }
    @Test
    public void loginTest() throws InterruptedException {
        driver.get("http://localhost:8080");
        driver.findElement(By.xpath("//input[@placeholder='Enter email']")).sendKeys("john@example.com");
        driver.findElement(By.xpath("//input[@placeholder='Enter password']")).sendKeys("john123");
        driver.findElement(By.xpath("//button[normalize-space(text())='Login']")).click();
        assertEquals("Logout",driver.findElement(By.xpath("//a[normalize-space(text())='Logout']")).getText());
        Thread.sleep(5000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,750)");
    }
}
