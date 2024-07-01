package com.java.java_practice;

import java.util.Arrays;

public class MyVector {

	public Object[] elements;
	public int size;
	
	public MyVector(int initialCapacity) {
		this.elements=new Object[initialCapacity];
		this.size=0;
	}
	
	public MyVector() {
		this(10);
	}
	
	public void add(Object element) {
		if(size+1<elements.length) {
			elements[size++]=element;
		}else {
			this.elements=Arrays.copyOf(elements, size*2);
			elements[size++]=element;
		}
	}
	
	public Object get(int index) {
		if(index>=this.size || index<0) {
			throw new ArrayIndexOutOfBoundsException();
		}
		return this.elements[index];
	}
}
