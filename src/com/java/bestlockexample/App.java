package com.java.bestlockexample;

public class App {

	public static void main(String[] args) throws InterruptedException {
		final Runner runner = new Runner();
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					runner.firstMethod();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					runner.scecondMethod();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		t1.start();
		t2.start();
		
		
		t1.join();
		t2.join();
		runner.finished();
	}

}
