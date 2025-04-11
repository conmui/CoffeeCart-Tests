package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CartPage extends BasePage {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    public Map<String, Integer> getProductsFromCartPage() {
        List<WebElement> products = driver.findElements(By.cssSelector(".list > div > ul > .list-item"));
        Map<String, Integer> cartPageProducts = new HashMap<>();

        for (WebElement product : products) {
            String name = product.findElement(By.cssSelector("div:first-of-type")).getText();
            String quantityText = product.findElement(By.className("unit-desc")).getText();
            int quantity = Integer.parseInt(quantityText.split(" x ")[1]);

            cartPageProducts.put(name, quantity);
        }

        return cartPageProducts;
    }
}