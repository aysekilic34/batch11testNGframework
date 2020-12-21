package com.techproed.smoketest;

import com.techproed.pages.CrsytalHotelPage;
import com.techproed.utilities.TestBase;
import org.testng.annotations.Test;

public class NegativeTestWithPage extends TestBase {

    @Test
    public void test(){
        // 1) smokeTestpaketi altinda yeni bir Class olustur: NegativeTest
        // 3 Farkli test Methodunda 3 senaryoyu test et
        // -yanlisSifre
        // -yanlisKulllanici
        // -yanlisSifreKullanici
        // test data dogru username: manager , dogru password : Manager2!
        // 2)http://qa-environment.crystalkeyhotels.com adresine git
        // 3) Login butonuna bas
        // 4) Verilen senaryolar ile giris yapilamadigini test et

        driver.get("http://qa-environment.crystalkeyhotels.com");
        CrsytalHotelPage crsytalHotelPage=new CrsytalHotelPage(driver);
        crsytalHotelPage.ilkLogin.click();
        crsytalHotelPage.usernameTextBox.sendKeys("manager");
        crsytalHotelPage.usernameTextBox.sendKeys("123");
        crsytalHotelPage.ikinciLoginButonu.click();


    }
}
