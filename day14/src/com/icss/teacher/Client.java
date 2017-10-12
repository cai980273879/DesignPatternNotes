package com.icss.teacher;

public class Client {

	public static void main(String[] args) {
		JFactory factory = null;
		JButton btn = null;
		JText text = null;

		factory = new WindowsFactory();
		factory = new LinuxFactory();
		
		btn = factory.getButton();
		text = factory.getText();
		
		System.out.println(btn);
		System.out.println(text);
		/*
		结果:Result
		com.icss.teacher.LinuxButton@5e2de80c
		com.icss.teacher.LinuxText@1d44bcfa
		 */
	}
}
