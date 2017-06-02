package com.junhua.stream;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
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
		
		groupingByTest4();
		
		partitioningByTest();
		
		partitioningByTest2();
		
		mappingTest();
	}
	
	public static void testJoin(){
		Stream<String> ohMy = Stream.of("lions", "tigers", "bears");
		String result = ohMy.collect(Collectors.joining(", "));
		System.out.println(result); //lions, tigers, bears
	}
	
	public static void testToCollection(){
		Stream<String> ohMy = Stream.of("lions", "tigers", "tears","tasssss");
		TreeSet<String> set = ohMy.filter(s->s.startsWith("t")).collect(Collectors.toCollection(TreeSet::new));
		System.out.println(set);//[tasssss, tears, tigers]
	}
	
	public static void toMapTest(){
		Stream<String> ohMy = Stream.of("lions", "tigers", "tears","tasssss");
		Map<String,Integer> map = ohMy.collect(Collectors.toMap(s->s,String::length));
		System.out.println(map);//{tears=5, lions=5, tasssss=7, tigers=6}
	}
	
	public static  void toMapTest2(){
		Stream<String> ohMy = Stream.of("lions", "tigers", "tears","tasssss");
		Map<Integer, String> map = ohMy.collect(Collectors.toMap(String::length,s->s, (s1,s2)->s1+"@@@"+ s2));
		System.out.println(map);//{5=lions@@@tears, 6=tigers, 7=tasssss}
		System.out.println(map.getClass());//class java.util.HashMap
	}
	
	public static  void toMapTest3(){
		Stream<String> ohMy = Stream.of("lions", "tigers", "tears","tasssss");
		Map<Integer, String> map = ohMy.collect(Collectors.toMap(String::length,s->s, (s1,s2)->s1+","+ s2, TreeMap::new));
		System.out.println(map);//{5=lions,tears, 6=tigers, 7=tasssss}
		System.out.println(map.getClass());//class java.util.TreeMap
	}
	
	/**
	 * groupingBy(Function f)
	 */
	public static void groupingByTest(){
		Stream<String> ohMy = Stream.of("lions", "tigers", "tears","tasssss");
		Map<Integer, List<String>> map = ohMy.collect(Collectors.groupingBy(String::length));
		System.out.println(map);//{5=[tears, lions], 6=[tigers], 7=[tasssss]}
	}
	
	/**
	 * groupingBy(Function f, Collector dc)
	 */
	public static void groupingByTest2(){
		Stream<String> ohMy = Stream.of("lions", "tigers", "tears","tasssss");
		Map<Integer, Set<String>> map = ohMy.collect(Collectors.groupingBy(String::length, Collectors.toSet()));
		System.out.println(map);//{5=[tears, lions], 6=[tigers], 7=[tasssss]}
		System.out.println(map.getClass());//class java.util.HashMap
	}
	
	/**
	 * groupingBy(Function f, Supplier s, Collector dc)
	 */
	public static void groupingByTest3(){
		Stream<String> ohMy = Stream.of("lions", "tigers", "tears","tasssss");
		Map<Integer, Set<String>> map = ohMy.collect(Collectors.groupingBy(String::length, TreeMap::new ,Collectors.toSet()));
		System.out.println(map);//{5=[tears, lions], 6=[tigers], 7=[tasssss]}
		System.out.println(map.getClass());//class java.util.TreeMap
	}
	
	public static void groupingByTest4(){
		Stream<String> ohMy = Stream.of("lions", "tigers", "bears");
		Map<Integer, Long> map = ohMy.collect(Collectors.groupingBy(
		String::length, Collectors.counting()));
		System.out.println(map); // {5=2, 6=1}
	}
	
	/**
	 * partitioningBy(Predicate p)
	 */
	public static void partitioningByTest(){
		Stream<String> s= Stream.of("lions", "tigers", "bears");
		Map<Boolean, List<String>> map = s.collect(Collectors.partitioningBy(ss->ss.length()<=5));
		System.out.println(map);// {false=[tigers], true=[lions, bears]}
	}
	
	/**
	 * partitioningBy(Predicate p, Collector dc)
	 */
	public static void partitioningByTest2(){
		Stream<String> ohMy = Stream.of("lions", "tigers", "bears");
		Map<Boolean, Set<String>> map = ohMy.collect(
		Collectors.partitioningBy(s -> s.length() <= 7, Collectors.toSet()));
		System.out.println(map);// {false=[], true=[lions, tigers, bears]}
	}
	
	/**
	 * mapping(Function f, Collector dc)
	 */
	public static void mappingTest(){
		Stream<String> ohMy = Stream.of("lions", "tigers", "bears");
		Map<Integer, Optional<Character>>map =  ohMy.collect(Collectors.groupingBy(s->s.length(), Collectors.mapping(s->s.charAt(0), Collectors.minBy(Comparator.naturalOrder()))));
		System.out.println(map);//{5=Optional[b], 6=Optional[t]}
	}
	
	
}
