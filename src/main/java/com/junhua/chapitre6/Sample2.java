package com.junhua.chapitre6;

public class Sample2 {

	@ExceptionTest(ArithmeticException.class)
	public static void m1(){
		int i;
		i=1/0;
	}
	
	@ExceptionTest(ArithmeticException.class)
	public static void m2(){
		int[] a = new int[0];
		int i = a[1];
	}
	
	@ExceptionTest(ArithmeticException.class)
	public static void m3(){
		
	}
}
