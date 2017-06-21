package com.junhua.interview;

public class SingletonTest {
	
	private  static SingletonTest instance;
	
	private SingletonTest() {
	}

	/**
	 * double check
	 * @return
	 */
	public static  SingletonTest getInstance(){
		if(instance==null)
		{
			synchronized(SingletonTest.class){
				if(instance==null)
				instance = new SingletonTest();
			}
		}
		return instance;
	}
	
	public static void main(String[] args) {
		for(int i=0;i<100;i++)
			System.out.println(EnumSingleton.Instance.getInstance());
	}
}
