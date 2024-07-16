package com.java.java_practice;

import java.util.Arrays;
import java.util.stream.Collectors;

public class RemoveWhiteSpaces {

	public static void main(String[] args) {
		String str="i love  java   and react  js";
		String replaceAll = str.replaceAll("\\s+", "_");
		System.out.println(replaceAll);
		
//		using java 8
		
		String collect = Arrays.stream(str.split(" ")).map(String::trim).collect(Collectors.joining());
		System.out.println(collect);
	}
	
}
