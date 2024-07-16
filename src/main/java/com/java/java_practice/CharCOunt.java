package com.java.java_practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CharCOunt {

	public static void main(String[] args) {
		String s = "i love java";
		String[] split = s.split("");
		Map<String, Integer> countMap = new HashMap<>();
		for (String charStr : split) {
			if (!countMap.containsKey(charStr)) {
				countMap.put(charStr, 1);
			} else {
				countMap.put(charStr, countMap.get(charStr) + 1);
			}
		}
		System.out.println(countMap);

		// using java 8

		Map<String, Long> collect = Arrays.stream(s.split(""))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(collect);

	}
}
