package com.java8.stream;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class StreamPreparation {

	public static void main(String[] args) {

		// find out even numbers from a list

//		List.of(1, 2, 3, 4, 5, 6, 7, 8, 9).stream().filter(num -> num % 2 == 0).forEach(System.out::println);

//		Double collect = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9).stream()
//				.collect(Collectors.averagingInt(Integer::intValue));
//		System.out.println(collect);
//
//		OptionalDouble average = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9).stream().mapToInt(Integer::intValue).average();
//		System.out.println(average.getAsDouble());
		
		
		
		HashSet<Integer> hsh = new HashSet<>();
//		List.of(1, 1, 2, 3, 4, 5, 6, 7, 8, 8, 9).forEach(elm -> {
//			if (!hsh.add(elm)) {
//				System.out.println(elm);
//			}
//		});
		
//		List<Integer> of = List.of(1, 1, 2, 3, 4, 5, 6, 7, 8, 8, 9);
//		
//		for(Integer i:of) {
//			if (!hsh.add(i)) {
//				System.out.println(i);
//			}
//		}
		List.of(1, 1, 2, 3, 4, 5, 6, 7, 8, 8, 9).stream().filter(elm->!hsh.add(elm)).forEach(System.out::println);

	}
}
