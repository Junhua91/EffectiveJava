package com.junhua.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamTest {
	
	public static void main(String[] args) {
		minTest();
		
		findAnyTest();
		
		allMatchTest();
		
		forEachTest();
		
		reduceTest();
		
		reduceTest2();
		
		collectTest();
		
		filterTest();
		
		peekTest();
		
		peekTest2();
		
		mapTest();
		
		matchTest1();

		matchTest2();
	}
	
	
	public static void minTest(){
		// min max
				Stream<String> s = Stream.of("Sunday","Saturday", "Friday","Thurday", "Wendesday");
				Optional<String> optional = s.min((s1,s2)->-(s1.length() - s2.length()));
				optional.ifPresent(System.out::println);
//				System.out.println(optional.isPresent());
	}
	
	public static void findAnyTest(){
		Stream<String> s  = Stream.of("monkey", "gorilla", "bonobo");
		Stream<String> s2 = Stream.generate(()->"findAnyTest");
		s.findAny().ifPresent(System.out::println);
		
		s2.findAny().ifPresent(System.out::println);
	}
	
	/**
	 * allMatch(), anyMatch(), noneMatch()
	 */
	public static void allMatchTest(){
		List<String>list = Arrays.asList("monkey", "2", "chimp");
		Stream<String> s = Stream.generate(()->"infinie");
		Predicate<String> p = x->Character.isLetter(x.charAt(0));
		
		System.out.println(list.stream().allMatch(p));
		System.out.println(list.stream().anyMatch(p));
		System.out.println(list.stream().noneMatch(p));
		
//		System.out.println(s.allMatch(p));
	}
	
	/**
	 * If you want something to happen, you have to 
	 * make it happen in the loop
	 */
	public static void forEachTest(){
		List<String>list = Arrays.asList("Monkey", "Gorilla", "Bonobo");
		list.stream().forEach(s->System.out.println(s+1));
	}
	
	/**
	 * The reduce()method combines a stream into a single object
	 */
	public static void reduceTest(){
		Stream<Integer> s = Stream.of(1,2,3,4,5,6,7,8,9);
		BinaryOperator<Integer> op = (x,y)->x*y;
//		System.out.println(s.reduce(op));
//		System.out.println(s.reduce(10,op));
		System.out.println(s.reduce(10,op,op));
	}
	
	/**
	 * <U> U reduce(U identity,
              BiFunction<U, ? super T, U> accumulator,
              BinaryOperator<U> combiner);
	 */
	public static void reduceTest2(){
		System.out.println(Arrays.asList('w', 'o', 'l', 'f') 
				.stream() 
				.reduce("",(c,s1) -> c + s1, 
				(s2,s3) -> s2 + s3));
	}
	
	/**
	 * it lets us get data out of streams and into another form
	 */
	public static void collectTest(){
		Stream<String> s = Stream.of("w", "o", "l", "f");
		StringBuilder sb = s.parallel().collect(StringBuilder::new, StringBuilder::append,StringBuilder::append);	
		
		System.out.println(sb.toString());
	}
	
	public static void filterTest(){
		Stream<String>s = Stream.of("monkey", "gorilla", "bonobo","monkey1","monkey2");
		s.filter(x->x.startsWith("m")).forEach(System.out::println);
	}
	
	public static void peekTest(){
		Stream<String> stream = Stream.of("black bear", "brown bear", "grizzly","grizzly2"); 
		long count = stream.filter(s -> s.startsWith("g")) 
		.peek(System.out::println).count(); // grizzly 
		System.out.println(count); // 1 
	}
	
	public static void peekTest2(){
		List<Integer> numbers = new ArrayList<>();
		List<Character> letters = new ArrayList<>();
		numbers.add(1);
		letters.add('a');
		Stream<List<?>> stream = Stream.of(numbers, letters);
		
		stream.forEach(System.out::println);;
//		stream.flatMap(l->l.stream()).forEach(System.out::println);;
	}
	
	//map is not a terminal
	public static void mapTest(){
		Stream<String> stream = Stream.iterate("", (s) -> s + "1");
		System.out.println(stream.limit(2).map(x -> x + "2"));
		//java.util.stream.ReferencePipeline$3@27973e9b
	}
	
	
	public static void matchTest1(){
		Predicate<? super String> predicate = s -> s.startsWith("g");
		Stream<String> stream1 = Stream.generate(() -> "growl! ");
		Stream<String> stream2 = Stream.generate(() -> "growl! ");
		boolean b1 = stream1.anyMatch(predicate);
		boolean b2 = stream2.allMatch(predicate);
		System.out.println(b1 + " " + b2);
		// hang
	}
	public static void matchTest2(){
		Predicate<? super String> predicate = s -> s.length() > 3;
		Stream<String> stream = Stream.iterate("-", (s) -> s + s);
		boolean b1 = stream.noneMatch(predicate);
		boolean b2 = stream.anyMatch(predicate);
		System.out.println(b1 + " " + b2);
		//stream has already been operated upon or closed
	}
}
