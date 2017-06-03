package com.junhua.chapitre6;

import java.util.EnumMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.junhua.chapitre6.Herb.Type;

public class EnumMapTest {
 
	static public Herb[] garden = {new Herb("shuixian", Type.ANNUAL), new Herb("rose", Type.ANNUAL), 
			new Herb("lavande" , Type.BIENNIAL), new Herb("Tulipe", Type.PERENNIAL)};
	
	public static void main(String[] args) {
		test1();
		
		test2();
	}
	
	
	public static void test1(){
		
		Set<Herb>[] herbesByType =(Set<Herb>[])new Set[Type.values().length];
		for(int i = 0;i<Type.values().length;i++){
			herbesByType[i] =new HashSet<>();
		}
		
		for(Herb h : garden){
			herbesByType[h.type.ordinal()].add(h);
		}
		
		for(int i = 0;i<Type.values().length;i++){
			System.out.printf("%s: %s%n", Herb.Type.values()[i], herbesByType[i]);
		}
//				ANNUAL: [shuixian, rose]
//				PERENNIAL: [Tulipe]
//				BIENNIAL: [lavande]
	}
	
	public static void test2(){
		Map<Type, Set<Herb>> herbByType = new EnumMap<>(Herb.Type.class);
		for(Type t: Type.values()){
			herbByType.put(t, new HashSet<>());
		}
		for(Herb h : garden){
			herbByType.get(h.type).add(h);
		}
		System.out.println(herbByType);
		//{ANNUAL=[shuixian, rose], PERENNIAL=[Tulipe], BIENNIAL=[lavande]}
	}
}

