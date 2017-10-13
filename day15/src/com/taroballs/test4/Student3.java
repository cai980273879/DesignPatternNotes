package com.taroballs.test4;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


public class Student3 implements Serializable {
	 private String name;
	    private int age;
	    private Teacher3 teacher;

	    public String getName()
	    {
	        return name;
	    }

	    public void setName(String name)
	    {
	        this.name = name;
	    }

	    public int getAge()
	    {
	        return age;
	    }

	    public void setAge(int age)
	    {
	        this.age = age;
	    }

	    public Teacher3 getTeacher()
	    {
	        return teacher;
	    }

	    public void setTeacher(Teacher3 teacher)
	    {
	        this.teacher = teacher;
	    }

	    public Object deepClone() throws Exception{
	    	//���л�
	    	ByteArrayOutputStream bos = new ByteArrayOutputStream();
	    	ObjectOutputStream oos = new ObjectOutputStream(bos);
	    	
	    	oos.writeObject(this);
	    	
	    	//�����л�
	    	ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
	    	ObjectInputStream ois = new ObjectInputStream(bis);

	    	return ois.readObject();
	    }
}
