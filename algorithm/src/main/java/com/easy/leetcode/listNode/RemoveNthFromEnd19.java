package com.easy.leetcode.listNode;

import com.easy.leetcode.ListNode;

/**
 * @ClassName RemoveNthFromEnd19
 * @Description 19. 删除链表的倒数第 N 个结点
 * @Author zheng
 * @Date 2021/8/26 17:36
 * @Version 1.0
 **/
public class RemoveNthFromEnd19 {
    /**
     * @return com.easy.leetcode.listNode.ListNode
     * @Description 19. 删除链表的倒数第 N 个结点
     * @Date 2021/8/26 9:38
     * @Param [head, n]
     **/
    public ListNode removeNthFromEnd(ListNode head, int n) {
        head = new ListNode(0, head);
        int count = 0;
        ListNode pre = head;
        ListNode tail = head;

        while (tail.next != null) {
            tail = tail.next;
            if (count == n) {
                pre = pre.next;
            } else {
                count++;
            }

        }
        pre.next = pre.next.next;
        return head.next;
    }
}
