package org.example.tests;

import org.example.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartPageTest extends BaseTest {
    @Test
    public void verifyURL() {
        HomePage homepage = new HomePage(driver);

        homepage.navigateToCart();

        Assert.assertEquals(driver.getCurrentUrl(), "https://coffee-cart.app/cart");
    }

    @Test
    public void verifyTitle() {
        Assert.assertEquals(driver.getTitle(), "Coffee cart");
    }
}
