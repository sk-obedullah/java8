package com.java8.stream;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamJava8 {

	/*
	 * What is Stream------------------------? a sequence of elements from a source
	 * that supports data processing operation
	 * 
	 * 
	 *
	 *
	 * important Functions--
	 * -----------------------------------------------------------------------------
	 * filter() and map() together sorted(Comparator.comparing(Dish::getCalories))
	 * sorted(Comparator.comparing(Dish::getCalories, Comparator.reverseOrder()))
	 * 
	 * //if the list contains null while sorting we can push the nulls either to the
	 * starting or end of the list//
	 * 
	 * sorted(Comparator.nullsFirst(Comparator.comparing(Dish::getCalories)))
	 * sorted(Comparator.nullsLast(Comparator.comparing(Dish::getCalories)))
	 * stream().distinct().
	 * 
	 */

	public static void main(String[] args) {
		List<Dish> dishes = Arrays.asList(new Dish("dish1", 100, "veg"), new Dish("dish2", 600, "veg"),
				new Dish("dish3", 400, "veg"), new Dish("dish4", 200, "veg"), new Dish("dish5", 160, "veg"),
				new Dish("dish6", 500, "veg"));

		/* listOut the dishes having calories above 300 */

		List<String> dishWithHighCal = dishes.stream().filter(dish -> dish.getCalories() > 300)
				.map(dish -> dish.getName()).collect(Collectors.toList());
		System.out.println(dishWithHighCal);

		/* listOut the dishes having calories above 300 in Default Sorting Order */

		List<String> dishWithHighCalInDefaultSorting = dishes.stream().filter(dish -> dish.getCalories() > 300)
				.sorted(Comparator.comparing(Dish::getCalories)).map(dish -> dish.getName())
				.collect(Collectors.toList());
		System.out.println(dishWithHighCalInDefaultSorting);

		/* listOut the dishes having calories above 300 in Reverse Sorting Order */

		List<String> dishWithHighCalInRevSorting = dishes.stream().filter(dish -> dish.getCalories() > 300)
				.sorted(Comparator.comparing(Dish::getCalories, Comparator.reverseOrder())).map(dish -> dish.getName())
				.collect(Collectors.toList());
		System.out.println(dishWithHighCalInRevSorting);

		/*
		 * if the List having Nulls - listOut the dishes having calories above 300 in
		 * Sorting Order
		 */

		List<String> dishWithHighCalInSortingByHandlingNullFirst = dishes.stream()
				.filter(dish -> dish.getCalories() > 300)
				.sorted(Comparator.nullsFirst(Comparator.comparing(Dish::getCalories))).map(dish -> dish.getName())
				.collect(Collectors.toList());
		System.out.println(dishWithHighCalInSortingByHandlingNullFirst);

		List<String> dishWithHighCalInSortingByHandlingNullLast = dishes.stream()
				.filter(dish -> dish.getCalories() > 300)
				.sorted(Comparator.nullsLast(Comparator.comparing(Dish::getCalories))).map(dish -> dish.getName())
				.collect(Collectors.toList());
		System.out.println(dishWithHighCalInSortingByHandlingNullLast);

		// get the repeated words in a List

		List<String> asList = Arrays.asList("java", "java", "spring");
		Map<String, Long> collect = asList.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println("----------");
		System.out.println(collect);

//		 Map<City, Set<String>> namesByCity
//		   = people.stream().collect(
//		     groupingBy(Person::getCity,
//		                mapping(Person::getLastName,
//		                        toSet())));

		List<String> listString = Arrays.asList("java", "java", "spring");
		listString.stream().distinct().collect(Collectors.toList());

		// Using of FlatMap--------------------//

//		list [1, 2, 3] and a list [3, 4] you should return [(1, 3), (1, 4), (2, 3), (2, 4), (3, 3), (3, 4)]

		List<Integer> numbers1 = Arrays.asList(1, 2, 3);
		List<Integer> numbers2 = Arrays.asList(3, 4);
		List<int[]> pairs = numbers1.stream().flatMap(i -> numbers2.stream().map(j -> new int[] { i, j }))
				.collect(Collectors.toList());
		System.out.println(pairs);

		// e list of words ["Hello", "World"] you’d like to return the list ["H", "e",
		// "l", "o","W", "r","d"]
		// words.stream().map(word->word.split(""))=Stream<String[]>
//		words.stream().map(word->word.split("")).flatMap(Arrays::stream)=Stream<String>
		List<String> words = Arrays.asList(new String[] { "Hello", "Hello" });
		List<String[]> collect3 = words.stream().map(word -> word.split("")).collect(Collectors.toList());
		System.out.println(collect3);
		List<String> collect2 = words.stream().map(word -> word.split("")).flatMap(Arrays::stream).distinct()
				.collect(Collectors.toList());
		System.out.println(collect2);

//		String ms="apple";
//		String[] split2 = ms.split("");
//	 Stream<Stream<String[]>> a
//	 Stream<String[]>
//	 [HelloH"e","l","l","o"]
		/*
		 * How would you extend the previous example to return only pairs whose sum is
		 * divisible by 3? For example, (2, 4) and (3, 3)
		 */

		List<int[]> collect4 = numbers1.stream()
				.flatMap(i -> numbers2.stream().filter(j -> (i + j) % 3 == 0).map(k -> new int[] { i, k }))
				.collect(Collectors.toList());
		System.out.println(collect4);

		// -------------------------------------------------------------------------------------------//

//			Given a list of integers, separate odd and even numbers?

		List<Integer> listOfIntegers = Arrays.asList(71, 18, 42, 21, 67, 32, 95, 14, 56, 87);
		Map<Boolean, List<Integer>> collect5 = listOfIntegers.stream()
				.collect(Collectors.partitioningBy(i -> i % 2 == 0));
		System.out.println(collect5);

//	         How do you remove duplicate elements from a list using Java 8 streams?

		List<String> listOfStrings = Arrays.asList("Java", "Python", "C#", "Java", "Kotlin", "Python");
		List<String> collect6 = listOfStrings.stream().distinct().collect(Collectors.toList());
		System.out.println(collect6);

//	         find frequency of each character in a string using Java 8 streams?

		String inputString = "Java Concept Of The Day";
		IntStream chars = inputString.chars();
		Map<Character, Long> collect7 = chars.mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(collect7);

		Map<String, Long> collect21 = Arrays.stream(inputString.split(""))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println("+++++++" + collect21);

//	         find frequency of each word in a para using Java 8 streams?

		System.out.println("******************************************************");

		String inputPara = "For those who are interested in finding random paragraphs, that's exactly what this webpage provides. If both a random word and a random sentence aren't quite long enough for your needs, then a random paragraph might be the perfect solution. Once you arrive at this page, you'll see a random paragraph. If you need another one, all you need to do is click on the \"next paragraph\" button. If you happen to need several random paragraphs all at once, you can use this other paragraph generator. Below you can find a number of ways that this generator. generator can be used";
		String[] split2 = inputPara.split(" ");
		System.out.println(split2);
		System.out.println(Arrays.toString(split2));
		List<String> asList2 = Arrays.asList(split2);

		Map<String, Long> collect8 = asList2.stream().peek(System.out::println)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(collect8);
		System.out.println("******************************************************");
//		find frequency of each element in an array or a list?

		List<String> stationeryList = Arrays.asList("Pen", "Eraser", "Note Book", "Pen", "Pencil", "Stapler",
				"Note Book", "Pencil");
		Map<String, Long> collect9 = stationeryList.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(collect9);

//		 sort the given list of decimals in sorting order?
		List<Double> decimalList = Arrays.asList(12.45, 23.58, 17.13, 42.89, 33.78, 71.85, 56.98, 21.12);
		List<Double> collect10 = decimalList.stream().sorted().collect(Collectors.toList());
		System.out.println("__________******************************************************");
		System.out.println(collect10);

//		 sort the given list of decimals in reverse Sorting order?
		List<Double> decimalList2 = Arrays.asList(12.45, 23.58, 17.13, 42.89, 33.78, 71.85, 56.98, 21.12);
		List<Double> collect11 = decimalList2.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		System.out.println(collect11);

//		 Given a list of strings, join the strings with ‘[‘ as prefix, ‘]’ as suffix and ‘,’ as delimiter?

		List<String> listOfStrings1 = Arrays.asList("Facebook", "Twitter", "YouTube", "WhatsApp", "LinkedIn");
		String collect12 = listOfStrings1.stream().collect(Collectors.joining("-", "\"", "\""));
		System.out.println(collect12);

//		 From the given list of integers, print the numbers which are multiples of 5?
		List<Integer> listOfIntegers1 = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);
		listOfIntegers1.stream().filter(num -> num % 5 == 0).forEach(System.out::println);

		System.out.println("-------------------------------------------------");
//		 Given a list of integers, find maximum and minimum of those numbers?

		List<Integer> listOfIntegers2 = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);
		Integer integer = listOfIntegers2.stream().max(Comparator.naturalOrder()).get();
		System.out.println(integer);

		System.out.println("-------------------------------------------------");

		Integer integer2 = listOfIntegers2.stream().min(Comparator.naturalOrder()).get();
		System.out.println(integer2);

		System.out.println("-------------------------------------------------");

//		 How do you merge two unsorted arrays into single sorted array using Java 8 streams?

		int[] a = new int[] { 4, 2, 7, 1 };
		int[] b = new int[] { 8, 3, 9, 5 };

		int[] array = IntStream.concat(Arrays.stream(a), Arrays.stream(b)).sorted().toArray();
		System.out.println(Arrays.toString(array));

		System.out.println("-------------------------------------------------");

//		How do you merge two unsorted arrays into single sorted array without duplicates?

		int[] a1 = new int[] { 4, 2, 5, 1 };
		int[] b1 = new int[] { 8, 1, 9, 5 };
		int[] array2 = IntStream.concat(Arrays.stream(a1), Arrays.stream(b1)).distinct().sorted().toArray();
		System.out.println(Arrays.toString(array2));

		System.out.println("-------------------------------------------------");

//		How do you get three maximum numbers and three minimum numbers from the given list of integers?

		List<Integer> listOfIntegers3 = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);
		List<Integer> collect13 = listOfIntegers3.stream().sorted().limit(3).collect(Collectors.toList());
		System.out.println(collect13);
		List<Integer> collect14 = listOfIntegers3.stream().sorted(Comparator.reverseOrder()).limit(3)
				.collect(Collectors.toList());
		System.out.println(collect14);

		System.out.println("-------------------------------------------------");

//		 Java 8 program to check if two strings are anagrams or not?

		String s1 = "RaceCar";
		String s2 = "CarRace";
		s1 = Stream.of(s1.split("")).map(String::toUpperCase).sorted().collect(Collectors.joining());
		s2 = Stream.of(s2.split("")).map(String::toUpperCase).sorted().collect(Collectors.joining());

		if (s1.equals(s2)) {
			System.out.println("words are anagram");
		} else {
			System.out.println("not a anagram");
		}

		System.out.println("-------------------------------------------------");

//		  Find sum of all digits of a number in Java 8?

		int i = 15623;
		Integer collect15 = Stream.of(String.valueOf(i).split("")).collect(Collectors.summingInt(Integer::parseInt));
		System.out.println(collect15);

		// OR

		String[] split = String.valueOf(i).split("");
		int sum2 = Stream.of(split).mapToInt(Integer::valueOf).sum();
		System.out.println("the other way to get SUM- " + sum2);

		System.out.println("-------------------------------------------------");

		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		OptionalDouble average = numbers.stream().mapToInt(Integer::intValue).average();
		System.out.println("average - " + average.getAsDouble());
		int sum = numbers.stream().mapToInt(Integer::intValue).sum();
		System.out.println("sum - " + sum);

		System.out.println("-------------------------------------------------");

//		  Find second largest number in an integer array?

		List<Integer> listOfIntegers4 = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);
		Integer integer3 = listOfIntegers4.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
		System.out.println("Second highes Elm - " + integer3);

		System.out.println("-------------------------------------------------");

//		 Given a list of strings, sort them according to increasing order of their length?

		List<String> listOfStrings2 = Arrays.asList("Java", "Python", "C#", "HTML", "Kotlin", "C++", "COBOL", "C");
		List<String> collect16 = listOfStrings2.stream().sorted(Comparator.comparing(String::length))
				.collect(Collectors.toList());
		System.out.println(collect16);

		System.out.println("-------------------------------------------------");
//		Given an integer array, find sum and average of all elements?

		int[] a2 = new int[] { 45, 12, 56, 15, 24, 75, 31, 89 };
		int sum3 = Arrays.stream(a2).sum();
		System.out.println("SUM- " + sum3);
		OptionalDouble average2 = Arrays.stream(a2).average();
		System.out.println("Average - " + average2.getAsDouble());
		System.out.println("-------------------------------------------------");
//		How do you find common elements between two arrays?

		List<Integer> list1 = Arrays.asList(71, 21, 34, 89, 56, 28);
		List<Integer> list2 = Arrays.asList(12, 56, 17, 21, 94, 34);
		List<Integer> collect17 = list1.stream().filter(elm -> list2.contains(elm)).collect(Collectors.toList());
		System.out.println("common elms - " + collect17);
		System.out.println("-------------------------------------------------");
//		Reverse each word of a string using Java 8 streams?

		String str = "Java Concept Of The Day";
//		 String collect18 = Arrays.stream(str.split(" ")).map(StringBuilder::new).map(sb->sb.reverse()).collect(Collectors.joining(" "));
		String collect18 = Arrays.stream(str.split(" ")).map(sb -> new StringBuilder(sb).reverse())
				.collect(Collectors.joining(" "));
		System.out.println(collect18);
		System.out.println("-------------------------------------------------");
//		 How do you find sum of first 10 natural numbers?

		// in range here 100 will excluded
		int sum4 = IntStream.range(1, 100).sum();
		System.out.println(sum4);

		// in rangeClosed here 100 will included
		int sum5 = IntStream.rangeClosed(1, 100).sum();
		System.out.println(sum5);
		System.out.println("-------------------------------------------------");
//		 Print first 10 even numbers
		IntStream.rangeClosed(1, 10).map(n -> n * 2).forEach(System.out::println);
		System.out.println("-------------------------------------------------");
//		 How do you find the most repeated element in an array?
		List<String> listOfStrings4 = Arrays.asList("Pen", "Eraser", "Note Book", "Pen", "Pencil", "Pen", "Note Book",
				"Pencil");
		Map<String, Long> collect19 = listOfStrings4.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(collect19);
		Collection<Long> values = collect19.values();
		System.out.println("values-" + values);
		Long long1 = values.stream().max(Comparator.naturalOrder()).get();
		System.out.println("Max Value-- " + long1);
		Entry<String, Long> entry = collect19.entrySet().stream().max(Map.Entry.comparingByValue()).get();
		System.out.println("maximum time repeated word- " + entry.getKey());
		System.out.println("number of occureances " + entry.getValue());
		System.out.println("-------------------------------------------------");

//		Given a list of strings, find out those strings which start with a number?

		List<String> listOfStrings3 = Arrays.asList("One", "2wo", "3hree", "Four", "5ive", "Six");
		listOfStrings3.stream().filter(abc -> Character.isDigit(abc.charAt(0))).forEach(System.out::println);
		System.out.println("-------------------------------------------------");

//		 How do you extract duplicate elements from an array?

		List<Integer> listOfIntegers5 = Arrays.asList(111, 222, 333, 111, 555, 333, 777, 222);
		Set<Integer> uniqueSet = new HashSet<>();
		Set<Integer> suplicates = listOfIntegers5.stream().filter(elm -> !uniqueSet.add(elm))
				.collect(Collectors.toSet());
		System.out.println("duplicate elements from an array - " + suplicates);

		System.out.println("-------------------------------------------------");

//		 Print duplicate characters in a string?

		String inputString7 = "Java Concept Of The Day".replaceAll("\\s+", "").toLowerCase();
		System.out.println(inputString7);
		Set<String> uniqueCharSet = new HashSet<>();
		Set<String> collect20 = Arrays.stream(inputString7.split("")).filter(str1 -> !uniqueCharSet.add(str1))
				.collect(Collectors.toSet());
		System.out.println("Duplicates- " + collect20);

	}
}
