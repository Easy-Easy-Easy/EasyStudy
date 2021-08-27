package com.easy.leetcode.listNode;

import com.easy.leetcode.ListNode;

/**
 * @ClassName ListNode_141_HasCycle
 * @Description 141:是否存在环形链表
 * @Author zheng
 * @Date 2021/8/26 17:26
 * @Version 1.0
 **/
public class HasCycle141 {
    /**
     * @return boolean
     * @Description 141:是否存在环形链表
     * @Date 2021/8/25 17:14
     * @Param [head]
     **/
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head.next;
        ListNode quick = head.next.next;
        while (quick != null && quick.next != null) {
            if (quick == slow) {
                return true;
            } else {
                slow = slow.next;
                quick = quick.next.next;
            }
        }
        return false;
    }

}
