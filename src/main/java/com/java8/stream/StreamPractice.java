package com.java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamPractice {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(111);
		list.add(12);
		list.add(13);
		list.add(14);
		list.add(15);
		list.add(162);
		list.add(17);
		list.add(18);
		

		// --Configurations using filter and map--//

//		List<Integer> collect = list.stream().filter(num->(num>=100)).collect(Collectors.toList());
//		System.out.println(collect);

//		long count = list.stream().filter(num->num<100).count();
//		System.out.println(count);

//		List<Integer> collect2 = list.stream().map(num->num+1).collect(Collectors.toList());
//		System.out.println(collect2);

		// --Processing by sorted()method--//

//		List<Integer> collect = list.stream().sorted().collect(Collectors.toList());
//		System.out.println(collect);

//		Comparator<Integer> comp=(i1,i2)->i1.compareTo(i2); Directly we can pass the comparator obj
//		List<Integer> collect2 = list.stream().sorted((a,b)->b.compareTo(a)).collect(Collectors.toList());
//		System.out.println(collect2);

//		Integer integer = list.stream().min((a,b)->a.compareTo(b)).get();
//		System.out.println("min val-:"+integer);

//		Integer integer2 = list.stream().max((a,b)->a.compareTo(b)).get();
//		System.out.println("max val-:"+integer2);
		
		
		String str="abc abc xyz z";
		Map<String,Long> collect = Arrays.stream(str.split("")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		System.out.println(collect);
		
		Map<String,String> collect2 = Arrays.stream(str.split(" ")).collect(Collectors.groupingBy(Function.identity(),Collectors.joining()));
		System.out.println(collect2);
		
		String collect3 = Arrays.stream(str.split("")).sorted().collect(Collectors.joining());
		System.out.println(collect3);
		String collect4 = Arrays.stream(str.split("")).sorted(Comparator.reverseOrder()).collect(Collectors.joining());
		System.out.println(collect4);
		
		String collect5 = Arrays.stream(str.split(" ")).map(str1->new StringBuilder(str1).reverse()).collect(Collectors.joining(" ","( "," )"));
		System.out.println(collect5);
		
		 List<Integer> listOfIntegers5 = Arrays.asList(111, 222, 333, 111, 555, 333, 777, 222);
		 
		 Set<Integer> unique=new HashSet<>();
		 Set<Integer> dup = listOfIntegers5.stream().filter(elm-> !unique.add(elm)).collect(Collectors.toSet());
		 System.out.println(dup);

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
