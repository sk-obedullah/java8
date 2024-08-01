package com.java.java_practice;

class Singleton {

	private static Singleton instance;

	private Singleton() {
		System.out.println("creating instance of singleton class");
	}

	public static Singleton getInstance() {
		if (instance == null) {
			instance = new Singleton();
		}
		return instance;
	}
}

//Bill Pugh Singleton Design pattern---Best Practices

class BestSingleton {
	private BestSingleton() {
		// Prevent instantiation through reflection
		if (BestSingletonHelper.INSTANCE != null) {
			throw new IllegalStateException("Instance Already Created");
		}
		System.out.println("creating instance of BestSingleton class");
	}

	public static BestSingleton getInstance() {
		return BestSingletonHelper.INSTANCE;
	}

	// Static inner class - Inner classes are not loaded until they are referenced
	private static class BestSingletonHelper {
		private static final BestSingleton INSTANCE = new BestSingleton();
	}
}

public class SingletonClass {
	public static void main(String[] args) {
		Singleton.getInstance();
		Singleton.getInstance();
		BestSingleton.getInstance();
		BestSingleton.getInstance();
	}
}
