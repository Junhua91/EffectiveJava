package com.chapitre10.item69;


public class WaitNotifyTest {
	
	public static void main(String[] args) {
		
		Message msg = new Message("process it");
		
		new Thread(new Waiter(msg),"A").start();
		new Thread(new Waiter(msg),"B").start();
		new Thread(new Waiter(msg),"C").start();
		new Thread(new Waiter(msg),"D").start();
		
		new Thread(new Notifier(msg),"Notify").start();
		
		System.out.println("finish");
		
		
	}
}
