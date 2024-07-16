package com.java8.stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JavaPractice {

	public static void main(String[] args) {
		ChotaEmp emp1 = new ChotaEmp("ashish", 100, "IT");
		ChotaEmp emp2 = new ChotaEmp("nilesh", 600, "IT");
		ChotaEmp emp3 = new ChotaEmp("obedullah", 80, "ITI");
		ChotaEmp emp4 = new ChotaEmp("pradip", 300, "IIT");

//		List.of(emp1, emp2, emp3, emp4).stream()
//				.sorted(Comparator.comparing(ChotaEmp::getSalary, Comparator.reverseOrder()))
//				.forEach(System.out::println);
		List<ChotaEmp> listOfChotaEmp = List.of(emp1, emp2, emp3, emp4);

		Map<Integer, Long> collect = List.of(emp1, emp2, emp3, emp4).stream()
				.collect(Collectors.groupingBy(ChotaEmp::getSalary, Collectors.counting()));

		System.out.println(collect);

//		Collections.sort(listOfChotaEmp, Comparator.comparing(e -> e.getSalary()));

		// Creating chotaEmployee comparators using annonimous class

//		Comparator<ChotaEmp> salaryComparator=new Comparator<>() { 
//			@Override
//			public int compare(ChotaEmp o1, ChotaEmp o2) {
//				// TODO Auto-generated method stub
//				return 0;
//			}
//		};
//		Comparator<ChotaEmp> nameComparator=new Comparator<>() { 
//			@Override
//			public int compare(ChotaEmp o1, ChotaEmp o2) {
//				// TODO Auto-generated method stub
//				return 0;
//			}
//		};

		// Collections.sort(listOfChotaEmp, salaryComparator);

		Comparator<ChotaEmp> salaryComparator = (e1, e2) -> e1.getSalary() - e2.getSalary();
		Comparator<ChotaEmp> nameComparator = (e1, e2) -> e1.getName().compareToIgnoreCase(e1.getName());
//				Collections.sort(listOfChotaEmp, salaryComparator);
//		Collections.sort(listOfChotaEmp, nameComparator);

//		method
//		heap
//		stack
//		native
//		pc register

		// group employee based on department
		Map<String, List<ChotaEmp>> collect2 = Arrays.asList(emp1, emp2, emp3, emp4).stream()
				.collect(Collectors.groupingBy(ChotaEmp::getDepartrment));

		System.out.println(collect2);

		// salry given in each department
		Map<String, Integer> collect3 = Arrays.asList(emp1, emp2, emp3, emp4).stream()
				.collect(Collectors.groupingBy(ChotaEmp::getDepartrment, Collectors.summingInt(ChotaEmp::getSalary)));

		System.out.println(collect3);

		Map<String, IntSummaryStatistics> collect4 = Arrays.asList(emp1, emp2, emp3, emp4).stream().collect(
				Collectors.groupingBy(ChotaEmp::getDepartrment, Collectors.summarizingInt(ChotaEmp::getSalary)));

		System.out.println(collect4);

		IntSummaryStatistics collect5 = Arrays.asList(emp1, emp2, emp3, emp4).stream()
				.collect(Collectors.summarizingInt(ChotaEmp::getSalary));

		System.out.println(collect5);

		String str1 = "Listen";
		String str2 = "Silent";

		if (areAnagrams(str1, str2)) {
			System.out.println(str1 + " and " + str2 + " are anagrams.");
		} else {
			System.out.println(str1 + " and " + str2 + " are not anagrams.");
		}

		Runnable e = () -> System.out.println("abc");

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
