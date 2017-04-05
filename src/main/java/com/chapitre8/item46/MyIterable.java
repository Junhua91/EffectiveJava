package com.chapitre8.item46;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class MyIterable<T> implements Iterable<T>{

	private List<T> list;
	
	
	public MyIterable(T[] t) {
		list = Arrays.asList(t);
		Collections.reverse(list);	
		}
	
	@Override
	public Iterator<T> iterator() {
		return list.iterator();
	}

}
