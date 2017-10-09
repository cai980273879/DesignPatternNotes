package com.icss.prototype;

public class Student implements Cloneable{
    private String num;
    private String name;
    private int age;
    private ClassInfo classInfo;
    public String getNum() {
        return num;
    }
    public void setNum(String num) {
        this.num = num;
    }
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
    public ClassInfo getClassInfo() {
        return classInfo;
    }
    public void setClassInfo(ClassInfo classInfo) {
        this.classInfo = classInfo;
    }
    @Override
    public String toString() {
        return super.toString()+"[num=" + num + ", name=" + name + ", age=" + age + ", classInfo=" + classInfo + "]";
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Student s = (Student)super.clone();
        s.setClassInfo((ClassInfo)classInfo.clone());
        return s;
    }


}
