package com.junhua.interview;

public class MyThread6 implements Runnable{

	@Override
	public void run() {

//		while(!Thread.currentThread().isInterrupted()){
			System.out.println("continue...");
//		}
		System.out.println(Thread.interrupted());
		System.out.println(Thread.currentThread().isInterrupted());
		System.out.println("interuppted");
	}
}
