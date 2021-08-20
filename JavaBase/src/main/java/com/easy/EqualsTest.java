package com.easy;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @ClassName EqualsTest
 * @Description == 和equals
 * @Author zheng
 * @Date 2021/7/21 16:44
 * @Version 1.0
 **/
public class EqualsTest {
    public static void main(String[] args) {
        String str1 = "111";
        String str2 = "111";
        System.out.println(str1 == str2);
        int a = 1;
        int b = 1;
        System.out.println(a == b);
        Integer c = 128;
        Integer d = 128;
        System.out.println(c == d);
        //ExecutorService executorService=Executors.newFixedThreadPool(1);
    }
}
