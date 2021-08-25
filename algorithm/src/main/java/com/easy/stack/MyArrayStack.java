package com.easy.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName MyArrayStack
 * @Description 顺序栈
 * @Author zheng
 * @Date 2021/8/25 9:47
 * @Version 1.0
 **/
public class MyArrayStack {
    private List<Integer> lst;
    private int count;
    private int length;

    public MyArrayStack(int size) {
        length = size;
        lst = new ArrayList<>(length);
        count = 0;
    }

    public boolean push(int value) {
        if (count < length) {
            lst.add(value);
            count++;
            return true;
        }
        return false;
    }

    public int pop() {
        if (count > 0) {
            int val = lst.get(count - 1);
            lst.remove(count - 1);
            count--;
            return val;
        }
        return -1;
    }

    public static void main(String[] args) {
        MyArrayStack stack = new MyArrayStack(3);
        for (int i = 0; i < 4; i++) {
            System.out.println(stack.push(i));
        }
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        for (int i = 0; i < 4; i++) {
            System.out.println(stack.push(i));
        }
    }
}
