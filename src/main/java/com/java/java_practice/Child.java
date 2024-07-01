package com.java.java_practice;

import java.io.FileNotFoundException;

public class Child extends Parent{

	@Override
	public String m1() throws FileNotFoundException{
		return "Hello from Child";
	}
}
