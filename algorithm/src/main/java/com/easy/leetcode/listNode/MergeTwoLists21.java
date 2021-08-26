package com.easy.leetcode.listNode;

import com.easy.leetcode.ListNode;

/**
 * @ClassName ListNode_21_MergeTwoLists
 * @Description TODO
 * @Author zheng
 * @Date 2021/8/26 17:26
 * @Version 1.0
 **/
public class MergeTwoLists21 {
    /**
     * @return com.easy.leetcode.listNode.ListNode
     * @Description 21 合并两个有序链表
     * @Date 2021/8/25 17:34
     * @Param [l1, l2]
     **/
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head = new ListNode(-1);
        ListNode tmp = head;
        //两个链表均不为空
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tmp.next = l1;
                l1 = l1.next;
            } else {
                tmp.next = l2;
                l2 = l2.next;
            }
            tmp = tmp.next;
        }
        //l1不为空
        if (l1 != null) {
            tmp.next = l1;
        }
        //l2 不为空
        if (l2 != null) {
            tmp.next = l2;
        }
        return head.next;
    }

}
