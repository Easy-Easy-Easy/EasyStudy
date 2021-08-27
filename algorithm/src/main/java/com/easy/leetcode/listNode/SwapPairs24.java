package com.easy.leetcode.listNode;

import com.easy.leetcode.ListNode;

/**
 * @ClassName SwapPairs24
 * @Description 24. 两两交换链表中的节点
 * @Author zheng
 * @Date 2021/8/27 11:21
 * @Version 1.0
 **/
public class SwapPairs24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tmp = head.next;
        head.next = swapPairs(tmp.next);
        tmp.next = head;
        return tmp;
    }
}
