package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.testng.annotations.Test;

//extends child yapmak icin kullandık
public class D13_TestBaseIlkTest  extends TestBase {
    @Test
    public void test(){
        driver.get("https://www.youtube.com");
    }
}
