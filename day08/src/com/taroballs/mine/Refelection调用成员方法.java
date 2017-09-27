package com.taroballs.mine;

import java.lang.reflect.Method;

/**
 * Created by taroballs on 17-9-26.
 * public Method getDeclaredMethod(String name, Class<?>... parameterTypes) // 得到该类所有的方法，不包括父类的
 * public Method getMethod(String name, Class<?>... parameterTypes) // 得到该类所有的public方法，包括父类的
 */
public class Refelection调用成员方法 {
    public static void main(String[] args) {
        try{
            Class c = Class.forName("com.taroballs.mine.Person");
            Object o = c.newInstance();//调用无参构造方法
            Method method = c.getMethod("fun", String.class , int.class);//获取fun(String,int)方法
            method.invoke(o,"taroballs",24);//注册并调用fun方法
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    /*Result:
    带参数fun方法，我叫taroballs,今年24岁
     */
}
