package com.teacher.example;

public class Student extends Person implements Result{
    public static String className;
    private float result;
    private String num;

    public Student() {
        super();
    }

    public Student(String name, int height, int age, float result, String num) {
        super(name, height, age);
        this.result = result;
        this.num = num;
    }

    public static String getClassName() {
        return className;
    }

    public static void setClassName(String className) {
        Student.className = className;
    }

    public void setResult(float result) {
        this.result = result;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    @Override
    public float getResult() {
        return result;
    }

    @Override
    public String toString() {
        return super.toString()+"Student [result=" + result + ", num=" + num + "]"+className;
    }
}
