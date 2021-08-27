package com.easy.leetcode.listNode;

import com.easy.leetcode.ListNode;

/**
 * @ClassName ListNode_206_ReverseList
 * @Description 206 反转链表
 * @Author zheng
 * @Date 2021/8/26 17:20
 * @Version 1.0
 **/
public class ReverseList206 {
    /**
     * @return com.easy.leetcode.listNode.ListNode
     * @Description 206 反转链表
     * @Date 2021/8/25 17:14
     * @Param [head]
     **/
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
