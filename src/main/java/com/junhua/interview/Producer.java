package com.junhua.interview;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

	private BlockingQueue<String> bq;

	public Producer(BlockingQueue<String> bq) {
		this.bq = bq;
	}

	public void setBq(BlockingQueue<String> bq) {
		this.bq = bq;
	}

	@Override
	public void run() {

//		while (true) {
			try {
				Thread.sleep(1000);
				System.out.println("produce juan1");
				bq.put("juan1");
				
				Thread.sleep(1000);
				System.out.println("produce juan2");
				bq.put("juan2");
				
				Thread.sleep(1000);
				System.out.println("produce juan3");
				bq.put("juan3");
				
//				bq.put("juan2");
//				bq.put("juan3");
//				bq.put("juan4");
//				bq.put("juan5");
//				bq.put("juan6");
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
//		}
	}

}
