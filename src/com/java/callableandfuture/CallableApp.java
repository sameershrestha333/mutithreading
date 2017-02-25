package com.java.callableandfuture;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableApp {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool();

		Future<Integer> future = executorService.submit(new Callable<Integer>() {

			@Override
			public Integer call() throws Exception {
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
				return sleepDuration;
			}
		});

		executorService.shutdown();
		try {
			System.out.println("Sleep Duration is : " + future.get()+" miliseconds.");
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
