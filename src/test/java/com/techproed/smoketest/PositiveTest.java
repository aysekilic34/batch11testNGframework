package com.techproed.smoketest;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveTest extends TestBase {

    //1) com.techproedaltinda bir package olustur :smoketest
    // 2) Bir Class olustur : PositiveTest
    // 3) Bir test method olustur positiveLoginTest()
    // http://qa-environment.crystalkeyhotels.com adresine git
    // login butonuna bas
    // test data username: manager ,
    // test data password : Manager2!
    // Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et

    @Test

    public void positiveLoginTest() {
        driver.get("http://qa-environment.crystalkeyhotels.com");
        driver.findElement(By.linkText("Log in")).click();

        WebElement usernameTextBox=driver.findElement(By.id("UserName"));
        usernameTextBox.sendKeys("manager");
        WebElement passwordTextBox=driver.findElement(By.id("Password"));
        passwordTextBox.sendKeys("Manager2!");
        driver.findElement(By.id("btnSubmit")).click();

        WebElement adduser=driver.findElement(By.xpath("//*[text()='Add User ']"));
        Assert.assertTrue(adduser.isDisplayed());
    }
}