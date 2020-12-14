package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HW_ExplicitWaitHomeWork extends TestBase {

    //1." https://demoqa.com/dynamic-properties” sayfasina gidin
    // 2.“Visible After 5 Seconds” butonunun gorunun oldugunu test edin

    @Test
    public void test()
    {
        driver.get("https://demoqa.com/dynamic-properties");

      WebDriverWait wait=new WebDriverWait(driver,30);

      WebElement gorunenButon=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("visibleAfter")));
      Assert.assertTrue(gorunenButon.isDisplayed());
    }








}
