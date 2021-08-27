package com.easy.leetcode.listNode;

import com.easy.leetcode.ListNode;

/**
 * @ClassName GetIntersectionNode160
 * @Description TODO
 * @Author zheng
 * @Date 2021/8/27 9:32
 * @Version 1.0
 **/
public class GetIntersectionNode160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
