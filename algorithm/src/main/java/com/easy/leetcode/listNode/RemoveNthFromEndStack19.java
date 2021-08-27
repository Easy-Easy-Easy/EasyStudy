package com.easy.leetcode.listNode;

import com.easy.leetcode.ListNode;

import java.util.Stack;

/**
 * @ClassName RemoveNthFromEndStack19
 * @Description 19. 删除链表的倒数第 N 个结点
 * @Author zheng
 * @Date 2021/8/26 17:35
 * @Version 1.0
 **/
public class RemoveNthFromEndStack19 {
    /**
     * @return com.easy.leetcode.listNode.ListNode
     * @Description 19. 删除链表的倒数第 N 个结点
     * @Date 2021/8/26 9:38
     * @Param [head, n]
     **/
    public ListNode removeNthFromEndStack(ListNode head, int n) {
        head = new ListNode(0, head);
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode tmp = head;
        while (tmp != null) {
            stack.push(tmp);
            tmp = tmp.next;
        }
        int count = 0;
        while (!stack.isEmpty()) {
            ListNode node = stack.pop();
            count++;
            if (count == n + 1) {
                node.next = node.next.next;
                break;
            }
        }
        return head.next;
    }
}
