package com.techproed.smoketest;

import com.techproed.pages.GlbSignUpPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GlbSignUpTest {
    @Test (groups = "grup1")
    public void girisTesti(){
        Driver.getDriver().get(ConfigReader.getProperty("gb_url"));
        GlbSignUpPage glbSignUpPage=new GlbSignUpPage();
        glbSignUpPage.mail.sendKeys(ConfigReader.getProperty("gb_mail"));
        glbSignUpPage.name.sendKeys(ConfigReader.getProperty("gb_name"));
        glbSignUpPage.phone.sendKeys(ConfigReader.getProperty("gb_phone"));
        glbSignUpPage.pass.sendKeys(ConfigReader.getProperty("gb_pass"));
        glbSignUpPage.repass.sendKeys(ConfigReader.getProperty("gb_repass"));
        glbSignUpPage.glogin.click();
        Assert.assertEquals(glbSignUpPage.basariliTex.getText(),"Success! !");

    }
}
