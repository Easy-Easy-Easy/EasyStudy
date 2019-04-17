package com.easy;

import com.easy.proxy.DynamicProxy;
import com.easy.proxy.Proxy;
import com.easy.service.Shopping;
import com.easy.service.ShoppingImpl;
import org.junit.Test;

public class test {
    //测试静态代理
    @Test
    public void testProxy() {
        Shopping shopping = new ShoppingImpl();
        Proxy proxy = new Proxy(shopping);
        proxy.buyWawa("王二狗");
    }

    //测试动态代理
    @Test
    public void testDynamicProxy() {
        Shopping shopping = new ShoppingImpl();
        DynamicProxy dynamicProxy = new DynamicProxy(shopping);
        Shopping proxyShopping=(Shopping) dynamicProxy.getObject();
        proxyShopping.buyWawa("王二狗");
        //动态代理的实现原理
        //在调用Proxy.newProxyInstance 方法时，会生成一个名为$Proxy0的类,该类继承了Porxy,实现了传入的接口
        //在每一个方法的调用处,都会调用this.h.invoke 方法,而h对象则为传入的实现了InvocationHandler 的类(DynamicProxy)
        //调用该对象的invoke 方法,就实现了动态代理的整个过程
    }
}
