package com.chapitre10.item69;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{

	private BlockingQueue<Integer> queue = null;

	public Consumer(BlockingQueue<Integer> queue) {
		this.queue = queue;
	}
	

	public void setBq(BlockingQueue<Integer> bq) {
		this.queue = bq;
	}

	@Override
	public void run() {
		try {
			System.out.println("Consumed: " + queue.take());
			System.out.println("Consumed: " + queue.take());
			System.out.println("Consumed: " + queue.take());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
