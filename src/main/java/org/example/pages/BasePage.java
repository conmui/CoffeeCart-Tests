package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
    WebDriver driver;
    private By cartLink = By.xpath("//a[@href='/cart']");

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public CartPage navigateToCart() {
        WebElement cartBtn = driver.findElement(cartLink);

        cartBtn.click();

        return new CartPage(driver);
    }
}
