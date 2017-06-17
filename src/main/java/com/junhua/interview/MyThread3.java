package com.junhua.interview;

public class MyThread3 implements Runnable{
	
	private ThreadLocal<Integer> age;
	
	public MyThread3(ThreadLocal<Integer> age) {
		this.age =age;
	}

	@Override
	public void run() {
		age.set(40);
		System.out.println(age.get());		
	}

}
