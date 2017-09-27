package com.taroballs.mine;

/**
 * Created by taroballs on 17-9-26.
 */
public class RefelectDemo {
    public static void main(String[] args) throws ClassNotFoundException {
        //第一种：Class c1 = Code.class;
        Class class1 = RefelectDemo.class;//静态变量
        System.out.println(class1.getName());

        //第二种：Class c2 = code1.getClass();
        RefelectDemo demo2 = new RefelectDemo();
        Class class2 = demo2.getClass();//类对象的getClass方法
        System.out.println(class2.getName());

        //第三种：Class c3 = Class.forName();
        Class class3 = Class.forName("com.taroballs.mine.RefelectDemo");//这里为了避免类为找到，ide强制设置抛出异常
        System.out.println(class3.getName());

        /*
        com.taroballs.mine.RefelectDemo
        com.taroballs.mine.RefelectDemo
        com.taroballs.mine.RefelectDemo
         */
    }
}
