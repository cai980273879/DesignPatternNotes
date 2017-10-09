package com.icss.singleton;

public class Client {
    public static void main(String[] args) {
        Singleton singleton = null;

//		singleton = new Singleton();

        for(int i=0;i<100;i++) {
            singleton = Singleton.getInstance();
            System.out.println(singleton);
        }
        /*
        输出同一个对象
        com.icss.singleton.Singleton@5e2de80c
        com.icss.singleton.Singleton@5e2de80c
        com.icss.singleton.Singleton@5e2de80c
         */

    }
}
