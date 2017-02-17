package com.chapitre10.item69;

import java.util.concurrent.CountDownLatch;

public abstract class BaseChecker implements Runnable {

	private CountDownLatch latch;
	private String name;
	private boolean serviceUp;

	public BaseChecker(CountDownLatch latch, String name) {
		this.latch = latch;
		this.name = name;
		this.serviceUp = false;
	}
	

	public String getName() {
		return name;
	}


	public boolean isServiceUp() {
		return serviceUp;
	}



	@Override
	public void run() {
		try {
			verifyService();
			serviceUp = true;
		} catch (Throwable t) {
			serviceUp = false;
			t.printStackTrace(System.err);
		} finally {
			if (latch != null)
				latch.countDown();
		}

	}

	public abstract void verifyService();
}
