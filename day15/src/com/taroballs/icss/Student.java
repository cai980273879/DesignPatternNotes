package com.taroballs.icss;

public class Student implements Cloneable{
	private String name;
    private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	 @Override
	    public Object clone() throws CloneNotSupportedException
	    {
	        // ע��˴�Ҫ��protected��Ϊpublic

	        Object object = super.clone();

	        return object;
	    }
}
