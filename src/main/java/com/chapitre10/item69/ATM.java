package com.chapitre10.item69;

import java.util.concurrent.Semaphore;

public class ATM implements Runnable{
	
	private String name;
	private Semaphore semaphore;
	
	public ATM(String name, Semaphore semaphore) {
		this.name = name;
		this.semaphore = semaphore;
	}

	@Override
	public void run() {
			try {
				System.out.println(name + " acquiring lock......");
				System.out.println(name + " available permits " +semaphore.availablePermits());
				semaphore.acquire();
				System.out.println(name + " get the permit");
			
				System.out.println(name + " : is performing operation " 
						+ ", available Semaphore permits : "
						+ semaphore.availablePermits());

				// sleep 1 second
				Thread.sleep(1000);
			
			} catch (InterruptedException e) {
				e.printStackTrace();
			}finally {
				System.out.println(name + " : releasing lock...");
				semaphore.release();
				System.out.println(name + " : available Semaphore permits now: "
							+ semaphore.availablePermits());
			}
	}

}
