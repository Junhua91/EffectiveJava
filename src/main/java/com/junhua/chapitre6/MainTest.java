package com.junhua.chapitre6;

public class MainTest {

	public static void main(String[] args) {
//		System.out.println(Operation.values());
		
		System.out.println(Operation.PLUS.toString());
		
		Operation plus = Operation.valueOf("PLUS");
		System.out.println(plus);
	}
}
