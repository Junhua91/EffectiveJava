package com.junhua.interview;

public class MyThread7 implements Runnable{

	@Override
	public void run() {
		System.out.println(EnumSingleton.Instance);
	}

}
