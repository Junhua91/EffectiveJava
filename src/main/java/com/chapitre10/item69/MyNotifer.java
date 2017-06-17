package com.chapitre10.item69;

public class MyNotifer implements Runnable {

	private StringBuilder sb;
	
	public MyNotifer(StringBuilder sb) {
		this.sb =sb;
	}
	
	@Override
	public void run() {
		System.out.println("starts to notify...");
		synchronized (sb) {
			sb.notifyAll();			
		}
	}
}
