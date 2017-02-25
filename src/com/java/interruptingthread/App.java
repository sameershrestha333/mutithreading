package com.java.interruptingthread;

import java.util.Random;

public class App {

	public static void main(String[] args) throws InterruptedException {

		System.out.println("Starting...");
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				
				Random random = new Random();
				for (int i = 0; i < 1E8; i++) {
					/*if(Thread.currentThread().isInterrupted()){
						System.out.println("Thread is interrupted...");
						break;
					}*/
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
					
						System.out.println("Interrupted...");
						break;
					}
					
					
					Math.sin(random.nextDouble());
				} // end of for
			}
		});
		t1.start();
		t1.interrupt();
		t1.join();
		System.out.println("Finished..");
	}

}
