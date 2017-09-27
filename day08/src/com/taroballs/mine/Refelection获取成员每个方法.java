package com.taroballs.mine;

import java.lang.reflect.Method;
public class Refelection获取成员每个方法 {
    public static void main(String[] args) {
        try{
            Class c = Class.forName("com.taroballs.mine.Person");
            Method method[] = c.getDeclaredMethods();//得到该类所有的方法，不包括父类的

            /*
            Method method[] = c.getMethods();//得到该类包括父类的所有的方法

            这里如果把c.getDeclaredMethods();改成c.getMethods();执行结果如下，多了很多方法，以为把Object里面的方法也打印出来了，因为Object是所有类的父类：
            Result:
            getAge
            setAge
            fun
            fun
            getName
            setName
            wait
            wait
            wait
            equals
            toString
            hashCode
            getClass
            notify
            notifyAll
            */
            for(Method m:method){
                System.out.println(m.getName());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /*Result:
    getAge
    setAge
    fun
    fun
    getName
    setName
     */
}
