package com.chapitre10.item68;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


/**
 * 
 * Executors are capable of running asynchronous tasks and typically manage a pool of threads,
 * so we don't have to create new threads manually.
 * @author jdeng
 *
 */
public class Main {
	
	
	public static void main(String[] args) throws Throwable, ExecutionException {
		
		ExecutorService executorService = Executors.newSingleThreadExecutor();

		Set<Callable<String>> callables = new HashSet<Callable<String>>();

		callables.add(new Callable<String>() {
		    public String call() throws Exception {
		        return "Task 1";
		    }
		});
		callables.add(new Callable<String>() {
		    public String call() throws Exception {
		        return "Task 2";
		    }
		});
		callables.add(new Callable<String>() {
		    public String call() throws Exception {
		        return "Task 3";
		    }
		});

		List<Future<String>> result = executorService.invokeAll(callables);

		System.out.println("result = " + result);

		executorService.shutdown();

	}
}
