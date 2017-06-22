package com.junhua.interview;

public class MyThread4 implements Runnable{
	
	private ThreadLocal<Integer> age;
	
	public MyThread4(ThreadLocal<Integer> age) {
		this.age =age;
	}

	@Override
	public void run() {
		System.out.println(age.get());		
	}


}
