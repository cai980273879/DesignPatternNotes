package com.taroballs.mine;

import java.lang.reflect.Constructor;

public class Refelection获取每个构造函数 {
    public static void main(String[] args) {
        try{
            Class c = Class.forName("com.taroballs.mine.Person");
            Constructor[] constructors = c.getDeclaredConstructors();
            for(Constructor constructor:constructors){
                System.out.println(constructor);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    /*Result:
    public com.taroballs.mine.Person()
    public com.taroballs.mine.Person(java.lang.String,int)
     */
}
