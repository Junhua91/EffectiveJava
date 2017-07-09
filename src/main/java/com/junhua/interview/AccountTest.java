package com.junhua.interview;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AccountTest {

	public static void main(String[] args) {
		
		Account account = new Account(0);
		ExecutorService executor =Executors.newFixedThreadPool(1000);
		for(int i=0;i<1000;i++){
			executor.submit(new AddToAccount(account, 1));
		}
		
		System.out.println(account.getBalance());
		executor.shutdown();
		
	}
}
