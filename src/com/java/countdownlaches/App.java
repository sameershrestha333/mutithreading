package com.java.countdownlaches;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Processor implements Runnable {

	private CountDownLatch latch;

	public Processor(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override
	public void run() {
		System.out.println("Started..");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		latch.countDown();
	}

}

public class App {

	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(3);
		// 3 threads are created.
		ExecutorService exector = Executors.newFixedThreadPool(3);
		for (int i = 0; i < 3; i++) {
			exector.submit(new Processor(latch));
		}

		try {
			// executed when current count reaches to 0.
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Completed..");
	}

}
