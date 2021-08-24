package com.easy.queue;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName MyQueue
 * @Description TODO
 * @Author zheng
 * @Date 2021/8/23 15:24
 * @Version 1.0
 **/
public class MyQueue {
    List<Integer> queueList;
    int index = 0;

    public MyQueue() {
        queueList = new ArrayList<>();
    }

    /**
     * @return boolean
     * @Description 向队列中插入一个元素
     * @Date 2021/8/23 15:32
     * @Param [value]
     **/
    public boolean enQueue(int value) {
        return queueList.add(value);
    }

    /**
     * @return boolean
     * @Description 删除队列中的元素
     * @Date 2021/8/23 15:33
     * @Param []
     **/
    public boolean deQueue() {
        if (queueList.isEmpty() || index == queueList.size() - 1) {
            return false;
        } else {
            index++;
            return true;
        }
    }

    /**
     * @return int
     * @Description 获取队列的头元素
     * @Date 2021/8/23 15:35
     * @Param []
     **/
    public int front() {
        return queueList.get(index);
    }

    public boolean isEmpty() {
        return queueList.isEmpty() || index == queueList.size() - 1;
    }

}
