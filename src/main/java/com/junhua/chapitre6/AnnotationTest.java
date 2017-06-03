package com.junhua.chapitre6;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AnnotationTest {

	public static void main(String[] args) throws Exception {
		test1();
	
		test2();
	}

	/*
	 * public static void com.junhua.chapitre6.Sample.m3() faild invalide Testpublic
	 * void com.junhua.chapitre6.Sample.m5() passed: 1, failed: 2
	 */
	public static void test1() throws Exception {
		int tests = 0;
		int passed = 0;
		Class<?> testClass = Class.forName("com.junhua.chapitre6.Sample");
		for (Method method : testClass.getDeclaredMethods()) {
			if (method.isAnnotationPresent(Test.class)) {
				tests++;
				try {
					method.invoke(null);
					passed++;
				} catch (InvocationTargetException e) {
					System.out.println(method + "faild");
				} catch (Exception e) {
					System.out.println("invalide Test" + method);
				}
			}
		}

		System.out.printf("passed: %d, failed: %d", passed, tests - passed);
		System.out.println();
	}

	/**
	 * Test public static void com.junhua.chapitre6.Sample2.m2() failed, expected class java.lang.ArithmeticException, 
	 * but got java.lang.ArrayIndexOutOfBoundsException: 1
		passed: 1, failed: 2
	 * @throws Exception
	 */
	public static void test2() throws Exception{
		int tests =0;
		int passed = 0;
		
		Class<?> testClass = Class.forName("com.junhua.chapitre6.Sample2");
		for(Method m: testClass.getDeclaredMethods()){
			if(m.isAnnotationPresent(ExceptionTest.class)){
				tests++;
				try{
					m.invoke(null);
					}catch(InvocationTargetException e){
						Throwable exec = e.getCause();
						Class<? extends Exception> execType = m.getAnnotation(ExceptionTest.class).value();
						if(execType.isInstance(exec)){
							passed++;
						}else{
							System.out.printf("Test %s failed, expected %s, but got %s", m,execType,exec);
							System.out.println();
						}
					}catch(Exception e){
						System.out.println("invalide test");
					}
			}
		}
		System.out.printf("passed: %d, failed: %d", passed, tests - passed);
	}
}


