package com.java8.stream;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

enum CaloricLevel {
	DIET, NORMAL, FAT
}

public class Dish_Stream {

	public static void main(String[] args) {
		List<Dish> dishes = List.of(new Dish("Margherita Pizza", "Vegetarian", 250, 8.99, false, "Italian", 200),
				new Dish("Chicken Tikka Masala", "Non-Vegetarian", 450, 12.99, true, "Indian", 300),
				new Dish("Sushi", "Non-Vegetarian", 200, 15.99, false, "Japanese", 150),
				new Dish("Caesar Salad", "Vegetarian", 180, 7.99, false, "American", 250),
				new Dish("Pad Thai", "Vegetarian", 400, 10.99, true, "Thai", 350),
				new Dish("Beef Stroganoff", "Non-Vegetarian", 500, 14.99, false, "Russian", 300),
				new Dish("Falafel", "Vegan", 300, 6.99, true, "Middle Eastern", 200),
				new Dish("Pasta Carbonara", "Non-Vegetarian", 550, 13.99, false, "Italian", 250),
				new Dish("Vegetable Stir Fry", "Vegan", 220, 9.99, true, "Chinese", 300),
				new Dish("Chocolate Cake", "Vegetarian", 600, 5.99, false, "Dessert", 100));

		// -------------------Joining using reduce and
		// reducing-----------------------------//

		String collect = dishes.stream().map(Dish::getCuisine).collect(Collectors.joining(", "));
		System.out.println(collect);

		Optional<String> reduce = dishes.stream().map(Dish::getCuisine).reduce((d1, d2) -> d1 + ", " + d2);
		System.out.println(reduce.get());

		Optional<String> collect2 = dishes.stream().map(Dish::getCuisine)
				.collect(Collectors.reducing((d1, d2) -> d1 + ", " + d2));
		System.out.println(collect2.get());

		String collect3 = dishes.stream()
				.collect(Collectors.reducing("", Dish::getCuisine, (d1, d2) -> d1 + ", " + d2));
		System.out.println(collect3);

		// -------------------grouping-----------------------------//

		// dishes by type

		Map<String, List<Dish>> collect4 = dishes.stream().collect(Collectors.groupingBy(Dish::getType));
		System.out.println(collect4);

//		
//		 you could decide to classify as “diet” all dishes with 400 calories or fewer, set to
//		“normal” the dishes having between 400 and 700 calories, and set to “fat” the ones with more
//		than 7

		Map<CaloricLevel, List<Dish>> collect5 = dishes.stream().collect(Collectors.groupingBy(d -> {
			if (d.getCalories() <= 200) {
				return CaloricLevel.DIET;
			} else if (d.getCalories() <= 300 && d.getCalories() > 200) {
				return CaloricLevel.NORMAL;
			} else {
				return CaloricLevel.FAT;
			}
		}));

		System.out.println(collect5);

		// -------------------MultiLevel Grouping-----------------------------//

		Map<String,Map<CaloricLevel,List<Dish>>> collect6 = dishes.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.groupingBy(dish -> {
			if (dish.getCalories() < 200) {
				return CaloricLevel.DIET;
			} else if (dish.getCalories() > 200 && dish.getCalories() < 300) {
				return CaloricLevel.NORMAL;
			} else {
				return CaloricLevel.FAT;
			}
		}
		)));
		System.out.println(collect6);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}
}
