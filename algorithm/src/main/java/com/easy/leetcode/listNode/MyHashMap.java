package com.easy.leetcode.listNode;

import com.easy.leetcode.ListNode;

/**
 * @ClassName MyHashMap
 * @Description TODO
 * @Author zheng
 * @Date 2021/8/27 9:41
 * @Version 1.0
 **/
public class MyHashMap {
    HashListNode[] array;
    int length;

    /**
     * Initialize your data structure here.
     */
    public MyHashMap() {
        length = 628;
        array = new HashListNode[628];
    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {
        int index = key % length;
        HashListNode node;
        if (array[index] == null) {
            node = new HashListNode(key, value);
        } else {
            node = array[index];
            while (node != null) {
                if (node.key == key) {
                    node.val = value;
                    return;
                }
                node = node.next;
            }
            node = new HashListNode(key, value, array[index]);
        }
        array[index] = node;
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        int index = key % length;
        if (array[index] == null) {
            return -1;
        } else {
            HashListNode node = array[index];
            while (node != null) {
                if (node.key == key) {
                    return node.val;
                }
                node = node.next;
            }
            return -1;
        }
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        int index = key % length;
        HashListNode head = new HashListNode(-1, -1, array[index]);
        HashListNode tmp = head;
        while (tmp.next != null) {
            if (tmp.next.key == key) {
                tmp.next = tmp.next.next;
                break;
            }
            tmp = tmp.next;
        }
        array[index] = head.next;
    }
}

class HashListNode {
    public int key;
    public int val;
    public HashListNode next;

    HashListNode() {
    }

    public HashListNode(int key, int val) {
        this.key = key;
        this.val = val;
    }

    public HashListNode(int val) {
        this.val = val;
    }

    public HashListNode(int key, int val, HashListNode next) {
        this.key = key;
        this.val = val;
        this.next = next;
    }
}
