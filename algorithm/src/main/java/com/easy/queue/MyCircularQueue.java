package com.easy.queue;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName MyCircularQueue
 * @Description 循环队列
 * MyCircularQueue(k): 构造器，设置队列长度为 k 。
 * Front: 从队首获取元素。如果队列为空，返回 -1 。
 * Rear: 获取队尾元素。如果队列为空，返回 -1 。
 * enQueue(value): 向循环队列插入一个元素。如果成功插入则返回真。
 * deQueue(): 从循环队列中删除一个元素。如果成功删除则返回真。
 * isEmpty(): 检查循环队列是否为空。
 * isFull(): 检查循环队列是否已满。
 * @Author zheng
 * @Date 2021/8/23 14:45
 * @Version 1.0
 **/
public class MyCircularQueue {
    int head = 0;
    int[] queueArray;
    int length;

    public MyCircularQueue(int k) {
        head = -1;
        queueArray = new int[k];
        length = 0;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        } else {
            head++;
            length++;
            queueArray[head % queueArray.length] = value;
            return true;
        }
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        length--;
        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        } else {
            return queueArray[(head - length + 1) % queueArray.length];
        }
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        } else {
            return queueArray[head % queueArray.length];
        }
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public boolean isFull() {
        return length == queueArray.length;
    }

    public static void main(String[] args) {
        MyCircularQueue myCircularQueue = new MyCircularQueue(3);
        System.out.println(myCircularQueue.enQueue(1));
        System.out.println(myCircularQueue.enQueue(2));
        System.out.println(myCircularQueue.enQueue(3));
        System.out.println(myCircularQueue.enQueue(4));
        System.out.println(myCircularQueue.Rear());
        System.out.println(myCircularQueue.Front());
    }
}
