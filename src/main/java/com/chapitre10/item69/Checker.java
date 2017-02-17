package com.chapitre10.item69;

import java.util.concurrent.CountDownLatch;

public class Checker extends BaseChecker {

	public Checker(CountDownLatch latch, String name) {
		super(latch, name);
	}

	@Override
	public void verifyService() {
		System.out.println("Checking " + this.getName());
		
		try {
			Thread.sleep(2000);
			System.out.println(this.getName() + " is UP");
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
