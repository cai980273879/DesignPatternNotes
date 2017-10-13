package com.taroballs.test3;
class Student2 implements Cloneable
{
    private String name;
    private int age;
    private Teacher teacher;
    
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

    public Teacher getTeacher()
    {
        return teacher;
    }

    public void setTeacher(Teacher teacher)
    {
        this.teacher = teacher;
    }

    @Override
    public Object clone() throws CloneNotSupportedException
    { // 浅复制时：
        // Object object = super.clone();
        // return object;
    	// 改为深复制：
        Student2 student = (Student2) super.clone();
        // 本来是浅复制，现在将Teacher对象复制一份并重新set进来
        student.setTeacher((Teacher) student.getTeacher().clone());
        return student;
    }
}
