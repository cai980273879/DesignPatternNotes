package com.icss.singleton;

public class Singleton {
    private static Singleton singleton = new Singleton();//饿汉式单例类
    private Singleton(){

    }
    public static Singleton getInstance(){
        if(singleton == null){//懒汉式单例类
            singleton = new Singleton();
        }
        return singleton;
    }
}
