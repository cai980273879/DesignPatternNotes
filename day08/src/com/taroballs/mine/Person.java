package com.taroballs.mine;

/**
 * Created by taroballs on 17-9-26.
 */
public class Person {
    private String name;
    private int age;
    private String msg = "Hello Taroballs~!";

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

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(){

    }

    public void fun(){
        System.out.println("无参fun方法");
    }

    public void fun(String name,int age){
        System.out.println("带参数fun方法，我叫"+name+",今年"+age+"岁");
    }
}
