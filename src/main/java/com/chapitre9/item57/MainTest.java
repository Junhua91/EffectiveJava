package com.chapitre9.item57;

import java.util.function.Supplier;


public class MainTest {

	String walk = "walk";

	
	//Lambda expressions can access static variables, instance variables, effectively final 
	//method parameters, and effectively final local variables.
	void everyonePlay(boolean baby) {
		String approach = "amble";
		 walk = "run";
//		 approach = "run";
		play(() -> walk);
		play(() -> baby ? "hitch a ride" : "run");
		play(() -> approach);
	}

	void play(Supplier<String> supplier) {
		System.out.println(supplier.get());
	}
	
	public static void main(String[] args) {
		MainTest test = new MainTest();
		test.everyonePlay(false);
	}
}
