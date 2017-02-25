package com.java.bestlockexample;

public class Runner {
	private int count = 0;
	private Object lock = new Object();

	private void increment() {

		for (int i = 0; i < 10000; i++) {
			count++;
		}

	}

	public void firstMethod() throws InterruptedException {

		synchronized (lock) {
			increment();
		}
	}

	public void scecondMethod() throws InterruptedException {
		synchronized (lock) {
			increment();
		}
	}

	public void finished() {
		System.out.println("Total Count :" + count);
	}

}
