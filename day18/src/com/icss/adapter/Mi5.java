package com.icss.adapter;

/*
 * Client类
 */
public class Mi5 {

	public TypeC c;
	
	public static void main(String[] args) {
		Mi5 mi5 = new Mi5();
		//类适配器
		ClassAdapter adapter = new ClassAdapter();
		mi5.c = adapter;
		mi5.c.powerC();//miniUSB正在供电
	
		//对象适配器
		MiniUSB usb = new MiniUSB();
		ObjectAdapter adapter2 = new ObjectAdapter(usb);
		mi5.c = adapter2;
		
		System.out.println("使用TypeC接口充电");
		mi5.c.powerC();
	}
/*
Target：目标抽象类
Adapter：适配器类
Adaptee：适配者类
Client：客户类
适配器模式有对象适配器和类适配器两种实现：
Result:
miniUSB正在供电
使用TypeC接口充电
miniUSB正在供电
 */
}
