package com.icss.adapter;
/*
 * 以对象作为适配器
 */
public class ObjectAdapter implements TypeC {
	
	private MiniUSB usb;//适配者实例
	
	

	public ObjectAdapter(MiniUSB usb) {
		super();
		this.usb = usb;
	}



	@Override
	public void powerC() {
		usb.power();
	}

	
}
