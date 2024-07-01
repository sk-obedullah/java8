package com.java.java_practice.multiThreading;

public class MultiThreading extends Thread{

	@Override
	public void run() {
		System.out.println("OOOOOOO");
		 
	}

	public static void main(String[] args) {
		 Thread d=new MultiThreading();
		 d.start();
	}
}
