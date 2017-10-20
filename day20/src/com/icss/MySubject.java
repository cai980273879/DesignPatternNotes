package com.icss;

import java.util.ArrayList;
import java.util.List;

/**
 * 抽象观察目标 
 * @author J.L.Zhou
 *
 */
public abstract class MySubject {

	private List<MyObserver> list = new ArrayList<MyObserver>(0);
	
	public void add(MyObserver observer) {
		list.add(observer);
	}
	
	public void remove(MyObserver observer) {
		list.remove(observer);
	}
	
	public abstract void cry();
	
	public void notifyObservers(){
		for(MyObserver observer : list) {
			observer.response();
		}
	}
	
	
	
}
