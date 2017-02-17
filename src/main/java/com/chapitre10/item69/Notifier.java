package com.chapitre10.item69;

public class Notifier implements Runnable {

	private Message msg;
	
	public Notifier(Message msg) {
		this.msg = msg;
	}
	
	@Override
	public void run() {
		
		String name=  Thread.currentThread().getName();
		System.out.println(name + "notify starts");
		try {
			Thread.sleep(2000);
			msg.setMsg(name + " Notify work done" );

			synchronized (msg) {
//				msg.notify();
			msg.notifyAll();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
