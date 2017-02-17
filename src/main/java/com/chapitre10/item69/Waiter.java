package com.chapitre10.item69;

public class Waiter implements Runnable{
	
	private Message msg;
	
	public Waiter(Message msg) {
		this.msg = msg;
		
	}
	
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " is waiting .... current time is  " + System.currentTimeMillis());
		synchronized (msg) {
			try {
				msg.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println(Thread.currentThread().getName() + " get notified at " + System.currentTimeMillis());
		
		// do something about the msg
		System.out.println("do something in msg");
	}

}
