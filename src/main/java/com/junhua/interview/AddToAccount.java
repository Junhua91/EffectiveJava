package com.junhua.interview;

public class AddToAccount implements Runnable{

	private Account account;
	private int money;
	
	public AddToAccount(Account account, int money) {
		this.account = account;
		this.money = money;
	}
	
	@Override
	public void run() {
		synchronized (account) {
			account.setBalance(account.getBalance()+money); 
		}
	}

}
