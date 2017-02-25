package com.java.semaphores;


public class Connection {
	private static Connection connection = new Connection();
	private int connections = 0;

	private Connection() {

	}

	public static Connection getInstance() {
		return connection;
	}

	public void connect() {

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
