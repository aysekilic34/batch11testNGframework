package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HW_IframeHomeWork  extends TestBase {

    @Test
    public void test() throws InterruptedException {
        //1.“http://webdriveruniversity.com/IFrame/index.html” sayfasina gidin
        // 2.“Our Products” butonuna basin
        // 3.“Cameras product”i tiklayin
        // 4.Popup mesajini yazdirin
        // 5.“close” butonuna basin
        // 6."WebdriverUniversity.com (IFrame)" linkini tiklayin
        // 7."http://webdriveruniversity.com/index.html" adresine gittigini test edin


      driver.get("http://webdriveruniversity.com/IFrame/index.html");

      //2
        WebElement iFrame=driver.findElement(By.id("frame"));
        driver.switchTo().frame(iFrame);
        driver.findElement(By.linkText("Our Products")).click();
        //3
        driver.findElement(By.xpath("//*[text()='Cameras']")).click();
        //4
        WebElement message=driver.findElement(By.className("modal-body"));
        System.out.println("popup mesajı"+ message.getText());

        //5
        driver.findElement(By.xpath("(//button[@class='btn btn-default'])[2]")).click();

        //6
        driver.switchTo().defaultContent();
        driver.findElement(By.partialLinkText("WebdriverUniversity")).click();

        Thread.sleep(5000);

        //7
        String actualURL=driver.getCurrentUrl();
        Assert.assertEquals(actualURL,"http://webdriveruniversity.com/index.html");




    }
}
