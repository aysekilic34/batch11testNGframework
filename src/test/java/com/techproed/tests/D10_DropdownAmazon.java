package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class D10_DropdownAmazon {
    //● https://www.amazon.com/ adresine gidin.
    //      - Test 1
    //          Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin
    //      -Test 2
    //          1. Kategori menusunden Books secenegini  secin
    //          2. Arama kutusuna Java yazin ve aratin
    //          3. Bulunan sonuc sayisini yazdirin
    //          4. Sonucun Java kelimesini icerdigini test edin

    WebDriver driver;
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
    @BeforeMethod
    public void sayfayaGit(){
        driver.get("https://www.amazon.com/");
    }


    @Test
    //Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin
    public void test1(){
        WebElement dropdown=driver.findElement(By.id("searchDropdownBox"));
        Select select=new Select(dropdown);
        List<WebElement> fullList=select.getOptions();

        int katagoriSayisi=fullList.size()-1;
        Assert.assertEquals(katagoriSayisi,45);}

    @Test
    public void javaTest() {
        // 1. Kategori menusunden Books secenegini  secin
        WebElement dropdown = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(dropdown);
        select.deselectByValue("Books");
        //          2. Arama kutusuna Java yazin ve aratin
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Java" + Keys.ENTER);

        //          3. Bulunan sonuc sayisini yazdirin
        WebElement sonucSayisi = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(sonucSayisi.getText());

        //          4. Sonucun Java kelimesini icerdigini test edin

        Assert.assertTrue(sonucSayisi.getText().contains("Java"));
    }
    @AfterClass
    public void tearDown(){
        driver.close();
    }








}
