package com.easy.stack;

/**
 * @ClassName MyLinkNodeStack
 * @Description 链式栈
 * @Author zheng
 * @Date 2021/8/25 14:56
 * @Version 1.0
 **/
public class MyLinkNodeStack {
    LinkNode head;
    int count, length;

    public MyLinkNodeStack(int size) {
        count = 0;
        length = size;
    }

    public boolean push(int value) {
        //总个数
        if (count < length) {
            count++;
            LinkNode tmp = new LinkNode(value);
            tmp.next = head;
            head = tmp;
            return true;
        }
        return false;
    }

    public int pop() {
        if (count > 0) {
            count--;
            int value = head.value;
            LinkNode tmp = head.next;
            head.next = null;
            head = tmp;
            return value;
        }
        return -1;
    }

    public static void main(String[] args) {
        MyLinkNodeStack stack = new MyLinkNodeStack(3);
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

class LinkNode {
    int value;
    LinkNode next;

    public LinkNode(int value) {
        this.value = value;
    }
}