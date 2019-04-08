package com.easy.service;

public class ShoppingImpl implements Shopping {

    @Override
    public void buyWawa(String userName) {
        System.out.println(userName+"买到了一个wawa");
    }
}
