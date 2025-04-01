package org.example.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {
    @Test
    public void verifyURL() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://coffee-cart.app/");
    }

    @Test
    public void verifyTitle() {
        Assert.assertEquals(driver.getTitle(), "Coffee cart");
    }
}
