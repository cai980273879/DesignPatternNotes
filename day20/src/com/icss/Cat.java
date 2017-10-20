package com.icss;

/**
 * 具体目标
 * @author J.L.Zhou
 *
 */
public class Cat extends MySubject {

	@Override
	public void cry() {
		System.out.println("猫叫");
		notifyObservers();
	}

	
}
