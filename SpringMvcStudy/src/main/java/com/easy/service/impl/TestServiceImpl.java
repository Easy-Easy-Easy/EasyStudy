package com.easy.service.impl;

import com.easy.annotation.EService;
import com.easy.service.ITestService;
@EService
public class TestServiceImpl implements ITestService {
    @Override
    public void test() {
        System.out.println("TestServiceImpl.test");
    }
}
