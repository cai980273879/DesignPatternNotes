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
    { // ǳ����ʱ��
        // Object object = super.clone();
        // return object;
    	// ��Ϊ��ƣ�
        Student2 student = (Student2) super.clone();
        // ������ǳ���ƣ����ڽ�Teacher������һ�ݲ�����set����
        student.setTeacher((Teacher) student.getTeacher().clone());
        return student;
    }
}
