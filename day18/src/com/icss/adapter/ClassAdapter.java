package com.icss.adapter;
/*
 * 以类作为适配器
 */
public class ClassAdapter extends MiniUSB implements TypeC {

	@Override
	public void powerC() {
		power();
	}

	
}
