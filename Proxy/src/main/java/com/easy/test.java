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
    }
}
