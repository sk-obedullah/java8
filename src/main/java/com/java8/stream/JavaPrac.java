package com.java8.stream;

import java.util.Arrays;
import java.util.stream.Collectors;

public class JavaPrac {

	public static void main(String[] args) {
//		String s="abc";
//		String revStr="";
//		for(int i=0; i<s.length(); i++){
//			revStr=s.charAt(i)+revStr;
//		}
//		System.out.println(revStr);

		String s = "Pradeep";
//		System.out.println(s.length());
//		for (int i = s.length() - 1; i >= 0; i--) {
//			System.out.print(s.charAt(i));
//		}

//		String collect = Arrays.stream(s.split("")).collect(Collectors.);
//		System.out.println(collect);

//		int i=9;
//		int j=09;

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
