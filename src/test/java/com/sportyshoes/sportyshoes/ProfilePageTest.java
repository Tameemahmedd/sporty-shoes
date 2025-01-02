package com.sportyshoes.sportyshoes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ProfilePageTest {
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

    @Test(priority = 1)
    public void openProfilePageTest(){
        driver.get("http://localhost:8080/home");
        driver.findElement(By.xpath("//a[normalize-space()='Profile']")).click();
        assertEquals("http://localhost:8080/profile",driver.getCurrentUrl());
        assertTrue(driver.findElement(By.xpath("//div[@class='card-body']")).isDisplayed());}
    @Test(priority = 2)
    public void updateProfileTest(){
        driver.get("http://localhost:8080/home");
        driver.findElement(By.xpath("//a[normalize-space()='Profile']")).click();
        assertEquals("http://localhost:8080/profile",driver.getCurrentUrl());
        driver.findElement(By.xpath("//a[normalize-space()='Update Profile']")).click();
        assertEquals("http://localhost:8080/edit-profile",driver.getCurrentUrl());
        WebElement namePlaceholder=driver.findElement(By.xpath("//input[@id='name']"));
        namePlaceholder.clear();
        namePlaceholder.sendKeys("John Doe");
        driver.findElement(By.xpath("//button[normalize-space()='Edit Profile']")).click();
        assertEquals("http://localhost:8080/update-user-profile",driver.getCurrentUrl());
        assertEquals(driver.findElement(By.xpath("//p[normalize-space()='Message:John Doe Updated Successfully.']")).getText(),"Message:John Doe Updated Successfully.");

    }

}
