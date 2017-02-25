package com.java.threadpools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Processor implements Runnable {
	private int id;

	public Processor(int id) {
		this.id = id;
	}

	@Override
	public void run() {
		System.out.println("Starting : " + id);

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// when processing finished
		System.out.println("Completed: " + id);

	}

}

public class App {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		// 5 tasks
		for (int i = 0; i < 5; i++) {
			executor.submit(new Processor(i));
		}
		executor.shutdown();
		System.out.println("All tasked submitted.");
		try {
			executor.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("All tasked Completed.");

	}

}
