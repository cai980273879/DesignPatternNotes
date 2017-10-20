package com.icss;

public class Client {

	public static void main(String[] args) {
		MySubject subject = null;
		
		Cat cat = new Cat();
		
		Mouse mouse = new Mouse();
		cat.add(mouse);
		
		Dog dog = new Dog();
		cat.add(dog);
		
		
		cat.cry();
		
	}
}
