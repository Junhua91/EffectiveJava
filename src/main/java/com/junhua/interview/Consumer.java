package com.junhua.interview;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{
	
	private BlockingQueue<String> bq;
	
	public Consumer(BlockingQueue<String> bq) {
		this.bq = bq;
	}
	
	public void setBq(BlockingQueue<String> bq) {
		this.bq = bq;
	}

	@Override
	public void run() {

//		while(true){
			try {
				System.out.println("consumer:" + bq.take());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
//		}
	}

}
