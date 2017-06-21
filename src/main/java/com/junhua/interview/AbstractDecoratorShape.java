package com.junhua.interview;

public abstract class AbstractDecoratorShape implements Shape {

	private Shape decoratedShap;
	
	public AbstractDecoratorShape(Shape shape) {
		this.decoratedShap = shape;
	}

	@Override
	public void draw() {
		decoratedShap.draw();
	}
}
