package com.icss.bridge;

public class OvalShape extends Shape {

	@Override
	public void paint() {
		System.out.println("绘制"+color.getColor()+"椭圆形");
	}

}
