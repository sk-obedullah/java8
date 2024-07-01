package com.java.java_practice;

public class ImmutibleClass {

	private static ImmutibleClass instance;

	private ImmutibleClass() {
		System.out.println("constructor called");
	}

	public static ImmutibleClass getInstance() {
		if (instance == null) {
			instance=new ImmutibleClass();
			return instance;
		}
		return instance;
	}
}
