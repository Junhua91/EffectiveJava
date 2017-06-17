package com.junhua.interview;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorTest {

	public static void main(String[] args) {
		
		List<Integer> list = Arrays.asList(1,2,3,4,6,7,5);
		ListIterator<Integer>listIterator =  list.listIterator();
		
		
		while(listIterator.hasNext()){
			System.out.println(listIterator.next());
		}
		while(listIterator.hasPrevious()){
			System.out.println(listIterator.previous());
		}
		
	}
}
