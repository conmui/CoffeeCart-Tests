package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomePage extends BasePage {
    By cartPreview = By.xpath("//button[@data-test='checkout']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    // ProductsTest
    public boolean isNamePriceVisible(String dataTest) {
        WebElement namePrice = driver.findElement(By.xpath("//div[@data-test='"+dataTest+"']/ancestor::li/h4"));

        return namePrice.isDisplayed();
    }

    public String getNameText(String dataTest) {
        String name = driver.findElement(By.xpath("//div[@data-test='" + dataTest + "']/ancestor::li/h4")).getText();

        return name.split("\n")[0];
    }

    public String getPriceText(String dataTest) {
        WebElement price = driver.findElement(By.xpath("//div[@data-test='" + dataTest + "']/ancestor::li/h4/small"));

        return price.getText();
    }

    public boolean isIngredientsVisible(String dataTest) {
        List<WebElement> ingredients = driver.findElements(By.xpath("//div[@data-test='" + dataTest + "']/div"));

        for (WebElement ingredient : ingredients) {
            if (!ingredient.isDisplayed()) {
                return false;
            }
        }
        return true;
    }

    public List<String> getIngredientsText(String dataTest) {
        List<WebElement> ingredients = driver.findElements(By.xpath("//div[@data-test='" + dataTest + "']/div"));
        List<String> ingredientsText = new ArrayList<>();

        for (WebElement ingredient : ingredients) {
            ingredientsText.add(ingredient.getText());
        }

        return ingredientsText;
    }

    //AddToCartTest
    public void addToCart(String dataTest) {
        WebElement product = driver.findElement(By.xpath("//div[@data-test='" + dataTest + "']"));

        product.click();
    }

    public void hoverOverCartPreview() {
        WebElement checkout = driver.findElement(cartPreview);

        Actions action = new Actions(driver);
        action.moveToElement(checkout).perform();
    }

    public Map<String, Integer> getProductsFromCartPreview() {
        List<WebElement> products = driver.findElements(By.className("list-item"));
        Map<String, Integer> cartPreviewItems = new HashMap<>();

        for (WebElement product : products) {
            String name = product.findElement(By.cssSelector("div span")).getText();
            String quantityText = product.findElement(By.className("unit-desc")).getText();
            int quantity = Integer.parseInt(quantityText.split(" ")[1]);

            cartPreviewItems.put(name, quantity);
        }

        return cartPreviewItems;
    }

}
