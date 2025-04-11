package org.example.tests;

import org.example.Beverage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.List;

public class BaseTest {
    WebDriver driver;
    final Beverage ESPRESSO = new Beverage("Espresso", "Espresso", "10", List.of("espresso"));
    final Beverage ESPRESSOMACCHIATO = new Beverage("Espresso Macchiato", "Espresso_Macchiato", "12", List.of("milk foam", "espresso"));
    final Beverage CAPPUCCINO = new Beverage("Cappuccino", "Cappuccino", "19", List.of("milk foam", "steamed milk", "espresso"));
    final Beverage MOCHA = new Beverage("Mocha", "Mocha", "8", List.of("whipped cream", "steamed milk", "chocolate syrup", "espresso"));
    final Beverage AMERICANO = new Beverage("Americano", "Americano", "7", List.of("water", "espresso"));
    final Beverage CAFELATTE = new Beverage("Cafe Latte", "Cafe_Latte", "16", List.of("milk foam", "steamed milk", "espresso"));
    final Beverage ESPRESSOCONPANA = new Beverage("Espresso Con Panna", "Espresso_Con Panna", "14", List.of("whipped cream", "espresso"));
    final Beverage CAFEBREVE = new Beverage("Cafe Breve", "Cafe_Breve", "15", List.of("milk foam", "steamed cream", "steamed milk", "espresso"));

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://coffee-cart.app/");
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
