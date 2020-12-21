package com.techproed.smoketest;

import com.techproed.pages.CrsytalHotelPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.TestBase;
import org.testng.annotations.Test;

public class PositiveTestPOM extends TestBase {
    //1) com.techproedaltinda bir package olustur :smoketest
    // 2) Bir Class olustur : PositiveTest
    // 3) Bir test method olustur positiveLoginTest()
    // http://qa-environment.crystalkeyhotels.com adresine git
    // login butonuna bas
    // test data username: manager ,
    // test data password : Manager2!
    // Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et

    @Test
    public void test(){
        driver.get(ConfigReader.getProperty("c_url"));

        CrsytalHotelPage crsytalHotelPage=new CrsytalHotelPage(driver);
        crsytalHotelPage.ilkLogin.click();
        crsytalHotelPage.usernameTextBox.sendKeys("valid_user");
        crsytalHotelPage.usernameTextBox.sendKeys("valid_password");
        crsytalHotelPage.ikinciLoginButonu.click();
    }
}
