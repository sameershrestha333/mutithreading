package com.java.deadlock;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {
	private Account acc1 = new Account();

	private Account acc2 = new Account();

	private Lock lock1 = new ReentrantLock();
	private Lock lock2 = new ReentrantLock();

	private void acquireLocks(Lock firstLcok, Lock secondLock) throws InterruptedException {
		while (true) {

			// acquire locks

			boolean gotFirstLock = false;
			boolean gotSecondLock = false;
			try {
				gotFirstLock = firstLcok.tryLock();
				gotSecondLock = secondLock.tryLock();
			} finally {
				if (gotFirstLock && gotSecondLock)
					return;

				if (gotFirstLock)
					firstLcok.unlock();

				if (gotSecondLock)
					secondLock.unlock();

			}

			// doesnot acquire locks
			Thread.sleep(1);

		} // end of while
	}

	public void firstThread() throws InterruptedException {
		Random random = new Random();

		for (int i = 0; i < 10000; i++) {
			acquireLocks(lock1, lock2);
			/*
			 * lock1.lock(); lock2.lock();
			 */
			try {
				Account.transfer(acc1, acc2, random.nextInt(100));

			} finally {
				lock1.unlock();
				lock2.unlock();
			}

		}

	}

	public void scecondThread() throws InterruptedException {
		Random random = new Random();

		for (int i = 0; i < 10000; i++) {

			acquireLocks(lock2, lock1);

			try {
				Account.transfer(acc2, acc1, random.nextInt(100));

			} finally {
				lock2.unlock();
				lock1.unlock();
			}

		}
	}

	public void finished() {
		System.out.println("Account 1 balance : " + acc1.getBalance());
		System.out.println("Account 2 balance : " + acc2.getBalance());
		System.out.println("Total balance is :" + (acc1.getBalance() + acc2.getBalance()));
	}

}
