package com.java8.stream;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {

	public static void main(String[] args) {
		
		//collect odds and even numbers
		List<Integer> intListforOddEven = Arrays.asList(1, 2, 4, 6, 8, 1, 6, 4, 5);
		Map<Boolean,List<Integer>> collect4 = intListforOddEven.stream().collect(Collectors.partitioningBy(num->num%2==0));
		System.out.println(collect4);
		 
		//get the repeated words from a para
		List<String> listOfWords = Arrays.asList("", "aa", "bbe", "", "abc", "aa","bbe");
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
		
		//get count min max average for numbers
		
		IntSummaryStatistics summaryStatistics = intList.stream().mapToInt(x->x).summaryStatistics();
		System.out.println(summaryStatistics.getCount()+"___"+summaryStatistics.getAverage());

	}

	private static Object groupingBy() {
		// TODO Auto-generated method stub
		return null;
	}
}

























