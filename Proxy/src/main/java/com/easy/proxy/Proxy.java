package com.easy.proxy;

import com.easy.service.Shopping;
//静态代理类
public class Proxy implements Shopping {
    private  Shopping shopping;
    public Proxy(Shopping shopping) {
        this.shopping =shopping;
    }

    @Override
    public void buyWawa(String userName) {
        System.out.println("------------------------------静态代理执行之前 before--------------------------");
        shopping.buyWawa(userName);
        System.out.println("------------------------------静态代理执行之后 after--------------------------");
    }
}

