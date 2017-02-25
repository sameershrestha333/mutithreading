package com.java.startingthread;

class RunnerA implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println("Hello " + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} // end of for loop

	}

}

public class AppByImplementingRunnableInterface {
	public static void main(String[] args) {
		Thread t1 = new Thread(new RunnerA());
		Thread t2 = new Thread(new RunnerA());
		t1.start();
		t2.start();
	}

}
