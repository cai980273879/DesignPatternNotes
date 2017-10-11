package com.icss.proxy;

import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {
        ATM atm = null;

        atm = new ATMImpl();//真实主题
        /*
		 * 静态代理
		 */
        atm = new ATMProxy(atm);//代理主题

        try {
            atm.save(-100);
        }catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace(System.out);
        }

        try {
            atm.save(100);
        }catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace(System.out);
        }
        try {
            atm.pay(500);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            atm.pay(800);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }


    /*
    动态代理
    */
        ATMDynamicProxy atmDynamicProxy = new ATMDynamicProxy(atm);
        atm = (ATM) Proxy.newProxyInstance(
                Thread.currentThread().getContextClassLoader(),//类的加载器
                new Class<?>[]{ATM.class},////需要被代理的接口的类的数组
                atmDynamicProxy//代理的句柄
        );

        try {
            atm.save(-100);
        }catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace(System.out);
        }

        try {
            atm.pay(-1000);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            atm.pay(800);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            atm.pay(500);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println(atm.getMoney());
    }
/*
存款金額不能為負數：-100
java.lang.RuntimeException: 存款金額不能為負數：-100
	at com.icss.proxy.ATMProxy.save(ATMProxy.java:16)
	at com.icss.proxy.Client.main(Client.java:16)
存入100
取出500
取款失败，余额不足。余额：600,取款：800
动态代理了save方法
存款金額不能為負數：-100
java.lang.RuntimeException: 存款金額不能為負數：-100
	at com.icss.proxy.ATMProxy.save(ATMProxy.java:16)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:498)
	at com.icss.proxy.ATMDynamicProxy.invoke(ATMDynamicProxy.java:17)
	at com.sun.proxy.$Proxy0.save(Unknown Source)
	at com.icss.proxy.Client.main(Client.java:51)
动态代理了pay方法
取款失败，余额不足。余额：600,取款：-1000
动态代理了pay方法
取款失败，余额不足。余额：600,取款：800
动态代理了pay方法
取出500
动态代理了getMoney方法
100

 */
}
