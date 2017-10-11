package com.icss.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ATMDynamicProxy implements InvocationHandler{
    private Object obj;

    public ATMDynamicProxy(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object o, Method method, Object[] args) throws Throwable {
        System.out.println("动态代理了"+method.getName()+"方法");
        try {
            return method.invoke(obj, args);
        }catch (Exception e) {
            throw e.getCause();
        }
    }
}
