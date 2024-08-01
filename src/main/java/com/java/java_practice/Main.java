package com.java.java_practice;

public class Main {

	public static void main(String[] args) {
		MyGenricClass<Integer> intDataClass=new MyGenricClass<>();
		intDataClass.setContenet(123);
		System.out.println("Data from integerType generic class- "+intDataClass.getContenet());
		
		MyGenricClass<String> StringDataClass=new MyGenricClass<>();
		StringDataClass.setContenet("data");
		System.out.println("Data from integerType generic class- "+StringDataClass.getContenet());
	}
}
