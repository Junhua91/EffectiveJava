package com.junhua.interview;

public class LocalThreadTest {

	public static void main(String[] args) {
		ThreadLocal<Integer>age = new ThreadLocal<Integer>(){
			@Override
			protected Integer initialValue() {
				return 20;
			}
		};
		
		new Thread(new MyThread3(age)).start();
		new Thread(new MyThread4(age)).start();
		
	}
}
