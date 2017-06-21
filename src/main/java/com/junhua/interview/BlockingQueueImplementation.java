package com.junhua.interview;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueueImplementation<T> {

	private Queue<T> queue = new LinkedList<T>();
	private Condition isFullCondition;
	private Condition isEmptyCondition;
	private int limit;
	private Lock lock;

	public BlockingQueueImplementation(int limit) {
		this.limit = limit;
		lock = new ReentrantLock();
		isFullCondition = lock.newCondition();
		isEmptyCondition = lock.newCondition();
	}

	public void put(T t) {
		lock.lock();
		try {
			while (isFull())
				isFullCondition.await();
			
			queue.add(t);
			isEmptyCondition.signalAll();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
	public T get() {
		T t = null;
		lock.lock();
		try {
			while(isEmpty())
				isEmptyCondition.await();
				
			t=queue.poll();
			isFullCondition.signalAll();			
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				lock.unlock();
			}
		return t;
	}

	public boolean isFull() {
		return queue.size() == limit;
	}

	public boolean isEmpty() {
		return queue.size() == 0;
	}

}

// private Queue<T> q = new LinkedList<T>();
// private int limit;
//
// public BQueue(int limit) {
// this.limit = limit;
// }
//
// public synchronized void put (T t) throws InterruptedException {
// while (isFull()) {
// wait();
// }
// boolean e = isEmpty();
// q.add(t);
// if (e)
// notifyAll();
// }
//
//
// public synchronized T get () throws InterruptedException {
// while (isEmpty()) {
// wait();
// }
// boolean f = isFull();
// T t = q.poll();
// if (f)
// notifyAll();
// return t;
// }
//
// private boolean isEmpty() {
// return q.size() == 0;
// }
// private boolean isFull() {
// return q.size() == limit;
// }