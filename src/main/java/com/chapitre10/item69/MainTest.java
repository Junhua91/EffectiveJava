package com.chapitre10.item69;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MainTest {

	private static final ConcurrentMap<String, String> map = new ConcurrentHashMap<String, String>();
	public final static int THREAD_POOL_SIZE = 5;

	public static void main(String[] args) {
		test2();
	}

	static void test1() {

		map.put("1", "one");
		map.put("2", "two");
		map.put("3", "three");
		map.put("4", "four");
		map.put("5", "five");
		map.put("6", "six");

		long a = System.currentTimeMillis();
		for (int i = 0; i < 100000000; i++) {
			intern2("7");
		}
		long b = System.currentTimeMillis();

		System.out.println(b - a);

	}

	//
	static void test2() {
		Map<String, Integer> hashTable = new Hashtable<>();
		Map<String, Integer> synchronizedHashMap = Collections.synchronizedMap(new HashMap<>());
		Map<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();
		
		try {
			performTest(hashTable);
			performTest(synchronizedHashMap);
			performTest(concurrentHashMap);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static String intern(String s) {
		String previousValue = map.putIfAbsent(s, s);
		return previousValue == null ? s : previousValue;
	}

	public static String intern2(String s) {
		String result = map.get(s);
		if (result == null) {
			result = map.putIfAbsent(s, s);
			if (result == null)
				result = s;
		}
		return result;
	}

	public static void performTest(final Map<String, Integer> crunchifyThreads) throws InterruptedException {

		System.out.println("Test started for: " + crunchifyThreads.getClass());
		long averageTime = 0;
		for (int i = 0; i < 5; i++) {

			long startTime = System.nanoTime();
			ExecutorService crunchifyExServer = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

			for (int j = 0; j < THREAD_POOL_SIZE; j++) {
				crunchifyExServer.execute(new Runnable() {
					@SuppressWarnings("unused")
					@Override
					public void run() {

						for (int i = 0; i < 500000; i++) {
							Integer crunchifyRandomNumber = (int) Math.ceil(Math.random() * 550000);

							// Retrieve value. We are not using it anywhere
							Integer crunchifyValue = crunchifyThreads.get(String.valueOf(crunchifyRandomNumber));

							// Put value
							crunchifyThreads.put(String.valueOf(crunchifyRandomNumber), crunchifyRandomNumber);
						}
					}
				});
			}

			// Make sure executor stops
			crunchifyExServer.shutdown();

			// Blocks until all tasks have completed execution after a shutdown
			// request
			crunchifyExServer.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);

			long entTime = System.nanoTime();
			long totalTime = (entTime - startTime) / 1000000L;
			averageTime += totalTime;
			System.out.println("2500K entried added/retrieved in " + totalTime + " ms");
		}
		System.out.println("For " + crunchifyThreads.getClass() + " the average time is " + averageTime / 5 + " ms\n");
	}
}
