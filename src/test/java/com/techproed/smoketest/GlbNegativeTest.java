package com.techproed.smoketest;

import com.techproed.pages.GlbHomePage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GlbNegativeTest {

    @Test (groups = "grup1")
    public void yanlisMail() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("gb_url"));
        GlbHomePage glbHomePage=new GlbHomePage();
        glbHomePage.homesign.click();
        glbHomePage.homemail.sendKeys(ConfigReader.getProperty("gb_wrongmail"));
        glbHomePage.homepass.sendKeys(ConfigReader.getProperty("gb_pass"));
        Thread.sleep(3000);
        glbHomePage.homelogin.click();

        Thread.sleep(3000);

        Assert.assertTrue(glbHomePage.girisBasarisiz.getText().contains(ConfigReader.getProperty("gb_giris_basarisiz")));
        Driver.closeDriver();
    }

    @Test(groups = {"grup1","grup2"})
    public void yanlisPassword() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("gb_url"));
        GlbHomePage glbHomePage=new GlbHomePage();
        glbHomePage.homesign.click();
        glbHomePage.homemail.sendKeys(ConfigReader.getProperty("gb_mail"));
        glbHomePage.homepass.sendKeys(ConfigReader.getProperty("gb_wrongpass"));
        Thread.sleep(3000);
        glbHomePage.homelogin.click();
        Thread.sleep(3000);
        Assert.assertTrue(glbHomePage.girisBasarisiz.getText().contains(ConfigReader.getProperty("gb_giris_basarisiz")));
   Driver.closeDriver();
    }

    @Test(groups = {"grup2","grup3"})
    public void yanlisMailPassword() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("gb_url"));
        GlbHomePage glbHomePage=new GlbHomePage();
        glbHomePage.homesign.click();
        glbHomePage.homemail.sendKeys(ConfigReader.getProperty("gb_wrongmail"));
        glbHomePage.homepass.sendKeys(ConfigReader.getProperty("gb_wrongpass"));
        Thread.sleep(3000);
        glbHomePage.homelogin.click();
        Thread.sleep(3000);
        Assert.assertTrue(glbHomePage.girisBasarisiz.getText().contains(ConfigReader.getProperty("gb_giris_basarisiz")));
   Driver.closeDriver();
    }
}
