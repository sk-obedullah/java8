package com.java8.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class JavaPractice {

	public static void main(String[] args) {
		ChotaEmp emp1 = new ChotaEmp("ashish", 100);
		ChotaEmp emp2 = new ChotaEmp("nilesh", 600);
		ChotaEmp emp3 = new ChotaEmp("obedullah", 80);
		ChotaEmp emp4 = new ChotaEmp("pradip", 300);

		List.of(emp1, emp2, emp3, emp4).stream()
				.sorted(Comparator.comparing(ChotaEmp::getSalary, Comparator.reverseOrder()))
				.forEach(System.out::println);

//		method
//		heap
//		stack
//		native
//		pc register
		
		String str1 = "Listen";
		String str2 = "Silent";
 
		if (areAnagrams(str1, str2)) {
			System.out.println(str1 + " and " + str2 + " are anagrams.");
		} else {
			System.out.println(str1 + " and " + str2 + " are not anagrams.");
		}
		
		Runnable e=()->System.out.println("abc");

	}

	public static boolean areAnagrams(String str1, String str2) {
		// Remove non-alphabetic characters and convert to lowercase
		String cleanStr1 = str1.replaceAll("[^a-zA-Z]", "").toLowerCase();
		String cleanStr2 = str2.replaceAll("[^a-zA-Z]", "").toLowerCase();

		String collect1 = Arrays.asList(cleanStr1.split("")).stream().sorted().collect(Collectors.joining());
		String collect2 = Arrays.asList(cleanStr2.split("")).stream().sorted().collect(Collectors.joining());
		
		return collect1.equalsIgnoreCase(collect2);
	
	}
}
