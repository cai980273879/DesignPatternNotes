package com.icss.adapter;
/*
 * �Զ�����Ϊ������
 */
public class ObjectAdapter implements TypeC {
	
	private MiniUSB usb;//������ʵ��
	
	

	public ObjectAdapter(MiniUSB usb) {
		super();
		this.usb = usb;
	}



	@Override
	public void powerC() {
		usb.power();
	}

	
}
