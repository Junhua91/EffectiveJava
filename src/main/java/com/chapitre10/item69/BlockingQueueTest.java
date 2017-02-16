package com.chapitre10.item69;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueTest {

	
	public static void main(String[] args) {
		
		BlockingQueue<Integer> bq = new ArrayBlockingQueue<>(1000);
		Consumer consumer = new Consumer(bq);
		Producer producer = new Producer(bq);
		
		new Thread(producer).start();
		new Thread(consumer).start();
	
	}
}
