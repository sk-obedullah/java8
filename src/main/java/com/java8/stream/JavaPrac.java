package com.java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JavaPrac {

	public static void main(String[] args) {
//		String s="abc"+'c';
//		System.out.println(s);
//		char charAt = s.charAt(1);
//		String revStr="";
//		for(int i=0; i<s.length(); i++){
//			revStr=s.charAt(i)+revStr;
//		}
//		System.out.println(revStr);

//		String s = "Pradeep";
//		System.out.println(s.length());
//		for (int i = s.length() - 1; i >= 0; i--) {
//			System.out.print(s.charAt(i));
//		}

//		String collect = Arrays.stream(s.split("")).collect(Collectors.);
//		System.out.println(collect);
//
//		int i=9;
//		int j=09;
		
		Map<int, String> s=new HashMap<>();
		
		
		String inputString = "Java Concept Of The Day";
		List<String> asList = Arrays.asList(inputString.split(""));
		List<String> unique=new ArrayList<>();
		for(String str:asList) {
			
			if(!unique.contains(str)) {
				unique.add(str);
			};
			
		}
		
		System.out.println(unique);

	}

	private static void findPairs(int[] arr, int x) {
		int i = 0;
		int j = 1;
		while (j < arr.length) {
			int temp = arr[i] + arr[j];
			if (temp == x) {
				System.out.println(arr[i] + "-" + arr[j]);
			}
			j++;
			if (j == arr.length) {
				j = i + 1;
				i++;
			}
			
		}
	}
}
