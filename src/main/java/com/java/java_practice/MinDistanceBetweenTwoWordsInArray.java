package com.java.java_practice;

public class MinDistanceBetweenTwoWordsInArray {

	public static int minDistanceBetweenTwoWordsInArray(String[] arr, String w1, String w2) {
		int idxOfWord1 = 0;
		int idxOfWord2 = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == w1) {
				idxOfWord1 = i;
				System.out.println("first word found at idx- " + i);
			}
			if (arr[i] == w2) {
				idxOfWord2 = i;
				System.out.println("last word found at idx- " + i);
			}
		}
		return idxOfWord1 - idxOfWord2;
	}

	public static void main(String[] args) {
		String[] s = { "the", "quick", "brown", "fox", "quick" };
		String word1 = "the";
		String word2 = "fox";
		minDistanceBetweenTwoWordsInArray(s, word1, word2);
	}
}
