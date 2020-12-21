package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GlbHomePage {

   public GlbHomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(linkText = "Sign In")
    public WebElement homesign;
    @FindBy(id = "email")
    public WebElement homemail;

    @FindBy(id = "password")
    public WebElement homepass;

    @FindBy(xpath = "//button[@value='Login']")
    public WebElement homelogin;

     @FindBy(xpath ="//div[@class='my_account_header']")
     public WebElement girisBasarili;

     @FindBy(xpath = "//div[@class='alert alert-danger']")
      public WebElement girisBasarisiz;


}
