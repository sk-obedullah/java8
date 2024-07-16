package com.java.java_practice;

import java.util.Arrays;
import java.util.List;

public class EqualityOfTwoArrays {

	public static void main(String[] args) {
		int[] arrayOne = { 2, 5, 1, 7, 4 };
		int[] arrayTwo = { 2, 5, 1, 7, 4 };

		boolean equalFlag = true;

		for (int i = 0; i < arrayOne.length; i++) {
			if (arrayOne.length == arrayTwo.length) {
				if (arrayOne[i] != arrayTwo[i]) {
					equalFlag = false;
				}
			} else {
				equalFlag = false;
			}
		}
		System.out.println("both arrays are equea:: " + equalFlag);

		// using arrays equals method

		boolean equals = Arrays.equals(arrayOne, arrayTwo);
		System.out.println("both arrays are equea:: " + equals);

//		 same number of elements and same set of elements but in different positions
		Arrays.sort(arrayOne);
		Arrays.sort(arrayTwo);

		boolean sortAndEquals = Arrays.equals(arrayOne, arrayTwo);
		System.out.println("both arrays are equea:: " + sortAndEquals);

	}

}
