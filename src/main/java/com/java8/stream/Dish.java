package com.java8.stream;

public class Dish {
	private String name;

	private int calories;

	private String type;

	public Dish(String name, int calories, String type) {
		super();
		this.name = name;
		this.calories = calories;
		this.type = type;
	}

	public Dish() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCalories() {
		return calories;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
