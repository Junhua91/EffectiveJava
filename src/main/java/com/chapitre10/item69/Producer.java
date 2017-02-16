package com.chapitre10.item69;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

	private BlockingQueue<Integer> queue = null;

	public Producer(BlockingQueue<Integer> queue) {
		this.queue = queue;
	}
	
	public void setBq(BlockingQueue<Integer> bq) {
		this.queue = bq;
	}
	
	@Override
	public void run() {
		Random rand = new Random();
		int res = 0;
		try {
			res = Addition(rand.nextInt(100), rand.nextInt(50));
			System.out.println("Produced: " + res);
			queue.put(res);
			Thread.sleep(1000);
			res = Addition(rand.nextInt(100), rand.nextInt(50));
			System.out.println("Produced: " + res);
			queue.put(res);
			Thread.sleep(1000);
			res = Addition(rand.nextInt(100), rand.nextInt(50));
			System.out.println("Produced: " + res);
			queue.put(res);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public int Addition(int x, int y) {
		int result = 0;
		result = x + y;
		return result;
	}

}
