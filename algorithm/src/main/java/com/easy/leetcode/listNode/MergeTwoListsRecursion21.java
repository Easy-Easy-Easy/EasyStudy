package com.easy.leetcode.listNode;

import com.easy.leetcode.ListNode;

/**
 * @ClassName mergeTwoListsRecursion
 * @Description 合并两个有序链表 递归
 * @Author zheng
 * @Date 2021/8/26 17:28
 * @Version 1.0
 **/
public class MergeTwoListsRecursion21 {
    /**
     * @return com.easy.leetcode.listNode.ListNode
     * @Description 21 合并两个有序链表 递归
     * @Date 2021/8/25 17:55
     * @Param [l1, l2]
     **/
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
