package com.junhua.interview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GenericTest<K, V> {

	public static void main(String[] args) {
		
		//we can assigne List<T> to raw type(set)
		List list = new ArrayList<String>();
		list = new LinkedList<Integer>();

		
		// can't assigne listOfInteger to listOfObject
		// List<Object>list3 = new ArrayList<Integer>();
		List<Object> list2 = new ArrayList<>();
		list2.add(1);
		list2.add("juan");

		// we can assigne any type
		List<?> list3 = new ArrayList<Integer>();

		// extends bounded
		List<? extends Number> list4 = new ArrayList<Integer>();
		list4 = new ArrayList<Float>();

		//super bounded
		List<? super Integer> list5 = new ArrayList<Number>();
		// List<? extends Integer> list6 = new ArrayList<Number>();
	}
	
	public static <T> T Fun(T t){
		return t;
	}
}
