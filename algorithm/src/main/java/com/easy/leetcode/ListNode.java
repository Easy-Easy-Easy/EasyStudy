package com.easy.leetcode;

/**
 * @ClassName ListNode
 * @Description 链表
 * @Author zheng
 * @Date 2021/8/26 17:21
 * @Version 1.0
 **/
public class ListNode {
    public int val;
    public ListNode next;

    ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
