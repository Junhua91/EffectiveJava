package com.junhua.interview;

public class InterrupteTest {

	public static void main(String[] args) {
		Thread thread = new Thread(new MyThread6());
		thread.start();
		
		try {
			Thread.sleep(1000);
			thread.interrupt();
	
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
