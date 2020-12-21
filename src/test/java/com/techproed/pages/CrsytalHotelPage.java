package com.techproed.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CrsytalHotelPage {
   WebDriver driver;

   public CrsytalHotelPage(WebDriver driver){
       this.driver=driver;
       PageFactory.initElements(driver,this);
   }
    @FindBy(linkText="Log in")
    public  WebElement ilkLogin;
   @FindBy(id = "UserName")
    public WebElement usernameTextBox;
   @FindBy(id = "Password")
    public WebElement passwordTextBox;
    @FindBy(id = "btnSubmit")
    public  WebElement ikinciLoginButonu;




}
