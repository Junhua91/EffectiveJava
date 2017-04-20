package com.junhua.stream;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class CollectorsTest {
	
	public static void main(String[] args) {
		testJoin();
		
		testToCollection();
		
		toMapTest();
		
		toMapTest2();
		
		toMapTest3();
		
		groupingByTest();
		
		groupingByTest2();
		
		groupingByTest3();
	}
	
	public static void testJoin(){
		Stream<String> ohMy = Stream.of("lions", "tigers", "bears");
		String result = ohMy.collect(Collectors.joining(", "));
		System.out.println(result); 
	}
	
	public static void testToCollection(){
		Stream<String> ohMy = Stream.of("lions", "tigers", "tears","tasssss");
		TreeSet<String> set = ohMy.filter(s->s.startsWith("t")).collect(Collectors.toCollection(TreeSet::new));
		System.out.println(set);
	}
	
	public static void toMapTest(){
		Stream<String> ohMy = Stream.of("lions", "tigers", "tears","tasssss");
		Map<String,Integer> map = ohMy.collect(Collectors.toMap(s->s,String::length));
		System.out.println(map);
	}
	
	public static  void toMapTest2(){
		Stream<String> ohMy = Stream.of("lions", "tigers", "tears","tasssss");
		Map<Integer, String> map = ohMy.collect(Collectors.toMap(String::length,s->s, (s1,s2)->s1+"@@@"+ s2));
		System.out.println(map);
		System.out.println(map.getClass());
	}
	
	public static  void toMapTest3(){
		Stream<String> ohMy = Stream.of("lions", "tigers", "tears","tasssss");
		Map<Integer, String> map = ohMy.collect(Collectors.toMap(String::length,s->s, (s1,s2)->s1+","+ s2, TreeMap::new));
		System.out.println(map);
		System.out.println(map.getClass());
	}
	
	/**
	 * groupingBy(Function f)
	 */
	public static void groupingByTest(){
		Stream<String> ohMy = Stream.of("lions", "tigers", "tears","tasssss");
		Map<Integer, List<String>> map = ohMy.collect(Collectors.groupingBy(String::length));
		System.out.println(map);
	}
	
	/**
	 * groupingBy(Function f, Collector dc)
	 */
	public static void groupingByTest2(){
		Stream<String> ohMy = Stream.of("lions", "tigers", "tears","tasssss");
		Map<Integer, Set<String>> map = ohMy.collect(Collectors.groupingBy(String::length, Collectors.toSet()));
		System.out.println(map);
		System.out.println(map.getClass());
	}
	
	/**
	 * groupingBy(Function f, Supplier s, Collector dc)
	 */
	public static void groupingByTest3(){
		Stream<String> ohMy = Stream.of("lions", "tigers", "tears","tasssss");
		Map<Integer, Set<String>> map = ohMy.collect(Collectors.groupingBy(String::length, TreeMap::new ,Collectors.toSet()));
		System.out.println(map);
		System.out.println(map.getClass());
	}
}
