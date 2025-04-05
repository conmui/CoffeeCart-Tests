package org.example;

import java.util.List;

public class Beverage {
    private String name;
    private String dataTest;
    private String price;
    private List<String> ingredients;

    public Beverage(String name, String dataTest, String price, List<String> ingredients) {
        this.name = name;
        this.dataTest = dataTest;
        this.price = price;
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }

    public String getDataTest() {
        return dataTest;
    }

    public String getPrice() {
        return "$" + price + ".00";
    }

    public List<String> getIngredients() {
        return ingredients;
    }
}
