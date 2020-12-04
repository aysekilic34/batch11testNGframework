package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

// Bir class oluşturun: DropDown
// https://the-internet.herokuapp.com/dropdown adresine gidin.
//		1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
//		2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
//		3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin
//			ve yazdırın
//		4.Tüm dropdown değerleri(value) yazdırın
//		5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda
//			True , degilse False yazdırın.


public class D09_Dropdown {
    WebDriver driver;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void dropdownTesti() {
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement dropdown = driver.findElement(By.xpath("//select[@id='dropdown']"));
        //select objesı olustur.locate errıgımız webelementı parametre olarak ekldık
        Select select = new Select(dropdown);
        //		1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        select.selectByIndex(1);
        String ilkSecilenOpsiyon = select.getFirstSelectedOption().getText();
        //sectiğiniz option nun "Option 1" oldugunu test edin
        Assert.assertEquals(ilkSecilenOpsiyon, "Option 1");
    }


     @Test
     public void dropdownTesti2(){
         // 2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
         WebElement dropdown = driver.findElement(By.xpath("//select[@id='dropdown']"));
         Select select = new Select(dropdown);
         select.selectByValue("2");
         String ikinciSecilenOpsiyon= select.getFirstSelectedOption().getText();
         Assert.assertEquals(ikinciSecilenOpsiyon,"Option 2");
        }

        @Test
       //listenin tmaını yazınız
                public void dropdownTesti3(){
        WebElement dropdown=driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select select=new Select(dropdown);
            List<WebElement> listeninTamami=select.getOptions();

            for (WebElement w:listeninTamami
                 ) {
                System.out.println(w.getText());
            }
            //      5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda
            //          True , degilse False yazdırın.
            int listeninBoyutu=listeninTamami.size();
            if (listeninBoyutu==4){
                System.out.println("True");
            } else {
                System.out.println("False");
            }


        }



        @AfterClass
    public void tearDown(){
        driver.close();
    }
}
