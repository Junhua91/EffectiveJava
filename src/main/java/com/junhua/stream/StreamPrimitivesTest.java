package com.junhua.stream;

import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class StreamPrimitivesTest {

	public static void main(String[] args) {
		
		intTest();
	
		doubleStreamTest();
	} 
	
	/**
	 * covert a stream to a intStream
	 */
	public static void intTest(){
		Stream<Integer> s = Stream.of(1,2,3,4,5,6,7,8,9);
//		System.out.println(s.mapToInt(x->x).sum());
		System.out.println(s.mapToInt(x->x).average().getAsDouble());
	}
	
	public static void doubleStreamTest(){
		DoubleStream s = DoubleStream.of(1.0, 1.1, 1.2);
		s.mapToInt(x->(int)x).forEach(System.out::println);
//		s.mapToObj(x->x).forEach(System.out::println);
	}
	
}
