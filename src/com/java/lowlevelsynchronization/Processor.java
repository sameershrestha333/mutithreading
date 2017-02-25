package com.java.lowlevelsynchronization;

import java.util.LinkedList;
import java.util.Random;

public class Processor {

	private LinkedList<Integer> list = new LinkedList<>();
	private final int LIMIT = 10;
	private Object lock = new Object();

	public void produce() throws InterruptedException {

		int value = 0;
		while (true) {
			synchronized (lock) {
				while (list.size() == LIMIT) {
					lock.wait();
				}
				list.add(value++);
				lock.notify();
			}
		} // end of while
	}

	public void consume() throws InterruptedException {
			Random random=new Random();
		while (true) {
			synchronized (lock) {
				while (list.size()==0) {
					lock.wait();
				}
				System.out.print("Size of List :" + list.size());

				int value = list.removeFirst();
				System.out.println
				("; Removed value :" + value);
				lock.notify();
			}
				Thread.sleep(random.nextInt(1000));
		} // end of while
	}
}
