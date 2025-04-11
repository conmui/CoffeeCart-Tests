package org.example.tests;

import org.example.pages.CartPage;
import org.example.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class AddToCartTest extends BaseTest {

    @Test(enabled = false)
//    @Test
    public void verifyCartPreview() {
        HomePage homePage = new HomePage(driver);
        Map<String, Integer> expected = Map.of(AMERICANO.getName(), 1, ESPRESSOCONPANA.getName(), 2, MOCHA.getName(), 1);

        homePage.addToCart(MOCHA.getDataTest());
        homePage.addToCart(AMERICANO.getDataTest());
        homePage.addToCart(ESPRESSOCONPANA.getDataTest());
        homePage.addToCart(ESPRESSOCONPANA.getDataTest());

        homePage.hoverOverCartPreview();

        Map<String, Integer> actual = homePage.getProductsFromCartPreview();

        Assert.assertEquals(actual, expected);
    }

    @Test(enabled = false)
//    @Test
    public void verifyCartPage() {
        HomePage homePage = new HomePage(driver);
        Map<String, Integer> expected = Map.of(ESPRESSOMACCHIATO.getName(), 1, CAPPUCCINO.getName(), 1, CAFELATTE.getName(), 1);

        homePage.addToCart(ESPRESSOMACCHIATO.getDataTest());
        homePage.addToCart(CAPPUCCINO.getDataTest());
        homePage.addToCart(CAFELATTE.getDataTest());

        CartPage cartPage = homePage.navigateToCart();

        Map<String, Integer> actual = cartPage.getProductsFromCartPage();

        Assert.assertEquals(actual, expected);
    }


//    @Test(enabled = false)
    @Test
    public void addRightClickAndVerifyCartPreview() {
        HomePage homePage = new HomePage(driver);

        homePage.addToCartRightClick(ESPRESSOMACCHIATO.getDataTest());
    }

    //verifyCartPreviewWithCoupon
    //verifyCartPreviewWithCoupon
}
