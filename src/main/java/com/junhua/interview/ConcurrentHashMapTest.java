package com.junhua.interview;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentHashMapTest {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		Executor executor = Executors.newFixedThreadPool(3);
		
		executorService.submit(new MyThread5());
		executorService.submit(new MyThread5());
		executorService.submit(new MyThread5());
		executorService.submit(new MyThread5());
		executorService.submit(new MyThread5());
	}
}
