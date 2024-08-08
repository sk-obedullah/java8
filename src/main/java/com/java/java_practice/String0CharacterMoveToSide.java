package com.java.java_practice;

import java.lang.reflect.Array;
import java.util.Arrays;

public class String0CharacterMoveToSide {

	public static void main(String[] args) {
		System.out.println(moveChar("0a1p2p3l4e"));
	}

	public static String moveChar(String s) {

		StringBuilder nonDigitString = new StringBuilder();
		StringBuilder digitString = new StringBuilder();

		for (char c : s.toCharArray()) {
			if (!Character.isDigit(c)) {
				nonDigitString.append(c);
			} else {
				digitString.append(c);
			}
		}
		return new String(nonDigitString.append(digitString));
	}

	public static String moveCharInStream(String s) {
		StringBuilder nonDigitString = new StringBuilder();
		StringBuilder digitString = new StringBuilder();
		Arrays.stream(s.split("")).forEach(val -> {
			if (Character.isDigit(0)) {
				digitString.append(val);
			} else {
				nonDigitString.append(val);
			}
		});
		return new String(nonDigitString.append(digitString));
	}

}
