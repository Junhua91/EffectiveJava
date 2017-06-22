package com.junhua.interview;

public class DecoratorPatternTest {
	
	public static void main(String[] args) {
		Shape circle = new Circle();
		circle.draw();
		
		Shape redCircle = new RedCircle(circle);
		redCircle.draw();
	}
}
