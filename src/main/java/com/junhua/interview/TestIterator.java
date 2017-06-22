package com.junhua.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TestIterator {
	
	
	public static void main(String[] args) {
		ArrayList<String> al = new ArrayList<String>(); 
		al.add("C"); 
		al.add("A"); 
		al.add("E"); 
		al.add("B"); 
		al.add("D"); 
		al.add("F"); 
		Collections.reverse(al);
		Iterator<String> it = al.iterator();
		while(it.hasNext()){
			
			System.out.println(it.next());
			it.remove();
		}
		System.out.println(al.isEmpty());
	
		String[]  wordArray =  {"Love Yourself"  , "Alive is Awesome" , "Be in present"};
		List<String> list = Arrays.asList(wordArray);
	
		for (String string : list) {
			System.out.println(string);
		}
		
		Map<Integer, String> map = new HashMap<>();
		map.put(1,"one");
		map.put(2,"two");
		map.put(3,"three");
		map.put(4,"four");
		
		for (Integer i : map.keySet()) {
			System.out.println(i);
			System.out.println(map.get(i));
		}
	}

}
