package com.java.producerconsumer;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class App {

	private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

	// puting the data
	public static void producter() throws InterruptedException {
		Random random = new Random();

		while (true) {

			queue.put(random.nextInt(100));
		} // end of while

	}

	// puting the data
	public static void consumer() throws InterruptedException {
		Random random = new Random();

		while (true) {
			Thread.sleep(100);
			if (random.nextInt(10) == 0) {
				Integer value = queue.take();
				System.out.println("Taken value : " + value + " Queue size " + queue.size());
			}

			queue.take();
		} // end of while

	}

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					producter();
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
					consumer();
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
	}

}
