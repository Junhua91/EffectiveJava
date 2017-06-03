package com.junhua.util;

public class ThreadLocalTest {

	
	
	public static class MyClass implements Runnable{

		@Override
		public void run() {
			System.out.println("Thread " + Thread.currentThread().getName() + " Value - " +  ThreadID.get());
		}
	}


	public static void main(String[] args) {
        MyClass mc1 = new MyClass();
        for(int i=0;i<1000;i++){
        	new Thread(mc1, "Thread-"+i).start();
        }
//        Thread thread1 = new Thread(mc1, "Thread-1");
//        Thread thread2 = new Thread(mc1, "Thread-2");
//        Thread thread3 = new Thread(mc1, "Thread-3");
//        thread1.start();
//        thread2.start();
//        thread3.start();
	}
}
