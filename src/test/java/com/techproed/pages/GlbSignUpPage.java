package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GlbSignUpPage {

   public GlbSignUpPage(){
       PageFactory.initElements(Driver.getDriver(),this);
   }
   @FindBy(id = "email")
    public WebElement mail;
   @FindBy(xpath = "//input[@name='name']")
    public WebElement name;
   @FindBy(xpath ="//input[@id='mobile']")
    public WebElement phone;
   @FindBy(xpath = "//input[@id='password']")
    public WebElement pass;
   @FindBy(id = "re_password")
    public WebElement repass;
   @FindBy(xpath = "//button[@value='Login']")
    public WebElement glogin;
    @FindBy(xpath = "//div[@class='alert alert-success']")
    public WebElement basariliTex;

}
