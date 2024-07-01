package com.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*Given a list of integers, separate odd and even numbers?*/

public class Q1 {

	public static void main(String[] args) {
		 List<Integer> listOfIntegers = Arrays.asList(71, 18, 42, 21, 67, 32, 95, 14, 56, 87);
		 Map<Boolean,List<Integer>> collect = listOfIntegers.stream().collect(Collectors.partitioningBy(val->val%2==0));
		 System.out.println(collect);
	}
}
