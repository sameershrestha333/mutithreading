package com.java.callableandfuture;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunnableApp {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool();

		executorService.submit(new Runnable() {

			@Override
			public void run() {
				System.out.println("Starting...");
				Random random = new Random();
				int sleepDuration = random.nextInt(4000);
				try {
					Thread.sleep(sleepDuration);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.out.println("Finished..");
			}
		});

		executorService.shutdown();
	}

}
