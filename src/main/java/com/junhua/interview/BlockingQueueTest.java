package com.junhua.interview;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueTest {
	
	public static void main(String[] args) {
		BlockingQueue<String> bq = new ArrayBlockingQueue<>(3);
		
		new Thread(new Producer(bq)).start();
		new Thread(new Consumer(bq)).start();
		new Thread(new Consumer(bq)).start();
		new Thread(new Consumer(bq)).start();
		
	}

}
