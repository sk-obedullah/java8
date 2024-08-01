package com.java8.stream;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import static java.util.stream.Collectors.*;

import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class Streams {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// collect odds and even numbers
		List<Integer> intListforOddEven = Arrays.asList(1, 2, 4, 6, 8, 1, 6, 4, 5);
		Map<Boolean, List<Integer>> collect4 = intListforOddEven.stream()
				.collect(Collectors.partitioningBy(num -> num % 2 == 0));
		System.out.println(collect4);

		// get the repeated words from a para
		List<String> listOfWords = Arrays.asList("", "aa", "bbe", "", "abc", "aa", "bbe");
		List<String> collect5 = listOfWords.stream().map(String::toUpperCase).limit(3).collect(Collectors.toList());
		System.out.println(collect5);

		// CountEmptyString

		List<String> list = Arrays.asList("", "aa", "bbe", "", "abc", " ");
		long count = list.stream().filter(x -> x.isBlank()).count();
		System.out.println(count);

		// count length>2

		long count2 = list.stream().filter(x -> x.length() > 2).count();
		System.out.println(count2);

		// remove Empty strings from list

		List<String> collect = list.stream().filter(x -> !x.isEmpty()).collect(Collectors.toList());
		System.out.println(collect);

		// convert strings to uppercase and join them with comma

		String collect2 = list.stream().filter(x -> !x.isEmpty()).map(x -> x.toUpperCase())
				.collect(Collectors.joining("_"));
		System.out.println(collect2);

		// square of distinct number in a list

		List<Integer> intList = Arrays.asList(1, 2, 4, 6, 8, 1, 6, 4, 5);
		List<Integer> collect3 = intList.stream().map(x -> x * x).distinct().collect(Collectors.toList());
		System.out.println(collect3);

		// get count min max average for numbers

		IntSummaryStatistics summaryStatistics = intList.stream().mapToInt(x -> x).summaryStatistics();
		System.out.println(summaryStatistics.getCount() + "___" + summaryStatistics.getAverage());

		List<Integer> listOfIntegers = Arrays.asList(71, 18, 42, 21, 67, 32, 95, 14, 56, 87);
		Map<Boolean, List<Integer>> collect6 = listOfIntegers.stream()
				.collect(Collectors.partitioningBy(num -> num % 2 == 0));
		System.out.println(collect6);

		List<String> listOfStrings = Arrays.asList("Java", "Python", "C#", "Java", "Kotlin", "Python");
		List<String> collect7 = listOfStrings.stream().distinct().collect(Collectors.toList());
		System.out.println(collect7);

		String inputString = "Java Concept Of The Day";
		Map<String, Long> collect8 = Stream.of(inputString.split(""))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(collect8);

		List<String> stationeryList = Arrays.asList("Pen", "Eraser", "Note Book", "Pen", "Pencil", "Stapler",
				"Note Book", "Pencil");

		Map<String, Long> collect9 = stationeryList.stream()
				.collect(Collectors.groupingBy(Function.identity(), counting()));
		System.out.println(collect9);

		List<Double> decimalList = Arrays.asList(12.45, 23.58, 17.13, 42.89, 33.78, 71.85, 56.98, 21.12);
		List<Double> collect10 = decimalList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		System.out.println(collect10);

		List<Double> collect11 = decimalList.stream().sorted().collect(Collectors.toList());
		System.out.println(collect11);

		DoubleSummaryStatistics collect12 = decimalList.stream()
				.collect(Collectors.summarizingDouble(Double::doubleValue));
		System.out.println(collect12);

		double asDouble = decimalList.stream().mapToDouble(Double::doubleValue).max().getAsDouble();
		double asDouble2 = decimalList.stream().mapToDouble(Double::doubleValue).average().getAsDouble();
		System.out.println(asDouble);
		System.out.println(asDouble2);

//		 121.	Program to find anagrams for the given input(Fired, Fried)

		String s1 = "Firxed";
		String s2 = "Fried";

		String[] split1 = s1.split("");
		String[] split2 = s2.split("");

		System.out.println("is Anagram " + Stream.of(split1).sorted()
				.filter(a -> !Stream.of(split2).sorted().findFirst().get().equalsIgnoreCase(a)).findAny().isPresent());

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private static Object groupingBy() {
		// TODO Auto-generated method stub
		return null;
	}
}
