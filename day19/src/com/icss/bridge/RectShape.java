package com.icss.bridge;

public class RectShape extends Shape {

	@Override
	public void paint() {
		System.out.println("绘制"+color.getColor()+"矩形");
	}

}
