package com.easy.leetcode.listNode;

import com.easy.leetcode.ListNode;

/**
 * @ClassName MiddleNode876
 * @Description  876. 链表的中间结点
 * @Author zheng
 * @Date 2021/8/26 17:37
 * @Version 1.0
 **/
public class MiddleNode876 {
    /**
     * @return com.easy.leetcode.listNode.ListNode
     * @Description 876. 链表的中间结点
     * @Date 2021/8/26 14:21
     * @Param [head]
     **/
    public ListNode middleNode(ListNode head) {
        int count = 0;
        ListNode quick = head, slow = head;
        while (quick != null) {
            quick = quick.next;
            count++;
            if (count % 2 == 0) {
                slow = slow.next;
            }
        }
        return slow;
    }

    /**
     * @return com.easy.leetcode.listNode.ListNode
     * @Description 876. 链表的中间结点
     * @Date 2021/8/26 14:21
     * @Param [head]
     **/
    public ListNode middleNode1(ListNode head) {
        ListNode slow = head, quick = head;
        while (quick != null && quick.next != null) {
            quick = quick.next.next;
            slow = slow.next;
        }
        return slow;
    }

}
