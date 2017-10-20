package com.icss.bridge;

public class Client {

	public static void main(String[] args) {
		Shape shape = null;
		
		shape = new SquareShape();
		Color color = new RedColor();
		
		shape.setColor(color);
		
		
		shape.paint();
	}
}
