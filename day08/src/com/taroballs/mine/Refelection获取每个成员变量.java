package com.taroballs.mine;

import java.lang.reflect.Field;

public class Refelection获取每个成员变量 {
    public static void main(String[] args) {
        try{
            Class c = Class.forName("com.taroballs.mine.Person");
            Field[] fields = c.getDeclaredFields();
            for (Field f:fields){
                System.out.println(f.getName());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    /*Result:
    name
    age
    msg
     */
}
