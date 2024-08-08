package com.java.java_practice;

import java.util.Arrays;

public class LongestCommonPrefixInStrings {
	public static void main(String[] args) {
		String[] input = { "geeksforgeeks", "geeks", "geek", "geekzer" };
		String longestCommonPrefixInStrings = longestCommonPrefixInStrings(input);
		System.out.println(longestCommonPrefixInStrings);
	}

	public static String longestCommonPrefixInStrings(String[] arr) {
		if (arr.length == 0) {
			return "";
		}
		if (arr.length == 1) {
			return arr[0];
		}

		Arrays.sort(arr);
		System.out.println("After Sorting the array " + Arrays.toString(arr));

		int preIdx = 0;

		while (preIdx < arr.length && arr[0].charAt(preIdx) == arr[arr.length - 1].charAt(preIdx)) {
			preIdx++;
		}
		return arr[0].substring(0, preIdx);
	}

}
