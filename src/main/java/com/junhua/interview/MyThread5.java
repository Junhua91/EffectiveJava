package com.junhua.interview;

import java.util.concurrent.Callable;

public class MyThread5 implements Callable<Integer>{

	private Integer info;
	
	@Override
	public Integer call() throws Exception {
		info =  new Integer(22);
		return info;
	}

}
