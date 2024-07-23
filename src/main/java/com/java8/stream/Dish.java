package com.java8.stream;

public class Dish {
    private String name;
    private String type; // e.g., "Vegetarian", "Non-Vegetarian", "Vegan"
    private int calories;
    private double price;
    private boolean isSpicy;
    private String cuisine; // e.g., "Italian", "Chinese", "Indian"
    private int servingSize; // e.g., in grams or milliliters

    // Default constructor
    public Dish() {}

    // Parameterized constructor
    public Dish(String name, String type, int calories, double price, boolean isSpicy, String cuisine, int servingSize) {
        this.name = name;
        this.type = type;
        this.calories = calories;
        this.price = price;
        this.isSpicy = isSpicy;
        this.cuisine = cuisine;
        this.servingSize = servingSize;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isSpicy() {
        return isSpicy;
    }

    public void setSpicy(boolean isSpicy) {
        this.isSpicy = isSpicy;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public int getServingSize() {
        return servingSize;
    }

    public void setServingSize(int servingSize) {
        this.servingSize = servingSize;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", calories=" + calories +
                ", price=" + price +
                ", isSpicy=" + isSpicy +
                ", cuisine='" + cuisine + '\'' +
                ", servingSize=" + servingSize +
                '}';
    }
}
