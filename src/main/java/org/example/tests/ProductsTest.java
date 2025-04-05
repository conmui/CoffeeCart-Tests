package org.example.tests;

import org.example.Beverage;
import org.example.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class ProductsTest extends BaseTest {
    @DataProvider(name = "productsProvider")
    public Object[][] createProducts() {
        return new Object[][] {
                {new Beverage("Espresso", "Espresso", "10", List.of("espresso"))},
                {new Beverage("Espresso Macchiato", "Espresso_Macchiato", "12", List.of("milk foam", "espresso"))},
                {new Beverage("Cappuccino", "Cappuccino", "19", List.of("milk foam", "steamed milk", "espresso"))},
                {new Beverage("Mocha", "Mocha", "8", List.of("whipped cream", "steamed milk", "chocolate syrup", "espresso"))},
                {new Beverage("Flat White", "Flat_White", "18", List.of("steamed milk", "espresso"))},
                {new Beverage("Americano", "Americano", "7", List.of("water", "espresso"))},
                {new Beverage("Cafe Latte", "Cafe_Latte", "16", List.of("milk foam", "steamed milk", "espresso"))},
                {new Beverage("Espresso Con Panna", "Espresso_Con Panna", "14", List.of("whipped cream", "espresso"))},
                {new Beverage("Cafe Breve", "Cafe_Breve", "15", List.of("milk foam", "steamed cream", "steamed milk", "espresso"))}
        };
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
