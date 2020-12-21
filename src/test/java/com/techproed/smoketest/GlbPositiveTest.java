package com.techproed.smoketest;

import com.techproed.pages.GlbHomePage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GlbPositiveTest {

    @Test

    public void PositiveTest() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("gb_url"));
        GlbHomePage glbHomePage=new GlbHomePage();

        glbHomePage.homesign.click();
        glbHomePage.homemail.sendKeys(ConfigReader.getProperty("gb_mail"));
        glbHomePage.homepass.sendKeys(ConfigReader.getProperty("gb_pass"));
        glbHomePage.homelogin.click();

        Thread.sleep(3000);
        Assert.assertEquals(glbHomePage.girisBasarili.getText(),ConfigReader.getProperty("gb_giris_basarili"));

        Driver.closeDriver();


    }
}
