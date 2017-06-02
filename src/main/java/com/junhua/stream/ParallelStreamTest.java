package com.junhua.stream;

import java.util.Arrays;
import java.util.stream.Stream;

public class ParallelStreamTest {

	public static void main(String[] args) {
		test1();
	}
	
	// create parallel stream
	public static void createParallelStream(){
		//method 1
		Stream<Integer> stream =  Arrays.asList(1,2,3,4,5,6).stream();
		Stream<Integer> streamParallel = stream.parallel();
		//parallel()is an intermediate operation that operates on the original stream. 
		
		//method 2
		Stream<Integer> streamParallel2 = Arrays.asList(1,2,3,4,5,6).parallelStream();
	}
	
	public static void test1(){
		Stream<Integer> stream = Arrays.asList(1,2,3,4,5,6).stream();
		stream.forEach(s->System.out.println(s));// 1,2,3,4,5,6 serial stream
		
		Stream<Integer> streamParallel = Arrays.asList(1,2,3,4,5,6).parallelStream();
		streamParallel.forEach(s->System.out.println(s));// without order
	}
	
	// Anytime 
	//you are working with a collection with a parallel stream, it is recommended that you use 
	//a concurrent collection
	
}
