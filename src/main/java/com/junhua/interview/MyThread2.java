package com.junhua.interview;

public class MyThread2 implements Runnable {
	
	private StringBuilder name;
	
	public MyThread2(StringBuilder name) {
		this.name = name;
	}
	
	public void setName(StringBuilder name) {
		this.name = name;
	}

	@Override
	public void run() {
		
		synchronized (name) {
			try {
				System.out.println(Thread.currentThread().getName() +  " is waiting...");
				name.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() +  " get notified...");
			System.out.println(Thread.currentThread().getName() +  " the name is " + name.toString());
		}
		
	}

	
}
