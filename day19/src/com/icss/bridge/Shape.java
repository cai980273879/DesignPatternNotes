package com.icss.bridge;

public abstract class Shape {

	protected Color color;
	
	
	
	public void setColor(Color color) {
		this.color = color;
	}



	public abstract void paint();
	
}
