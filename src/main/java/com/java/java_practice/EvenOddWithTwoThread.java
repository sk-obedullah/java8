package com.java.java_practice;

import java.util.Iterator;

public class EvenOddWithTwoThread {

	private static final Object LOCK = new Object();
	private static final int LIMIT = 10;

	public static void main(String[] args) {

		Thread oddThread=new Thread(new PrintOdd());
		Thread evenThread=new Thread(new PrintEven());
		oddThread.start();
		evenThread.start();
	}

	static class PrintEven implements Runnable {

		@Override
		public void run() {

			for (int i = 2; i <= LIMIT; i+=2) {
				synchronized (LOCK) {
					try {
						LOCK.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("Even " + i);
					LOCK.notify();
				}
			}

		}

	}

	static class PrintOdd implements Runnable {

		@Override
		public void run() {
			for (int i = 1; i <= LIMIT; i+=2) {
				synchronized (LOCK) {
					System.out.println("Odd " + i);
					LOCK.notify();
					try {
						LOCK.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

			synchronized (LOCK) {
				LOCK.notifyAll();
			}

		}
	}
}
