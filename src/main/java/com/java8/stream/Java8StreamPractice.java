package com.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Java8StreamPractice {

	public static void main(String[] args) {

//		Given a list of integers, find out all the even numbers that exist in the list using Stream functions?

		List<Integer> list = Arrays.asList(10, 15, 8, 49, 25, 98, 32);
		list.stream().filter(elm->elm%2==0).forEach(System.out::println);
		
//		Given a list of integers, find out all the numbers starting with 1 using Stream functions?
		
		 List<Integer> myList = Arrays.asList(10,15,8,49,25,98,32);
		 List<String> collect = myList.stream().map(i->Integer.toString(i)).filter(j->j.startsWith("1")).collect(Collectors.toList());
		 System.out.println(collect);

	}
}
