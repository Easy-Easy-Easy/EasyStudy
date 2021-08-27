package com.easy.leetcode.listNode;

import com.easy.leetcode.ListNode;

/**
 * @ClassName MyHashSet705
 * @Description 705. 设计哈希集合
 * @Author zheng
 * @Date 2021/8/27 10:23
 * @Version 1.0
 **/
public class MyHashSet705 {
    ListNode[] array;
    int length;

    /**
     * Initialize your data structure here.
     */
    public MyHashSet705() {
        length = 628;
        array = new ListNode[length];
    }

    public void add(int key) {
        int index = key % length;
        if (array[index] == null) {
            array[index] = new ListNode(key);
        } else {
            ListNode node = array[index];
            while (node != null) {
                if (node.val == key) {
                    return;
                }
                node = node.next;
            }
            array[index] = new ListNode(key, array[index]);
        }
    }

    public void remove(int key) {
        int index = key % length;
        ListNode head = new ListNode(-1, array[index]);
        ListNode tmp = head;
        while (tmp.next != null) {
            if (tmp.next.val == key) {
                tmp.next = tmp.next.next;
                break;
            }
            tmp = tmp.next;
        }
        array[index] = head.next;
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        int index = key % length;
        if (array[index] == null) {
            return false;
        } else {
            ListNode node = array[index];
            while (node != null) {
                if (node.val == key) {
                    return true;
                }
                node = node.next;
            }
        }
        return false;
    }
}
