package com.chapitre5.item23;

import java.util.ArrayList;
import java.util.List;

public class GenericTest {

	public static void main(String[] args) {
		
		GenericTest test = new GenericTest();
		List<String> s =new ArrayList<>();
//		test.unSafeAdd(s);
//		test.unSafeAdd2(s);
		
		List s2 = new ArrayList<>();
		s2.add("hello");
		
		List<?> s3 = new ArrayList<>();
		s3.add(null);

	}

	
	// sweep of generic 
//	public static String method(List<String> s){
//		System.out.println(s);
//		return "";
//	}
//	
//	public static int method(List<Integer> s){
//		System.out.println(s);
//		return 1;
//	}
	
	//List<String> et List<Object>
//	public void unSafeAdd(List<Object> obj){
//		
//	}
//	
//	public void unSafeAdd2(List obj){
//		
//	}
	
}
