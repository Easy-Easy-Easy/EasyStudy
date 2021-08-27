package com.easy.leetcode.listNode;

import com.easy.leetcode.ListNode;

import java.util.List;

/**
 * @ClassName RotateRight
 * @Description 61. 旋转链表
 * @Author zheng
 * @Date 2021/8/27 14:18
 * @Version 1.0
 **/
public class RotateRight {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int length = 0;
        ListNode tmp = head;
        while (tmp.next != null) {
            length++;
            tmp = tmp.next;
        }
        tmp.next = head;
        length++;
        k = k % length;
        int move = length - k;
        while (move > 0) {
            move--;
            tmp = tmp.next;
        }
        head = tmp.next;
        tmp.next = null;
        return head;
    }
}
