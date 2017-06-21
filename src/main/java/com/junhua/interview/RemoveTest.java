package com.junhua.interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class RemoveTest {

	public static void main(String[] args) {
		List<String>list = new ArrayList<>();
		list.add("juan1");
		list.add("juan2");
		list.add("juan3");
		list.add("jun5");
		list.add("jun3");
		list.add("juan4");
		
		
		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
//				return o2.compareTo(o1);
				return o1.compareTo(o2);
			}
		});
		
		Iterator<String>it = list.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
}
