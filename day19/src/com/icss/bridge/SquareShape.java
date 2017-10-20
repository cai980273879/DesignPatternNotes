package com.icss.bridge;

public class SquareShape extends Shape {

	@Override
	public void paint() {
		System.out.println("绘制"+color.getColor()+"正方形");
	}

}
