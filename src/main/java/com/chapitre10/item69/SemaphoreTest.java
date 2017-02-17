package com.chapitre10.item69;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Restrict the number of threads that can access a resource. 
 * Example, limit max 10 connections to access a file simultaneously.
 *
 */


public class SemaphoreTest {

	public static void main(String[] args) {

//		semaphore4();
		mutex();
	}
	
	
	
	static void semaphore4(){
		Semaphore semaphore = new Semaphore(4);
		ExecutorService  executor = Executors.newFixedThreadPool(6);
		
		executor.submit(new ATM("A", semaphore));
		executor.submit(new ATM("B", semaphore));
		executor.submit(new ATM("C", semaphore));
		executor.submit(new ATM("D", semaphore));
		executor.submit(new ATM("E", semaphore));
		executor.submit(new ATM("F", semaphore));
		
		executor.shutdown();
	}
	
	static void mutex(){
		Semaphore semaphore = new Semaphore(1);
		ExecutorService  executor = Executors.newFixedThreadPool(6);
		
		executor.submit(new ATM("A", semaphore));
		executor.submit(new ATM("B", semaphore));
		executor.submit(new ATM("C", semaphore));
		executor.submit(new ATM("D", semaphore));
		executor.submit(new ATM("E", semaphore));
		executor.submit(new ATM("F", semaphore));
		
		executor.shutdown();
	}
}
