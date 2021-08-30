package com.easy.leetcode.listNode;

import com.easy.leetcode.ListNode;

/**
 * @ClassName DeleteDuplicates82
 * @Description 82. 删除排序链表中的重复元素 II
 * @Author zheng
 * @Date 2021/8/27 15:18
 * @Version 1.0
 **/
public class DeleteDuplicates82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        head = new ListNode(101, head);
        ListNode quick = head.next;
        ListNode slow = head;
        int duplicateNum = 101;
        while (quick.next != null) {
            if (quick.val == quick.next.val) {
                duplicateNum = quick.val;
            } else {
                if (quick.val != duplicateNum) {
                    slow.next = quick;
                    slow = slow.next;
                }
            }
            quick = quick.next;
        }
        if (quick.val == duplicateNum) {
            slow.next = null;
        } else {
            slow.next = quick;
        }
        return head.next;
    }
}
