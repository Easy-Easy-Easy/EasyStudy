package com.easy.leetcode.listNode;

import java.util.List;

/**
 * @ClassName Solution
 * @Description 206 反转链表
 * @Author zheng
 * @Date 2021/8/25 16:46
 * @Version 1.0
 **/
public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = null;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = pre;
            pre = head;
            head = tmp;
        }
        return pre;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
