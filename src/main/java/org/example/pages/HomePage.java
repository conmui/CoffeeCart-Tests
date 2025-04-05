package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

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
}
