package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Set;

public class D13_WindowsHandle2  extends TestBase {

    @Test
    public void test(){
        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın
        WebElement sayfadakiText=driver.findElement(By.tagName("h3"));
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(sayfadakiText.getText(),"Opening a new window");

        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String actualTitle=driver.getTitle();
        softAssert.assertEquals(actualTitle,"The Internet");


        //● Click Here butonuna basın.
        driver.findElement(By.linkText("Click Here")).click();

        String  ilkSayfaWindowHandle=driver.getWindowHandle();
        Set<String> tumWindowHandle=driver.getWindowHandles();
        String ikinciSayfaWindowHandle="";
        for (String w:tumWindowHandle
             ) {
            if(!w.equals(ilkSayfaWindowHandle)){
                ikinciSayfaWindowHandle=w;
            }
  }

        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        driver.switchTo().window(ikinciSayfaWindowHandle);  //artık 2.sayfadayayım

        String ikinciSayfaActual=driver.getTitle();
        softAssert.assertEquals(ikinciSayfaActual,"New Window");

        //● Sayfadaki textin “New Window” olduğunu doğrulayın.
        WebElement ikinciSayfaYaziElementi=driver.findElement(By.tagName("h3"));
        softAssert.assertEquals(ikinciSayfaYaziElementi.getText(),"New Window");

        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
        driver.switchTo().window(ilkSayfaWindowHandle);

        softAssert.assertEquals(actualTitle,"The Internet");





    }


}
