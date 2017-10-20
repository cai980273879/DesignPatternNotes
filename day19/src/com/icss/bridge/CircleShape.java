package com.icss.bridge;

public class CircleShape extends Shape {

	@Override
	public void paint() {
		System.out.println("绘制"+color.getColor()+"圆形");
	}

}
