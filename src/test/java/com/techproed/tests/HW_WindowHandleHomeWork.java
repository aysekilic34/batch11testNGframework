package com.techproed.tests;

import com.github.javafaker.Faker;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class HW_WindowHandleHomeWork extends TestBase {

    //1."http://webdriveruniversity.com/" adresine gidin
    // 2."Login Portal" a  kadar asagi inin
    // 3."Login Portal" a tiklayin
    // 4.Diger window'a gecin
    // 5."username" ve  "password" kutularina deger yazdirin
    // 6."login" butonuna basin
    // 7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
    // 8.Ok diyerek Popup'i kapatin
    // 9.Ilk sayfaya geri donun
    // 10.Ilk sayfaya donuldugunu test edin

    @Test
    public void test() throws InterruptedException {
        driver.get("http://webdriveruniversity.com/");
        Thread.sleep(3000);
        //2
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        //^3
        driver.findElement(By.xpath("//*[text()='Login Portal']")).click();


        //4
        String ilkSayfahandle=driver.getWindowHandle();
        System.out.println(ilkSayfahandle);

        Set<String> tumHandleKumesi=driver.getWindowHandles();

        String ikinciSayfaHandle="";

        for (String w:tumHandleKumesi
             ) {
            if(!w.equals(ilkSayfahandle)){
                ikinciSayfaHandle=w;
            }
          }

        driver.switchTo().window(ikinciSayfaHandle);

        //5

        WebElement nameTextBox=driver.findElement(By.id("text"));

        Faker faker=new Faker();
        actions.click(nameTextBox)
                .sendKeys(faker.name().username())
                .sendKeys(Keys.ENTER)
                .sendKeys(faker.internet().password())
                .sendKeys(Keys.ENTER)
                .perform();
        //7
        String popupYazisi=driver.switchTo().alert().getText();
        Assert.assertEquals(popupYazisi,"validation failed");

        //8
        driver.switchTo().alert().accept();

        //9
        driver.switchTo().window(ilkSayfahandle);

        //10
        String ilkSayfaURL=driver.getCurrentUrl();

        Assert.assertEquals(ilkSayfaURL,"http://webdriveruniversity.com/");



    }


}
