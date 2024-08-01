package com.java.java_practice;

import java.util.stream.IntStream;

public class ReverseANumber {
	public static void main(String[] args) {


		System.out.println(reverseNumber1(12345));
		
	}
	
	public static int reverseNumber1(int number) {
		int reverseNumber=0;
		while(number>0) {
			reverseNumber=reverseNumber*10+number%10;
			number=number/10;
		}
		return reverseNumber;
	}
	
	
	public static int reverseNumber2(int number) {
		String numberString = String.valueOf(number);
		IntStream.range(0, numberString.length()).map(i->numberString.charAt(i)).collect(null, null, null)
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
