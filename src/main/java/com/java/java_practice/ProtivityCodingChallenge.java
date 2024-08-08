package com.java.java_practice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class ProtivityCodingChallenge {

	static int value;

	public static void main(String[] args) {
		
		//print 1 to 100 without using any numeric value
		
//		char c='A';
//		int max=c;
//		System.out.println(max);
//		while (value < max) {
//			value++;
//			System.out.print(value);
//		}\\
		
		
		//find out distinct elements from above array

		Object[] nestedArray = { 1, 2, new int[] { 3, 5, 6 }, 4, 6, 7, new int[] { 3, 4, 8, 6 }, 2, 0, 9,new int[] { 6, 7 } };
		Set<Integer> resultSet = new HashSet<>();

		for (Object element : nestedArray) {
			if (element instanceof Integer) {
				resultSet.add((Integer) element);
			} else if (element instanceof int[]) {
				Arrays.stream((int[]) element).forEach(resultSet::add);
			}
		}

		Integer[] resultArray = resultSet.toArray(new Integer[0]);
		System.out.println(Arrays.toString(resultArray));
		
		//Write a program to find the largest number in an array in Java.
		
		int[] nums = {1, 5, 3, 9, 7};
		int findMaxElmInArray = findMaxElmInArray(nums);
		System.out.println(findMaxElmInArray);

		//using java 8
		int asInt = Arrays.stream(nums).max().getAsInt();
		System.out.println(asInt);
		
		//find factorial for a number
		System.out.println(findFactorial(1));
//		using java 8
		
		int num=5;
		 
		int factorial = IntStream.rangeClosed(1, num).reduce(1,(a,b)->a*b);
		System.out.println(factorial);
		
		//Write a program to remove duplicate elements from an array in Java.
		int[] numsArray = {1,3, 5, 3, 9, 7};
		Arrays.stream(findDuplicateElmInArray(numsArray)).forEach(System.out::println);
		
		int findSecondLargestIntInArray = findSecondLargestIntInArray(numsArray);
		System.out.println(findSecondLargestIntInArray);
	}
	
	
	
	public static int findMaxElmInArray(int[] nums) {
		int max=nums[0];
		for(int i:nums) {
			if(i>max) {
				max=i;
			}
		}
		return max;
	}
	
	public static int findFactorial(int num) {
		int factorial=1;
		 for(int i=1;i<=num;i++) {
			 factorial*=i;
		 }
		 return factorial;
	}
	
	public static Integer[] findDuplicateElmInArray(int[] arr) {
		Set<Integer> unique=new HashSet<>();
		Set<Integer> duplicates=new HashSet<>();
		for(int i:arr) {
			if(!unique.add(i)) {
				duplicates.add(i);
			}
		}
		 return duplicates.toArray(new Integer[unique.size()]);
	}
	
	
	
	//Write a program to find the second largest number in an array in Java.
	
	public static int findSecondLargestIntInArray(int[] arr) {
		int max=arr[0];
		int secondMax=arr[1];
		
		for(int i:arr) {
			if(i>max) {
				secondMax=max;
				max=i;
			}else if(i>secondMax && i != max) {
				secondMax=i;
			}
		}
		return secondMax;
	}
	
	
	
	
	
}
