package com.junhua.interview;

public class ThreadTest implements Runnable{

	@Override
	public void run() {
		throw new RuntimeException();
	}
	
}
