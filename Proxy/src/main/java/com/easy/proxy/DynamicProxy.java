package com.easy.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy implements InvocationHandler {
    //代理对象
    private Object target;

    public DynamicProxy() {
    }

    public DynamicProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("---------------------------------动态代理执行前 before--------------------------------------");
        Object object = method.invoke(target, args);
        System.out.println("---------------------------------动态代理执行后 after--------------------------------------");
        return object;
    }

    public Object getObject() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }
}
