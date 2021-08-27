package com.easy.leetcode.listNode;

import com.easy.leetcode.ListNode;

/**
 * @ClassName RemoveElements
 * @Description 移除链表元素
 * @Author zheng
 * @Date 2021/8/26 19:34
 * @Version 1.0
 **/
public class RemoveElements203 {
    /**
     * @return com.easy.leetcode.ListNode
     * @Description 203. 移除链表元素
     * @Date 2021/8/26 19:36
     * @Param [head, val]
     **/
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        head = new ListNode(-1, head);
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.next.val == val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }

        }
        return head.next;
    }
}
