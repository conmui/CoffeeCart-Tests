package org.example.tests;

import org.example.Beverage;
import org.example.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ProductsTest extends BaseTest {
    @DataProvider(name = "productsProvider")
    public Object[][] createProducts() {
        return new Object[][] { {ESPRESSO}, {ESPRESSOMACCHIATO}, {CAPPUCCINO}, {MOCHA}, {AMERICANO}, {CAFELATTE}, {ESPRESSOCONPANA}, {CAFEBREVE} };
    }

    @Test(dataProvider = "productsProvider")
    public void verifyProducts(Beverage beverage) {
        HomePage homePage = new HomePage(driver);
        String dataTest = beverage.getDataTest();

        Assert.assertTrue(homePage.isNamePriceVisible(dataTest));
        Assert.assertEquals(homePage.getNameText(dataTest), beverage.getName());
        Assert.assertEquals(homePage.getPriceText(dataTest), beverage.getPrice());

        Assert.assertTrue(homePage.isIngredientsVisible(dataTest));
        Assert.assertEqualsNoOrder(homePage.getIngredientsText(dataTest), beverage.getIngredients());
    }
}
