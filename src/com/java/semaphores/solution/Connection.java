package com.java.semaphores.solution;

import java.util.concurrent.Semaphore;

public class Connection {
	private static Connection connection = new Connection();
	private int connections = 0;
	private Semaphore semp = new Semaphore(10, true);

	private Connection() {

	}

	public static Connection getInstance() {
		return connection;
	}

	public void connect() {
		try {
			semp.acquire();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		try {
			doConnect();
		} finally {
			semp.release();
		}
	}

	private void doConnect() {

		synchronized (this) {
			connections++;
			System.out.println("Current connections :" + connections);
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		synchronized (this) {
			connections--;
		}

	}

}
