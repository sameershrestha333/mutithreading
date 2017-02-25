package com.java.semaphores.solution;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class App {

	public static void main(String[] args) throws InterruptedException {

		/**
		 * newCachedThreadPool is different from newFixedSizeThread newFixedSize
		 * creates the ThreadPoo and reuse the fixed numbers of thread where
		 * NewCachedThreadPool creates new thread needed and reuse previously
		 * structured thread when they are available.
		 */
		ExecutorService executor = Executors.newCachedThreadPool();

		// creating 200 thread
		for (int i = 0; i < 200; i++) {
			executor.submit(new Runnable() {

				@Override
				public void run() {
					Connection.getInstance().connect();

				}
			});
		} // end of for
		executor.shutdown();
		executor.awaitTermination(1, TimeUnit.DAYS);

	}

}
