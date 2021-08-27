package com.easy.leetcode.listNode;

import com.easy.leetcode.ListNode;

import javax.xml.soap.Node;

/**
 * @ClassName DeleteDuplicates83
 * @Description 83. 删除排序链表中的重复元素
 * @Author zheng
 * @Date 2021/8/26 17:42
 * @Version 1.0
 **/
public class DeleteDuplicates83 {
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode curent = head;
        while (curent.next != null) {
            if (curent.val == curent.next.val) {
                curent.next = curent.next.next;
            } else {
                curent = curent.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(-1);
        ListNode pre = head;
        int[] arr = new int[]{
                1, 1, 2, 3, 3
        };
        for (int i = 0; i < arr.length; i++) {
            ListNode tmp = new ListNode(arr[i]);
            pre.next = tmp;
            pre = pre.next;
        }

        deleteDuplicates(head.next);
        System.out.println(head);
    }
}
