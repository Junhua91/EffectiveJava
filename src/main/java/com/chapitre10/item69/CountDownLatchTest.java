package com.chapitre10.item69;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//Main thread start
//Create CountDownLatch for N threads
//Create and start N threads
//Main thread wait on latch
//N threads completes there tasks are returns
//Main thread resume execution

public class CountDownLatchTest {
	
	public static void main(String[] args) {
		test1();
	}

	
	static void test1(){
		CountDownLatch latch = new CountDownLatch(3);
		
		ExecutorService executor = Executors.newFixedThreadPool(3);
		executor.submit(new Checker(latch, "Network"));
		executor.submit(new Checker(latch, "Cache"));
		executor.submit(new Checker(latch, "DataBase"));
		
		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("executing main thread");
	}
}
