package com.techproed.smoketest;

import com.techproed.pages.CrsytalHotelPage;
import com.techproed.utilities.TestBase;
import org.testng.annotations.Test;

public class PositiveTestWithPage extends TestBase {
    @Test
    public void test(){
        //1) com.techproedaltinda bir package olustur :smoketest
        // 2) Bir Class olustur : PositiveTest
        // 3) Bir test method olustur positiveLoginTest()
        // http://qa-environment.crystalkeyhotels.com adresine git

        driver.get("http://qa-environment.crystalkeyhotels.com");
        // login butonuna bas
        CrsytalHotelPage crsytalHotelPage=new CrsytalHotelPage(driver);
        crsytalHotelPage.ilkLogin.click();
        // test data username: manager ,
        crsytalHotelPage.usernameTextBox.sendKeys("manager");
        // test data password : Manager2!
        crsytalHotelPage.passwordTextBox.sendKeys("Manager2!");
        crsytalHotelPage.ikinciLoginButonu.click();
        // Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et





    }
}
