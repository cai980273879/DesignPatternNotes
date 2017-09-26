package com.icss;

/**
 * Created by taroballs on 17-9-26.
 */
public class Student {
    private String name;
    private int age;
    private int height;
    private float result;

    public Student(String name, int age, int height, float result) {
        super();
        this.name = name;
        this.age = age;
        this.height = height;
        this.result = result;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", result=" + result +
                '}';
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

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public float getResult() {
        return result;
    }

    public void setResult(float result) {
        this.result = result;
    }
}
