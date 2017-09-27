package com.taroballs.mine;

import com.sun.xml.internal.ws.api.ha.StickyFeature;

import java.lang.reflect.Constructor;

public class Refelection获取构造函数 {
    public static void main(String[] args) {
        try{
            Class c = Class.forName("com.taroballs.mine.Person");
            Constructor constructor = c.getDeclaredConstructor(String.class,int.class);
            constructor.setAccessible(true);//设置是否允许访问，因为该构造器是private的，所以要手动设置允许访问
            //constructor.newInstance("taroballs",24);
            System.out.println(constructor.newInstance("taroballs",24).toString());
            //成功调用构造函数，并返回类的变量名：com.taroballs.mine.Person@5e2de80c

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
