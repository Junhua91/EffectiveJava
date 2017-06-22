package com.junhua.interview;

public class RedCircle extends AbstractDecoratorShape{

	public RedCircle(Shape shape) {
		super(shape);
	}

	@Override
	public void draw() {
		super.draw();
		System.out.println("red");
	}
}
