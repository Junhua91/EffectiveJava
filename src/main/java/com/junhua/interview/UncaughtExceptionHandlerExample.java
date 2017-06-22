package com.junhua.interview;

public class UncaughtExceptionHandlerExample {

	public static void main(String[] args) {
		Thread myThread = new Thread(new ThreadTest());
		myThread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler(){

			@Override
			public void uncaughtException(Thread t, Throwable e) {
				System.out.println(myThread.getName() + " throws exception " + e);
				
				myThread.start();
			}
		});
		
//		Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
//			
//			@Override
//			public void uncaughtException(Thread t, Throwable e) {
//				System.out.println(" throws exception " + e);
//				
//				new Thread(new ThreadTest()).start();
//				
//			}
//		});
		myThread.start();
	}
	
}
