package org.example.tests;

import org.example.pages.HomePage;
import org.testng.annotations.Test;

public class AddToCartWithModal extends BaseTest {
    @Test
    public void verifyCartPreview() {
        HomePage homePage = new HomePage(driver);

        homePage.addToCartModal(MOCHA.getDataTest(), false);

    }
}
