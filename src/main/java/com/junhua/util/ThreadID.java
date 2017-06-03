package com.junhua.util;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 
 * @author jdeng
 *	When we have a requirement to associate state with a thread 
 *	(e.g., a user ID or Transaction ID). the unique 
 */

public class ThreadID {

	private static final AtomicInteger nextID = new AtomicInteger(0);
//
//	private static final ThreadLocal<Integer> threadID = ThreadLocal.<Integer>withInitial(()->{
//		return nextID.getAndIncrement();
//	});
//	
//	static int get(){
//		return threadID.get();
//	}
	
	static int get(){
		return nextID.getAndIncrement();
	}
}
