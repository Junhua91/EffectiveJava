package com.junhua.interview;

import com.chapitre10.item69.MyNotifer;

public class WaitTest {
	
	public static void main(String[] args) {
		StringBuilder name = new StringBuilder();
		name.append("juan");
		
		new Thread(new MyThread2(name)).start();
		new Thread(new MyThread2(name)).start();
		new Thread(new MyThread2(name)).start();
		new Thread(new MyThread2(name)).start();
		new Thread(new MyThread2(name)).start();
		
		name.append("love");
		
		new Thread(new MyNotifer(name)).start();	
		
	}

}
